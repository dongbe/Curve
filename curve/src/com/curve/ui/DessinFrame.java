package com.curve.ui;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Vector;

import static java.lang.Math.abs;

/**
 * Created by donatien on 07/04/14.
 */

public class DessinFrame extends JPanel {

    public enum States {
        //les differents états pour la gestion des evenements de la souris
        rien,gauche, milieu, droite, droitedragged, gauchedragged,echap, editable
    }
    private JPanel espace;

    private Vector<Point> points;

    public States getKeyState() {
        return keyState;
    }

    public void setKeyState(States keyState) {
        this.keyState = keyState;
    }

    private States keyState;

    public DessinFrame(){
        espace = new JPanel();
        keyState=States.rien;
        points=new Vector<Point>();
        MenuBar m = new MenuBar(this);
        add(m);
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

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // background
        g2.setColor(Color.WHITE);
    }

    class MyListener extends MouseInputAdapter {
        int x = 0;
        int y = 0;
        Point p0, p1, selected;
        States state=States.rien;
        Vector<Point> test;

        public void mouseDragged(MouseEvent e) {

            switch(state){
                case gauche:
                    state=States.gauchedragged; break;
                case editable:
                    test = new Vector<Point>();
                    for(Point p: points){
                        if(p==selected){
                            p.x=e.getX();
                            p.y=e.getY();
                        }
                        test.addElement(p);
                    }
                    break;
                case gauchedragged:
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
                    //p0=e.getPoint();
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
                    }
                    points.add(new Point(x,y));
                    break;
                case editable:

                    setPoints(test);
                    int index=0;
                    for(Point p:points){
                        e.getComponent().getGraphics().fillRect(p.x,p.y,5,5);
                        index=points.indexOf(p);
                        if(index!=0){
                            e.getComponent().getGraphics().drawLine(points.get(index-1).x,points.get(index-1).y,p.x,p.y);
                        }
                    }
                    break;
            }
        }

    }

}
