package erasmus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author gaitanesnikos
 */
public class LoadImage implements ActionListener,Serializable {

    private JFileChooser fileChooser;
    private Fr frame;
    private Canvas2D canvas;

    public LoadImage(Fr frame, Canvas2D canvas, JFileChooser fileChooser) {
        this.frame = frame;
        this.canvas = canvas;
        this.fileChooser = fileChooser;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            ObjectInputStream input;
            int mode = fileChooser.showOpenDialog(null);
            File fileName = fileChooser.getCurrentDirectory();
            if (mode != JFileChooser.CANCEL_OPTION) {

//////                try {
//////
//////
//////                    input = new ObjectInputStream(new FileInputStream(fileName.getAbsolutePath() + "/" + fileChooser.getSelectedFile().getName()));
//////                    Object object = input.readObject();
//////                    if (object instanceof Canvas2D) {
//////                        Canvas2D c2d = (Canvas2D) object;
//////                        canvas.setShape(c2d.getShapes());
//////                        canvas.setMyImages(c2d.getMyImages());
//////                        System.out.println("your picture is succesfull loaded ");
//////                    }
//////
//////                } catch (Exception exeption) {
                    ImageIcon image = new ImageIcon(fileName.getAbsolutePath() + "/" + fileChooser.getSelectedFile().getName());
                    canvas.addImage(image);
                    System.out.println("your image is succesfull loaded if something is wrng check again the image ");
               ///////// }

                canvas.repaint();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
