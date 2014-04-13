package com.curve.ui;
import com.curve.functions.TraceCourbe;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.CubicCurve2D;
import java.util.Vector;

import static java.lang.Math.abs;

/**
 * Created by donatien on 07/04/14.
 */

public class DessinFrame extends JPanel {

    public enum States {
        //les differents états pour la gestion des evenements de la souris
        rien,gauche, milieu, droite, droitedragged, gauchedragged, echap, editable
    }
    private JPanel espace;

    private Vector<Point> points;

    private Vector<Point> curvepoints;

    private Vector<CubicCurve2D> curves;

    public States getKeyState() {
        return keyState;
    }

    public void setKeyState(States keyState) {
        this.keyState = keyState;
    }

    private States keyState;

    public DessinFrame(){
        setLayout(new BorderLayout());
        keyState=States.rien;
        points=new Vector<Point>();
        curvepoints= new Vector<Point>();
        curves = new Vector<CubicCurve2D>();
        MenuBar m = new MenuBar(this);
        add(m, BorderLayout.NORTH);
        // add(new StateBar(), BorderLayout.SOUTH);
        setPreferredSize(new Dimension(400,400));
        MyListener mia=new MyListener();
        addMouseListener(mia);
        addMouseMotionListener(mia);

    }
    public Vector<Point> getPoints() {
        return points;
    }

    public void setPoints(Vector<Point> points) {
        this.points = points;
    }
    public Vector<CubicCurve2D> getCurves() {
        return curves;
    }

    public void setCurves(Vector<CubicCurve2D> curves) {
        this.curves = curves;
    }
    public Vector<Point> getCurvepoints() {
        return curvepoints;
    }

    public void setCurvepoints(Vector<Point> curvepoints) {
        this.curvepoints = curvepoints;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        int index;

        // couleur
        g2.setColor(Color.BLACK);

        //dessin de tous les points
        for(Point p:points){
            boolean exist=false;
            g2.setColor(Color.BLACK);
            g2.fillRect(p.x, p.y, 5, 5);
            index=points.indexOf(p);
            for(Point cp: curvepoints){
                if (p==cp){
                   exist=true;
                }
            }
            //System.out.println(exist);
            if(index!=0 && exist==false){
                g2.drawLine(points.get(index - 1).x, points.get(index - 1).y, p.x, p.y);
            }
            if(keyState==States.echap){
                g2.drawRect(p.x,p.y,10, 10);
            }
        }

        //dessin de toutes les courbes
        for(CubicCurve2D c: curves){
            g2.draw(c);
        }
        /*
        for(Point p:curvepoints){
            g2.setColor(Color.RED);
            g2.fill(p.x, p.y, 5, 5);
            index=points.indexOf(p);
            for(Point cp: curvepoints){
                if (p!=cp && index!=0){
                    g2.drawLine(points.get(index - 1).x, points.get(index - 1).y, p.x, p.y);
                }
            }
            if(keyState==States.echap){
                g2.drawRect(p.x,p.y,10, 10);
            }
        }*/
    }

    class MyListener extends MouseInputAdapter {
        int x = 0;
        int y = 0;
        Point p0, p1, selected;
        States state=States.rien;

        public void mouseDragged(MouseEvent e) {

            //machine a etat
            switch(state){
                case gauche:
                    for(Point p: points){
                        if(abs(p.x-x)<5 && abs(p.y-y)<5){
                            state=States.gauchedragged;
                        }
                    }
                    break;
                case editable:

                    for(Point p: points){
                        if(p==selected){
                            p.x=e.getX();
                            p.y=e.getY();
                        }
                    }
                    break;
                case gauchedragged:
                    p1=e.getPoint();
                    //e.getComponent().getGraphics().drawLine(x,y,e.getX(),e.getY());
                    break;
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

            if (e.getButton() == MouseEvent.BUTTON1) {
                if(keyState.equals(States.echap)){
                    state=States.editable;//bouton gauche pres
                    for(Point p: points){
                        if(abs(e.getX()-p.x)<10 && abs(e.getY()-p.y)<10){
                            selected=p;
                            System.out.println(p+"selected :"+selected+"point x:"+e.getX()+"point y :"+e.getY());
                        }
                    }
                }else {
                    state=States.gauche;//bouton gauche pressé
                    p0=e.getPoint();
                    x=e.getX();
                    y=e.getY();
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            switch(state){
                case gauche:
                    e.getComponent().getGraphics().fillRect(x,y,5,5);
                    if(points.size()!=0){
                        e.getComponent().getGraphics().drawLine(points.lastElement().x,points.lastElement().y,x,y);
                        //e.getComponent().getGraphics().
                    }
                    points.add(new Point(x,y));
                    break;
                case editable:
                    repaint();

                    break;
                case gauchedragged:

                    e.getComponent().getGraphics().fillRect(p1.x,p1.y,5,5);
                    TraceCourbe t = new TraceCourbe(p0,p1, (DessinFrame) e.getComponent());
                    curves.addElement(t);
                    points.addElement(p1);
                    repaint();break;
                    //g2.draw(t);
            }
        }

    }

}
