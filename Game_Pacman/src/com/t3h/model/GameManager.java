package com.t3h.model;
import com.t3h.gui.PacFrame;
import com.t3h.utils.SoundLoader;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
;


public class GameManager {
    private ArrayList<Map> arrMaps;
    private Player player;
    private Boss boss;
    private ArrayList<Boss> arrboss;
    private ArrayList<Boss2> arrboss2;
    private ArrayList<Boss3> arrboss3 ;
    private Boss2 boss2;
    private Clip clip;
    protected boolean scare = false;

    public int getScore() {
        return score;
    }


    private int score;

    public void initGame() {
        arrMaps = MapManager.readMap("mappacman.txt");
        player = new Player(366, 560, 3);
        //boss = new Boss(0,0);
        arrboss = new ArrayList<>();
        arrboss2 = new ArrayList<>();
       arrboss3 = new ArrayList<>();
        // arrboss3.add(boss3);
        //arrboss.add(boss);
        // arrboss2.add(boss2);
        generateBoss();

    }
    public void draw(Graphics2D g2d) {
        player.draw(g2d);
        //drawScore(g2d);
        for (Map m : arrMaps) {
            m.draw(g2d);
        }
        for (Boss b : arrboss) {
            b.draw(g2d);
            if (scare) {
                b.draw2(g2d);
                break;
            }
        }
        for (Boss2 b2 : arrboss2) {
            b2.draw(g2d);
            if (scare) {
                b2.draw2(g2d);
            }
        }
        for (Boss3 b3 : arrboss3) {
            b3.draw(g2d);
            if (scare) {
                b3.draw2(g2d);
            }
        }


    }

    public void playerMove(int newOrient) {
        player.changeOrient(newOrient);
        player.move(arrMaps);
    }

    private void generateBoss() {
        Boss boss = new Boss(0, 0);
        Boss2 boss2 = new Boss2(PacFrame.W_FRAME / 2 - 25, 0);
        Boss3 boss3 = new Boss3(PacFrame.W_FRAME / 2 - 25, 350);

        arrboss.add(boss);
        arrboss2.add(boss2);
        arrboss3.add(boss3) ;


    }

    private boolean checkPlayerToFood(Player player) {
        for (int i = arrMaps.size() - 1; i >= 0; i--) {
            int bit = arrMaps.get(i).getBit();
            Rectangle rect = player.getRect().intersection(arrMaps.get(i).getRect());
            if (rect.isEmpty() == false) {
                switch (bit) {
                    case 1:
                        arrMaps.remove(i);
                        score++;
                        SoundLoader.play("pacman_eat.wav");
                        break;
                    case 3:
                        System.out.println("an bot");
                        SoundLoader.play("siren.wav");
                        scare = true;
                        arrMaps.remove(i);
                        score+=5;
                        checkTime();
                        break;

                    case 5:
                        arrMaps.remove(i);
                        SoundLoader.play("pacman_eatfruit.wav");
                        score+=50;
                        break;
                }
                break;
            }
        }
        return false;
    }

    public boolean playerkillboss(Player player) {
        for (int i = arrboss.size() - 1; i >= 0; i--) {
            Rectangle rect = player.getRect().intersection(arrboss.get(i).getRect());
            if (rect.isEmpty() == false) {
                if (scare) {
                    SoundLoader.play("pacman_eatghost.wav");
                    score+=20;
                    arrboss.remove(i);
                }

                System.out.println("Killed");

            }
        }
        return false;
    }

    public boolean playerkillboss2(Player player) {
        //scare=true;
        for (int i = arrboss2.size() - 1; i >= 0; i--) {
            Rectangle rect = player.getRect().intersection(arrboss2.get(i).getRect());
            if (rect.isEmpty() == false) {
                if (scare) {
                    arrboss2.remove(i);
                    score+=20;
                    SoundLoader.play("pacman_eatghost.wav");
                    System.out.println("Killed2");
                }

            }
        }
        return false;
    }

    public boolean playerkillboss3(Player player) {
        //scare=true;
        for (int i = arrboss3.size() - 1; i >= 0; i--) {
            Rectangle rect = player.getRect().intersection(arrboss3.get(i).getRect());
            if (rect.isEmpty() == false) {
                if (scare) {
                    SoundLoader.play("pacman_eatghost.wav");
                    arrboss3.remove(i);
                    score+=20;
                    System.out.println("Killed3");
                }

            }
        }
        return false;
    }
    private long t;
    public void checkTime() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                scare=false;
                return;
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 10,10, TimeUnit.SECONDS);
    }

    public boolean AI() {

        for (int i = arrboss.size() - 1; i >= 0; i--) {
            arrboss.get(i).generateOrient();
            arrboss.get(i).move(arrMaps);
            playerkillboss(player);
            if (arrboss.size() == 0){
                Boss boss = new Boss(0, 620);
                arrboss.add(boss);
            }
            //checkTime();

        }
        for (int i = arrboss2.size() - 1; i >= 0; i--) {
            arrboss2.get(i).generateOrient();
            arrboss2.get(i).move(arrMaps);
            playerkillboss2(player);
            if (arrboss2.size() == 0){
                Boss2 boss2 = new Boss2(365, 620);
                arrboss2.add(boss2);
            }

        }
        for (int i = arrboss3.size() - 1; i >= 0; i--) {
            arrboss3.get(i).generateOrient();
            arrboss3.get(i).move(arrMaps);
            playerkillboss3(player);
            if (arrboss3.size() == 0){
                Boss3 boss2 = new Boss3(730, 620);
                arrboss3.add(boss2);
            }
        }
        return player.checkDie(arrboss, arrboss2,arrboss3) || checkPlayerToFood(player);

    }
}
