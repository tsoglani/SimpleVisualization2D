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
public class RectOptions extends JDialog {

    private JSlider sliderPosX, sliderPosY, sliderWidth, sliderHeight;
    private Rect rect;
    private Canvas2D canvas;
    public RectOptions(Rect rect, Canvas2D canvas) {
        this.rect = rect;
        this.canvas = canvas;
         setTitle("rectangle options");
        setLayout(new FlowLayout());
        init();
        add(sliderPosX);
        sliderPosX.setToolTipText("change pos x");
        add(sliderPosY);
          sliderPosY.setToolTipText("change pos x");
        add(sliderHeight);
        sliderHeight.setToolTipText("change size y");
        add(sliderWidth);
        sliderWidth.setToolTipText("change size x");
        setSize(300, 300);
        setVisible(true);
    }

    private void init() {
        sliderPosX = new JSlider();

        sliderPosY = new JSlider();
        sliderWidth = new JSlider();
        sliderHeight = new JSlider();
        sliderHeight.setMaximum(canvas.getBufImage().getHeight() - sliderPosY.getValue());
        sliderWidth.setMaximum(canvas.getBufImage().getWidth() - sliderPosX.getValue());
        sliderPosY.setMaximum(canvas.getBufImage().getHeight());
        sliderPosX.setMaximum(canvas.getBufImage().getWidth());
        sliderPosX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                rect.setPosx(slider.getValue());
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
                rect.setPosy(slider.getValue());
//                sliderHeight.setMaximum(canvas.getBufImage().getHeight() - sliderPosY.getValue());
//                sliderWidth.setMaximum(canvas.getBufImage().getWidth() - sliderPosX.getValue());
                
                canvas.repaint();
            }
        });
        sliderWidth.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                rect.setWidth(slider.getValue());
                canvas.repaint();
            }
        });
        sliderHeight.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                rect.setHeight(slider.getValue());
                canvas.repaint();
            }
        });
    }
    
}
