/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erasmus;

import java.awt.Color;

/**
 *
 * @author gaitanesnikos
 */
public class Rect implements Shapes {

    private int posx, posy, width, height;
    private static int recCount;
   private Color color;
    private int count;

    public Rect(int posx, int posy, int width, int height) {
        this.posx = posx;
        this.posy = posy;
        this.width = width;
        this.height = height;
        count = recCount++;
    }

    public Rect(int posx, int posy) {
        this(posx, posy, 30, 30);

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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {

        return "rectangle " + count;
    }

    @Override
    public void setColor(Color c) {
        color = c;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
