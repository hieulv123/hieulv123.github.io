package com.t3h.model;


import com.t3h.utils.ImagesLoader;

import java.awt.*;

public class Player extends Pacman {
    private int hp;

    public Player(int x, int y, int hp) {
        super(x, y, UP);
        this.hp = hp;
        images = new Image[4];
        images[0]= ImagesLoader.getImage("pacmanL.gif",getClass());
        images[1]= ImagesLoader.getImage("pacmanR.gif",getClass());
        images[2]= ImagesLoader.getImage("pacmanU.gif",getClass());
        images[3]= ImagesLoader.getImage("pacmanD.gif",getClass());
    }

    public void changeOrient(int newOrient){
        this.orient=newOrient;
    }
}
