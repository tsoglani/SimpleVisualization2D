/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erasmus;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author gaitanesnikos
 */
public class CircleOptions extends JDialog {
   private JSlider sliderPosX, sliderPosY, sliderRadious;
    private Circle circle;
    private Canvas2D canvas;
    public CircleOptions(Circle circle, Canvas2D canvas) {
        this.circle = circle;
        this.canvas = canvas;
         setTitle("circle options");
        setLayout(new FlowLayout());
        init();
        add(sliderPosX);
        add(sliderPosY);
    sliderPosX.setToolTipText("change pos x");
    sliderPosY.setToolTipText("change pos Y");
    sliderRadious.setToolTipText("change radious ");
        add(sliderRadious);
        setSize(300, 300);
        setVisible(true);
    }

    private void init() {
        sliderPosX = new JSlider();

        sliderPosY = new JSlider();
        sliderRadious = new JSlider();
        sliderRadious.setMaximum(canvas.getBufImage().getWidth() - sliderPosX.getValue());
        sliderPosY.setMaximum(canvas.getBufImage().getHeight());
        sliderPosX.setMaximum(canvas.getBufImage().getWidth());
        sliderPosX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                circle.setPosx(slider.getValue());
//                   sliderHeight.setMaximum(canvas.getBufImage().getHeight() - sliderPosY.getValue());
//                sliderWidth.setMaximum(canvas.getBufImage().getWidth() - sliderPosX.getValue());
                canvas.repaint();
            }
        });
        sliderPosY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                circle.setPosy(slider.getValue());
//                sliderHeight.setMaximum(canvas.getBufImage().getHeight() - sliderPosY.getValue());
//                sliderWidth.setMaximum(canvas.getBufImage().getWidth() - sliderPosX.getValue());
                
                canvas.repaint();
            }
        });
        sliderRadious.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                circle.setRadious(slider.getValue());
                canvas.repaint();
            }
        });
       
    } 
}
