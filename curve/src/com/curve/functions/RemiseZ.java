package com.curve.functions;

import com.curve.ui.DessinFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.CubicCurve2D;
import java.util.Vector;

/**
 * Created by donatien on 10/04/14.
 */
public class RemiseZ extends AbstractAction {
    /**
     * Creates an {@code Action}.
     */
    private DessinFrame dessinFrame;
    public RemiseZ(DessinFrame d) {
        dessinFrame=d;
    }
    /**
     * Invoked when an action occurs.
     *

     * @param e
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        dessinFrame.repaint();
        dessinFrame.setPoints(new Vector<Point>());
        dessinFrame.setCurves(new Vector<CubicCurve2D>());
    }
}
