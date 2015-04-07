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
public class TrigonOptions extends JDialog {

    private JSlider sliderPosX1, sliderPosX2, sliderPosX3, sliderPosY1, sliderPosY2, sliderPosY3;
    private Trigon trigon;
    private Canvas2D canvas;

    public TrigonOptions(Trigon trigon, Canvas2D canvas) {
        this.trigon = trigon;
        this.canvas = canvas;
        setTitle("trygon options");
        setLayout(new FlowLayout());
        init();
        add(sliderPosX1);
        add(sliderPosY1);
        add(sliderPosX2);
        add(sliderPosY2);
        add(sliderPosX3);
        add(sliderPosY3);
        sliderPosX1.setToolTipText("translate point 1 x");
        sliderPosY1.setToolTipText("translate point 1 y");
        sliderPosX2.setToolTipText("translate point 2 x");
        sliderPosY2.setToolTipText("translate point 2 y");
        sliderPosX3.setToolTipText("translate point 3 x");
        sliderPosY3.setToolTipText("translate point 3 y");

        setSize(300, 300);
        setVisible(true);
    }

    private void init() {
        sliderPosX1 = new JSlider();
        sliderPosX1.setValue(trigon.getPositionsX()[0]);
        sliderPosX2 = new JSlider();
        sliderPosX2.setValue(trigon.getPositionsX()[1]);
        sliderPosX3 = new JSlider();
        sliderPosX3.setValue(trigon.getPositionsX()[2]);
        sliderPosY1 = new JSlider();
        sliderPosY1.setValue(trigon.getPositionsY()[0]);
        sliderPosY2 = new JSlider();
        sliderPosY2.setValue(trigon.getPositionsY()[0]);
        sliderPosY3 = new JSlider();
        sliderPosY3.setValue(trigon.getPositionsY()[0]);
        sliderPosX2.setMaximum(canvas.getBufImage().getWidth());
        sliderPosY1.setMaximum(canvas.getBufImage().getHeight());
        sliderPosY2.setMaximum(canvas.getBufImage().getHeight());
        sliderPosY3.setMaximum(canvas.getBufImage().getHeight());
        sliderPosX1.setMaximum(canvas.getBufImage().getWidth());
        sliderPosX3.setMaximum(canvas.getBufImage().getWidth());
        sliderPosX1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                trigon.setPosx1(slider.getValue());
//                   sliderHeight.setMaximum(canvas.getBufImage().getHeight() - sliderPosY.getValue());
//                sliderWidth.setMaximum(canvas.getBufImage().getWidth() - sliderPosX.getValue());
                canvas.repaint();
            }
        });

        sliderPosX2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                trigon.setPosx2(slider.getValue());
                canvas.repaint();
            }
        });
        sliderPosX3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                trigon.setPosx3(slider.getValue());
                canvas.repaint();
            }
        });
        sliderPosY1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                trigon.setPosy1(slider.getValue());
//                sliderHeight.setMaximum(canvas.getBufImage().getHeight() - sliderPosY.getValue());
//                sliderWidth.setMaximum(canvas.getBufImage().getWidth() - sliderPosX.getValue());

                canvas.repaint();
            }
        });
        sliderPosY2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                trigon.setPosy2(slider.getValue());
//                sliderHeight.setMaximum(canvas.getBufImage().getHeight() - sliderPosY.getValue());
//                sliderWidth.setMaximum(canvas.getBufImage().getWidth() - sliderPosX.getValue());

                canvas.repaint();
            }
        });
        sliderPosY3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                trigon.setPosy3(slider.getValue());
//                sliderHeight.setMaximum(canvas.getBufImage().getHeight() - sliderPosY.getValue());
//                sliderWidth.setMaximum(canvas.getBufImage().getWidth() - sliderPosX.getValue());

                canvas.repaint();
            }
        });
    }
}
