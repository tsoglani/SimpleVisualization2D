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
public class SquareOptions extends JDialog {

    private JSlider sliderPosX, sliderPosY, sliderRadious;
    private Square square;
    private Canvas2D canvas;

    public SquareOptions(Square square, Canvas2D canvas) {
        this.square = square;
        this.canvas = canvas;
        setTitle("square options");
        setLayout(new FlowLayout());
        init();
        add(sliderPosX);
        add(sliderPosY);
        add(sliderRadious);
        sliderPosX.setToolTipText("translate position1 x");
        sliderPosY.setToolTipText("translate position1 y");
        sliderRadious.setToolTipText("change size");

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
                square.setPosx(slider.getValue());
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
                square.setPosy(slider.getValue());
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
                square.setRadious(slider.getValue());
                canvas.repaint();
            }
        });

    }
}
