import javax.swing.*;
import java.awt.event.ActionEvent;

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
    }
}
