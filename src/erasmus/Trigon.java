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
public class Trigon implements Shapes {

    private int posx[] = {15, 30, 45}, posy[] = {40, 10, 40}, radious = 3;
    private static int trigonCount;
    private Color color;
    private int count;

    public Trigon() {
        this.posx = posx;
        this.posy = posy;
        this.radious = radious;

        count = trigonCount++;
    }

    public Trigon(int x1, int y1, int x2, int y2, int x3, int y3) {
        posx[0] = x1;
        posx[1] = x2;
        posx[2] = x3;

        posy[0] = y1;
        posy[1] = y2;
        posy[1] = y3;
        count = trigonCount++;
    }

    public int getRadious() {
        return radious;
    }

    public void setRadious(int radious) {
        this.radious = radious;
    }

    @Override
    public int getPosx() {
        return posx[0];
    }

    @Override
    public int getPosy() {
        return posy[0];
    }

    public void setPosx1(int x) {
        posx[0] = x;
    }

    public void setPosx2(int x) {
        posx[1] = x;
    }

    public void setPosx3(int x) {
        posx[2] = x;
    }

    public void setPosy1(int y) {
        posy[0] = y;
    }

    public void setPosy2(int y) {
        posy[1] = y;
    }

    public void setPosy3(int y) {
        posy[2] = y;
    }

    public int[] getPositionsX() {
        return posx;
    }

    public int[] getPositionsY() {
        return posy;
    }

    public void paintComponent(Graphics g) {
        g.fillPolygon(posx, posy, radious);

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

        return "trygon " + count;
    }
}