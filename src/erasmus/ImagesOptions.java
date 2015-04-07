/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erasmus;

import java.awt.GridLayout;
import java.io.Serializable;
import javax.swing.JDialog;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author gaitanesnikos
 */
public class ImagesOptions extends JDialog implements Serializable {
    
    private JSlider posX, posY;
    private MyImage myImage;
    private Canvas2D canvas;

    public ImagesOptions(MyImage myImage, Canvas2D canvas) {
        this.myImage = myImage;
        this.canvas = canvas;
         setTitle("image options");
        setLayout(new GridLayout(3, 1));
        init();
        add(posX);
        add(posY);
        posX.setToolTipText("set position x");
         posY.setToolTipText("set position y");
        setSize(300, 300);
        setVisible(true);
    }
    
    private void init() {
        posX = new JSlider();
        posX.setMaximum(canvas.getWidth());
        posY = new JSlider();
        posY.setMaximum(canvas.getHeight());
        posX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                myImage.setPosX(slider.getValue());
                canvas.repaint();
            }
        });
           posY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                myImage.setPosy(slider.getValue());
                canvas.repaint();
            }
        });
    }
}
