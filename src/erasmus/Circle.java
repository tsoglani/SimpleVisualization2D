/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erasmus;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author gaitanesnikos
 */
public class Circle implements Shapes {

    private int posX, posY, radious;
private Color color;
private int count;
private static int circleCount;
    public Circle(int posX, int posY, int radious) {
        this.posX = posX;
        this.posY = posY;
        this.radious = radious;
       count= circleCount++;
    }

    @Override
    public int getPosx() {
        return posX;
    }

    @Override
    public int getPosy() {
        return posY;
    }

    public void setPosx(int posX) {
        this.posX = posX;
    }

    public void setPosy(int posY) {
        this.posY = posY;
    }

    public int getRadious() {
        return radious;
    }

    public void setRadious(int radious) {
        this.radious = radious;
    }

    public void paintComponent(Graphics g) {
        g.fillOval(posX, posY, radious, radious);

    }

    @Override
    public void setColor(Color c) {
       color=c;
    }
      @Override
    public Color getColor() {
       return color;
    }
         @Override
    public String toString() {

        return "circle " + count;
    }
}
