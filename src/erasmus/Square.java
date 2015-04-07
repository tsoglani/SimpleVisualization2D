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
public class Square implements Shapes {

    private int posx, posy, radious = 30;
    private static int squareCount;
    private Color color;
    private int count;

    public Square(int posx, int posy, int radious) {
        this.posx = posx;
        this.posy = posy;
        this.radious = radious;

       count= squareCount++;
    }

    public int getRadious() {
        return radious;
    }

    public void setRadious(int radious) {
        this.radious = radious;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public void paintComponent(Graphics g) {
        g.fillRect(posx, posy, radious, radious);

    }

    @Override
    public void setColor(Color c) {
        color = c;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {

        return "square " + count;
    }
}