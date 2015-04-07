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
public class Line implements Shapes{
private int posx, posy, posxDestination,posyDestination;
private Color color;
private static int lineCount;
private int count;
    public Line() {
      this(0,0,20,20);
    }

    public Line(int posx, int posy, int posxDestination, int posyDestination) {
        this.posx = posx;
        this.posy = posy;
        this.posxDestination = posxDestination;
        this.posyDestination = posyDestination;
        lineCount++;
        count=lineCount;
        System.out.println(count);
    }



    @Override
    public int getPosx() {
        return posx;
    }

    @Override
    public int getPosy() {
        return posy;
    }

    public int getPosxDestination() {
        return posxDestination;
    }

    public void setPosxDestination(int posxDestination) {
        this.posxDestination = posxDestination;
    }

    public int getPosyDestination() {
        return posyDestination;
    }

    public void setPosyDestination(int posyDestination) {
        this.posyDestination = posyDestination;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
    /**
     * 
     * @param g 
     */
      public void paintComponent(Graphics g) {
        g.drawLine(posx, posy, posxDestination, posyDestination);

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

        return "line " + count;
    }
}
