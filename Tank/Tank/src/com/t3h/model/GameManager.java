package com.t3h.model;

import com.t3h.gui.TankFrame;
import com.t3h.utils.SoundLoader;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private Player player;
    private ArrayList<Boss> arrBoss;
    private ArrayList<Bullet> arrBulletPlayer;
    private ArrayList<Bullet> arrBulletBoss;
    private ArrayList<Map> arrMap;

    public void initGame() { //phương thức khởi tạo game
        SoundLoader.play("enter_game.wav");
        arrMap = MapManager.readMap("map1.txt");
        arrBulletBoss = new ArrayList<>();
        arrBulletPlayer = new ArrayList<>();
        player = new Player(170, 460, 3);
        arrBoss = new ArrayList<>();
        generateBoss();
    }

    public void generateBoss() {//sinh boss
        Boss boss = new Boss(0, 0);
        arrBoss.add(boss);
        Boss boss1 = new Boss(TankFrame.W_FRAME / 2 - 25, 0);
        arrBoss.add(boss1);
        Boss boss2 = new Boss(TankFrame.W_FRAME - 48, 0);
        arrBoss.add(boss2);
    }

    public void draw(Graphics2D g2d) {//phương thức vẽ toàn bộ đối tượng game
        try{
        player.draw(g2d);
        for (Boss b : arrBoss) { //vẽ boss
            b.draw(g2d);
        }
        drawBullet(g2d, arrBulletBoss);
        drawBullet(g2d, arrBulletPlayer);
        player.draw(g2d);
        for (Boss b : arrBoss) {
            b.draw(g2d);
        }
        for (Map m : arrMap) {
            m.draw(g2d);
        }}catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private void drawBullet(Graphics2D g2d, ArrayList<Bullet> arr) { //vẽ đạn
        for (Bullet b : arr) {
            b.draw(g2d);
        }
    }

    public void playerMove(int newOrient) {
        player.changeOrient(newOrient);
        player.move(arrMap);
    }

    public void playerFire() {//khi fire thì ép đạn lên mảng của player
        player.fire(arrBulletPlayer);
    }

    private boolean checkBulletToMap(ArrayList<Bullet> arr) {
        for (int i = arrMap.size() - 1; i >= 0; i--) {
            for (int j = 0; j < arr.size(); j++) {
                int bit = arrMap.get(i).getBit();
                if (bit == 4 || bit == 5) {
                    continue;
                }
                Rectangle rect = arrMap.get(i).getRect().intersection(arr.get(j).getRect());
                if (rect.isEmpty() == false) {
                    switch (bit) {
                        case 1:
                            arrMap.remove(i);
                            arr.remove(j);
                            break;
                        case 2:
                            arr.remove(j);
                            break;
                        case 3:
                            arr.remove(j);
                            return true;
                    }
                    break;
                }
            }

        }
        return false;
    }


    public boolean AI() { //hành động thực hiện tự động
        for (int i = arrBoss.size() - 1; i >= 0; i--) {
            arrBoss.get(i).generateOrient();
            arrBoss.get(i).move(arrMap);
            arrBoss.get(i).fire(arrBulletBoss); //boss tự động bắn
            boolean die = arrBoss.get(i).checkDie(arrBulletPlayer);//check boss die
            if (die) {
                arrBoss.remove(i);
                if (arrBoss.size() <= 2) {//nếu nhỏ hơn 2 thì sinh thêm boss
                    generateBoss();
                }
            }
        }
        moveBullet(arrBulletPlayer);
        moveBullet(arrBulletBoss);
        return player.checkDie(arrBulletBoss)
                || checkBulletToMap(arrBulletBoss)
                ||checkBulletToMap(arrBulletPlayer);// ng chơi die
    }

    private void moveBullet(ArrayList<Bullet> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            boolean move = arr.get(i).move();
            if (move == false) {
                arr.remove(i);
            }
        }
    }

}
