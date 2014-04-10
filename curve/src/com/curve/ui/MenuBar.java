/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curve.ui;
import com.curve.functions.RemiseZ;

import javax.swing.*;

/**
 *
 * @author toure
 */
public class MenuBar extends JMenuBar{
    public MenuBar(DessinFrame d) {
        JMenu exp = new JMenu("Edition");
        JMenuItem remz = new JMenuItem();
        remz.setAction(new RemiseZ(d));
        remz.setText("Remise a zero");
        exp.add(remz);
        add(exp);
    }
}
