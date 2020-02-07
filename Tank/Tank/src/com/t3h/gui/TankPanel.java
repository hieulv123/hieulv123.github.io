package com.t3h.gui;

import com.t3h.model.GameManager;
import com.t3h.model.Tank;
import com.t3h.utils.SoundLoader;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class TankPanel extends JPanel implements KeyListener, Runnable { //runable; chỉ định công việc
    private GameManager manager = new GameManager();
    private boolean[] flags = new boolean[256]; //đồng bộ di chuyển/256: tổ hợp phím
   private Clip clip;

    public TankPanel() {
        setBackground(Color.BLACK);
        manager.initGame();
        setFocusable(true);
        addKeyListener(this);
        Thread t = new Thread(this);
        t.start();//cho thread bắt đầu lm việc
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
        manager.draw(g2d);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {//nhấn
//        switch (e.getKeyCode()){ // di chuyển bằng tay
//            case KeyEvent.VK_LEFT:
//                manager.playerMove((Tank.LEFT));
//                break;
//            case KeyEvent.VK_RIGHT:
//                manager.playerMove((Tank.RIGHT));
//                break;
//            case KeyEvent.VK_UP:
//                manager.playerMove((Tank.UP));
//                break;
//            case KeyEvent.VK_DOWN:
//                manager.playerMove((Tank.DOWN));
//                break;
//        }
//        repaint();
        flags[e.getKeyCode()] = true;

    }
    private void checkSoundMove(){
        if (flags[KeyEvent.VK_LEFT]
                ||flags[KeyEvent.VK_RIGHT]
                ||flags[KeyEvent.VK_UP]
                ||flags[KeyEvent.VK_DOWN]){
            if (clip==null){
                clip= SoundLoader.play("move.wav");
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }else{
            if (clip!=null){
                clip.stop();
                clip=null;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {//nhả
        flags[e.getKeyCode()]=false;

    }

    @Override
    public void run() {
        while (true) {//di chuyển chéo no else><có else đi bth
            if (flags[KeyEvent.VK_LEFT]) {
                manager.playerMove(Tank.LEFT);
            } else if (flags[KeyEvent.VK_RIGHT]) {
                manager.playerMove(Tank.RIGHT);
            } else if (flags[KeyEvent.VK_UP]) {
                manager.playerMove(Tank.UP);
            } else if (flags[KeyEvent.VK_DOWN]) {
                manager.playerMove(Tank.DOWN);
            }
            if (flags[KeyEvent.VK_SPACE]) {
                manager.playerFire();
            }
            checkSoundMove();
            boolean isDie = manager.AI();
            if (isDie) { //test chơi lại or ko khi bị die
                int result = JOptionPane.showConfirmDialog(null, "Do you want to replay", "Game over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    flags = new boolean[256];//reset flags
                    manager.initGame();//reset game
                }else{
                    System.exit(0);
                }
            }
            repaint();
            // làm thread chạy chậm lại
            try {
                Thread.sleep(7); //nghỉ theo mini giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
