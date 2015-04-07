package erasmus;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author gaitanesnikos
 */
public class Canvas2D extends Canvas implements Serializable {

    private BufferedImage bufferedImage;
    private ImageIcon image;
    private Color backround = Color.white;
    private Color shapeBackround = Color.black;
    private ArrayList<Shapes> shapes = new ArrayList<Shapes>();
    private ArrayList<MyImage> myImages = new ArrayList<MyImage>();
    Fr frame;

    public Canvas2D(Fr frame) {
        this.frame = frame;
        bufferedImage = new BufferedImage(Fr.width, Fr.height, BufferedImage.TYPE_INT_RGB);
    }

    /**
     *
     * @param g
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Graphics BIG = bufferedImage.createGraphics();

        BIG.setColor(backround);
        BIG.fillRect(0, 0, Fr.width, Fr.height);// kanei aspro to backround

        BIG.setColor(shapeBackround);

        if (!shapes.isEmpty()) {    // an i lista me ta sximata(shapes ) den einai adeia ( exei mesa antikeimena ( tetragwna trigona koiklous ....))
            for (int i = 0; i < shapes.size(); i++) {
                BIG.setColor(shapeBackround);
                g.setColor(shapeBackround);
                if (shapes.get(i).getColor() != null) {
                    BIG.setColor(shapes.get(i).getColor());
                }
                if (shapes.get(i) instanceof Rect) {// ama valw tetrgwnw na to zografisei
                    Rect rect = (Rect) shapes.get(i);
                    BIG.fillRect(rect.getPosx(), rect.getPosy(), rect.getWidth(), rect.getHeight());// draw rectangle
                    g.fillRect(rect.getPosx(), rect.getPosy(), rect.getWidth(), rect.getHeight());// draw rect if get out of limits

                    if (Fr.selectedElement != null && Fr.selectedElement.equals(rect.toString())) {
                        BIG.drawRect(rect.getPosx() - 5, rect.getPosy() - 5, rect.getWidth() + 10, rect.getHeight() + 10);// if is selected draw  which one is selected
                        g.drawRect(rect.getPosx() - 5, rect.getPosy() - 5, rect.getWidth() + 10, rect.getHeight() + 10);// if is selected draw  which one is selected if get out of limits
                    }
                }
                if (shapes.get(i) instanceof Circle) {
                    Circle circle = (Circle) shapes.get(i);
                    circle.paintComponent(BIG);
                }

                if (shapes.get(i) instanceof Line) {
                    Line line = (Line) shapes.get(i);
                    line.paintComponent(BIG);
                }
                if (shapes.get(i) instanceof Square) {
                    Square square = (Square) shapes.get(i);
                    square.paintComponent(BIG);
                }
                if (shapes.get(i) instanceof Trigon) {
                    Trigon trigon = (Trigon) shapes.get(i);
                    trigon.paintComponent(BIG);
                }
            }
        }
        if (!myImages.isEmpty()) {    // an i lista me ta sximata(shapes ) den einai adeia ( exei mesa antikeimena ( tetragwna trigona koiklous ....))
            for (int i = 0; i < myImages.size(); i++) {
                BIG.drawImage(myImages.get(i).getImageIcon().getImage(), myImages.get(i).getPosX(), myImages.get(i).getPosy(), myImages.get(i).getWidth(), myImages.get(i).getHeight(), null);
                // myImages.get(i);

            }
        }

        if (shapes.isEmpty() && myImages.isEmpty()) {
            BIG.setColor(backround);
            g.setColor(backround);
            BIG.fillRect(0, 0, getWidth(), getHeight());
        }

        g2d.drawImage(bufferedImage, null, 0, 0);
    }

    public ImageIcon getImage() {
        return image;
    }

    public void addImage(ImageIcon image) {
        myImages.add(new MyImage(image));
        // frame.updateList();
//        frame.validate();
        this.image = image;
        frame.updateList();
    }

    public Color getCanvasBackround() {
        return backround;
    }

    public void setCanvasBackround(Color backround) {
        this.backround = backround;
    }

    public ArrayList getShapes() {
        return shapes;
    }

    public <MyImage> ArrayList getMyImages() {
        return myImages;
    }

    public void setMyImages(ArrayList<MyImage> myImages) {
        this.myImages = myImages;
    }

    public void setShape(ArrayList elements) {
        this.shapes = elements;
    }

    public void addShape(Shapes shape) {
        this.shapes.add(shape);
        frame.updateList();
    }

    public void setShapeBackround(Color shapeBackround) {
        this.shapeBackround = shapeBackround;
    }

    public BufferedImage getBufImage() {

        return bufferedImage;
    }
}
