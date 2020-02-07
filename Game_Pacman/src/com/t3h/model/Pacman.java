package com.t3h.model;
import com.t3h.gui.PacFrame;
import java.awt.*;
import java.util.ArrayList;


public abstract class Pacman {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    public static final int SCARE =4;


    protected int x;
    protected int y;
    protected Image[] images;
    protected int orient;
    protected int speed = 1;

    public Pacman(int x, int y, int orient) {
        this.x = x;
        this.y = y;
        this.orient = orient;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(images[orient], x, y, null);

    }
    public void draw2(Graphics2D g2d) {
        g2d.drawImage(images[4], x, y, null);

    }


    public void move(ArrayList<Map> arr) {
        int xR = x;
        int yR = y;
        switch (orient) {
            case LEFT:
                x -= speed;
                break;

            case RIGHT:
                x += speed;
                break;

            case UP:
                y -= speed;
                break;

            case DOWN:
                y += speed;
                break;

        }
        if (x <= 0
                || x >= PacFrame.W_FRAME - images[orient].getWidth(null) - 15
        ) {
            x = xR;

        }
        if (y <= 0
                || y >= PacFrame.H_FRAME - images[orient].getHeight(null) - 38) {
            y = yR;

        }
        if (checkMap(arr) == false) {
            x = xR;
            y = yR;
        }
    }

    private boolean checkMap(ArrayList<Map> arr) {
        for (Map m : arr) {
            if (m.getBit() == 1 || m.getBit()==3 || m.getBit()==5) {
                continue;
            }
            Rectangle rect = getRect().intersection(m.getRect());
            if (rect.isEmpty() == false) {
                return false;
            }
        }
        return true;
    }

    public Rectangle getRect() {
        int w = images[orient].getWidth(null) - 10;
        int h = images[orient].getHeight(null) - 10;
        if (orient == UP || orient == DOWN) {
            w -= 1;
        } else {
            h -= 2;
        }
        Rectangle rect = new Rectangle(x, y, w, h);
        return rect;
    }

    public boolean checkDie(ArrayList<Boss> arr, ArrayList<Boss2> arr2, ArrayList<Boss3> arrboss3) {
        for (int i = 0; i < arr.size(); i++) {
            Rectangle rect = getRect().intersection(arr.get(i).getRect());
            if (rect.isEmpty() == false) {
                arr.remove(i);
                return true;
            }
        }
        for (int i = 0; i < arr2.size(); i++) {
            Rectangle rect = getRect().intersection(arr2.get(i).getRect());
            if (rect.isEmpty() == false) {
                arr2.remove(i);
                return true;
            }
        }
        for (int i = 0; i < arrboss3.size(); i++) {
            Rectangle rect = getRect().intersection(arrboss3.get(i).getRect());
            if (rect.isEmpty() == false) {
                arrboss3.remove(i);
                return true;
            }
        }

        return false;

    }


}
