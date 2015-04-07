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
public class LineOptions extends JDialog {

    private JSlider sliderPosX, sliderPosY, sliderDestinationPosX, sliderDestinationPosY;
    private Line line;
    private Canvas2D canvas;

    public LineOptions(Line line, Canvas2D canvas) {
        this.line = line;
        this.canvas = canvas;
        setTitle("line options");
        setLayout(new FlowLayout());
        init();
        add(sliderPosX);
        add(sliderPosY);
        sliderPosX.setToolTipText("translate position1 x");
        sliderPosY.setToolTipText("translate position1 y");
        sliderDestinationPosX.setToolTipText("translate position2 x");
        sliderDestinationPosY.setToolTipText("translate position2 y");

        add(sliderDestinationPosX);
        add(sliderDestinationPosY);
        setSize(300, 300);
        setVisible(true);
    }

    private void init() {
        sliderPosX = new JSlider();

        sliderPosY = new JSlider();
        sliderDestinationPosX = new JSlider();
        sliderDestinationPosY = new JSlider();
        sliderDestinationPosX.setMaximum(canvas.getBufImage().getWidth() - sliderPosX.getValue());
        sliderPosY.setMaximum(canvas.getBufImage().getHeight());
        sliderPosX.setMaximum(canvas.getBufImage().getWidth());
        sliderDestinationPosY.setMaximum(canvas.getBufImage().getHeight());
        sliderPosX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                line.setPosx(slider.getValue());
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
                line.setPosy(slider.getValue());
//                sliderHeight.setMaximum(canvas.getBufImage().getHeight() - sliderPosY.getValue());
//                sliderWidth.setMaximum(canvas.getBufImage().getWidth() - sliderPosX.getValue());

                canvas.repaint();
            }
        });
        sliderDestinationPosX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                line.setPosxDestination(slider.getValue());
                canvas.repaint();
            }
        });
        sliderDestinationPosY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider slider = (JSlider) e.getSource();
                System.out.println(slider.getValue());
                line.setPosyDestination(slider.getValue());
                canvas.repaint();
            }
        });

    }

    {
    }
}