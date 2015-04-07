package erasmus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author gaitanesnikos
 */
public class SaveImage implements ActionListener,Serializable {
    
    private JFileChooser fileChooser;
    private Fr frame;
    private Canvas2D canvas;
    
    public SaveImage(Fr frame, Canvas2D canvas, JFileChooser fileChooser) {
        this.frame = frame;
        this.fileChooser = fileChooser;
        this.canvas = canvas;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
              
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            ObjectOutputStream output;
            int mode = fileChooser.showSaveDialog(frame);
            File fileName = fileChooser.getCurrentDirectory();
            if (mode != JFileChooser.CANCEL_OPTION) {
                
                
//                System.out.println("you save your File at :" + fileName.getAbsolutePath());
//                System.out.println("your File's name is " + fileChooser.getSelectedFile().getName());
//                output = new ObjectOutputStream(new FileOutputStream(fileName.getAbsolutePath() + "/" + fileChooser.getSelectedFile().getName() + ".xml"));
//                output.writeObject(canvas);
//              
//                output.close();
                
                 File outputfile = new File(fileName.getAbsolutePath() + "/" + fileChooser.getSelectedFile().getName()+".png");
                ImageIO.write(canvas.getBufImage(), "png", outputfile);
                
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
           ex.printStackTrace();
        }catch (Exception ex) {
           ex.printStackTrace();
        }
    }
}
