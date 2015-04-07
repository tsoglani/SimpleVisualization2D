/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erasmus;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author gaitanesnikos
 */
public class MyImage implements Serializable {

    private ImageIcon image;
    private int posX, posy, width, height;
    static int x;

    public MyImage(ImageIcon image) {
        this.image = image;
        width = image.getIconWidth();
        height = image.getIconHeight();
        x++;
    }

    public ImageIcon getImageIcon() {
        return image;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
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

//    @Override
//    public String toString() {
//        return "image " + x;
//    }
}
