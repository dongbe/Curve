package com.curve.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by donatien on 11/04/14.
 */
public class StateBar extends JPanel {
    public StateBar(){
        //setLayout(new BorderLayout());
        JToggleButton mode = new JToggleButton();
        mode.setPreferredSize(new Dimension(45,25));
        add(mode);
    }
}
