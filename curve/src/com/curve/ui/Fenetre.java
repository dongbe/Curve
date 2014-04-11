package com.curve.ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        MyKeyListener km = new MyKeyListener();
        addKeyListener(km);
        pack();
    }
    class MyKeyListener extends KeyAdapter {
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            if(dessinFrame.getKeyState()!=DessinFrame.States.echap){
                dessinFrame.setKeyState(DessinFrame.States.echap);
                for(Point p: dessinFrame.getPoints()){
                    e.getComponent().getGraphics().drawRect(p.x,p.y,10, 10);
                }
            }else{
                dessinFrame.setKeyState(DessinFrame.States.rien);
            }
        }
    }
}
