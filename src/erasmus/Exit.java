package erasmus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gaitanesnikos
 */
public class Exit implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("thanks for using the program ");
        System.exit(0);
    }
}
