package com.curve.ui;


import javax.swing.*;

/**
 * Created by donatien on 07/04/14.
 */
public class Fenetre extends JFrame {

    DessinFrame dessinFrame;

    public Fenetre(String titre) {
        dessinFrame = new DessinFrame();
        setContentPane(dessinFrame);
        setTitle(titre);
        setDefaultCloseOperation(3);
        setSize(570, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }
}
