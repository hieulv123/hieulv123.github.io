package com.t3h.model;
import com.t3h.utils.ImagesLoader;

import java.awt.*;
import java.util.Random;

public class Boss2 extends Pacman{
    private Random rd = new Random();
    public Boss2(int x, int y ) {
        super(x,y,DOWN);
        images = new Image[5];
        images[LEFT] = ImagesLoader.getImage("bossred.gif",getClass());
        images[RIGHT] = ImagesLoader.getImage("bossred.gif",getClass());
        images[UP] = ImagesLoader.getImage("bossred.gif",getClass());
        images[DOWN] = ImagesLoader.getImage("bossred.gif",getClass());
        images[SCARE]= ImagesLoader.getImage("ghost/blue/1.png",getClass());

    }

    public void generateOrient(){
        int present  = rd.nextInt(101);
        if (present <= 97){
            return;
        }
        int newOrient = rd.nextInt(4);
        orient = newOrient;
    }
    public Rectangle getRect() {
        Rectangle rect = new Rectangle(x, y, images[orient].getWidth(null)-5, images[orient].getHeight(null)-5);
        return rect;
    }

}
