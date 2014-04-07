import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by donatien on 07/04/14.
 */
public class DessinFrame extends JPanel {
    public enum States {
        //les differents états pour la gestion des evenements de la souris
        rien,gauche, milieu, droite, droitedragged, gauchedragged
    }
    private JPanel espace;
    public DessinFrame(){
        espace = new JPanel();
        setPreferredSize(new Dimension(400,400));
        MyListener mia=new MyListener();
        addMouseListener(mia);
    }

    class MyListener extends MouseInputAdapter {
        int x = 0;
        int y = 0;
        Point p0, p1;
        States state=States.rien;

        public void mouseDragged(MouseEvent e) {


        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                state=States.gauche;//bouton gauche pressé

            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            switch(state){
                case gauche: break;
            }
        }

 }
}
