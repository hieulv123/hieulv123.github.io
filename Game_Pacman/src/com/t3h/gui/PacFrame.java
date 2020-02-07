package com.t3h.gui;

import javax.swing.*;
import java.awt.*;

public class PacFrame extends JFrame {
    public static final int W_FRAME = 790;
    public static final int H_FRAME = 710;

    public PacFrame() {
        setTitle("Pac__Man");
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        PacPanel h = new PacPanel();
        add(h) ;
    }
}
