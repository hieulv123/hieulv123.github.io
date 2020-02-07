package com.t3h.model;
import com.t3h.utils.ImagesLoader ;
import java.awt.*;

public class Map {


        private int x;
        private int y;
        private int bit;


        public Map(int x, int y, int bit) {
            this.x = x;
            this.y = y;
            this.bit = bit;
        }

        private Image[] images = {
                ImagesLoader.getImage("2.png", getClass()),
                ImagesLoader.getImage("1.png", getClass()),
                ImagesLoader.getImage("0.png", getClass()),
                ImagesLoader.getImage("ghost/cyan/1.png", getClass()),
                ImagesLoader.getImage("4.png", getClass()),
                ImagesLoader.getImage("9.png", getClass()),
                ImagesLoader.getImage("map segments/26.png", getClass())
        };

        public void draw(Graphics2D g2d) {
            g2d.drawImage(images[bit - 1], x, y, null);
        }

        public int getBit() {

            return bit;
        }

        public Rectangle getRect() {
            int w = images[bit - 1].getHeight(null);
            int h = images[bit - 1].getHeight(null);
            return new Rectangle(x, y, w, h);
        }

    }
