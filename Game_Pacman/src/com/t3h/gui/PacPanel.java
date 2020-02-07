package com.t3h.gui;

import com.t3h.model.GameManager;
import com.t3h.model.Map;
import com.t3h.model.Pacman;
import com.t3h.utils.SoundLoader;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class PacPanel extends JPanel implements KeyListener,Runnable {



    private GameManager manager = new GameManager();
    private boolean[] flag = new boolean[256];
    private ArrayList<Map> arrMaps;
    private Clip clip;

    public PacPanel() {
        setBackground(Color.BLACK);
        manager.initGame();
        setFocusable(true);
        addKeyListener(this);
        Thread t = new Thread(this);
        t.start();//cho thread bắt đầu lm việc
    }


    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);
        manager.draw(g2d);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        flag[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        flag[e.getKeyCode()] = false;
    }
    private void checkSoundMove() {
        if (flag[KeyEvent.VK_LEFT]
                || flag[KeyEvent.VK_RIGHT]
                || flag[KeyEvent.VK_UP]
                || flag[KeyEvent.VK_DOWN]) {
            if (clip == null) {
                clip = SoundLoader.play("pac6.wav");
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }else {
            if (clip != null) {
                clip.stop();
                clip = null;
            }
        }
    }
    @Override
    public void run() {
        while (true) {
            if (flag[KeyEvent.VK_LEFT]) {
                manager.playerMove(Pacman.LEFT);
            } else if (flag[KeyEvent.VK_RIGHT]) {
                manager.playerMove(Pacman.RIGHT);
            } else if (flag[KeyEvent.VK_UP]) {
                manager.playerMove(Pacman.UP);
            } else if (flag[KeyEvent.VK_DOWN]) {
                manager.playerMove(Pacman.DOWN);
            }
            checkSoundMove();
            boolean isdie = manager.AI();
            // boolean isdie = manager.die();
            if (isdie) {
                System.out.println("Your Score : "+manager.getScore());
                SoundLoader.play("pacman_lose.wav");
                int result = JOptionPane.showConfirmDialog(null,
                        "Your Score : "+manager.getScore()+" \n Chơi tiếp?",
                        "Replay?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    flag = new boolean[256];
                    manager.initGame();
                } else {
                    System.exit(0);
                }
            }
            repaint();
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
