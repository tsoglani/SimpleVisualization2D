/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erasmus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author gaitanesnikos
 */
public class LoadShapes implements ActionListener, Serializable {

    private JFileChooser fileChooser;
    private Fr frame;
    private Canvas2D canvas;

    public LoadShapes(Fr frame, Canvas2D canvas, JFileChooser fileChooser) {
        this.frame = frame;
        this.canvas = canvas;
        this.fileChooser = fileChooser;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            ObjectInputStream input;
            int mode = fileChooser.showOpenDialog(null);
            File fileName = fileChooser.getCurrentDirectory();
            if (mode != JFileChooser.CANCEL_OPTION) {
                if (fileChooser.getSelectedFile().getName().endsWith(".xml")) {
                    loadXml(fileName.getAbsolutePath() + "/" + fileChooser.getSelectedFile().getName());
                } else {
                    System.out.println("NOT XML FILE");
                }


///fileName.getAbsolutePath() + "/" + fileChooser.getSelectedFile().getName()
//////                try {
//////
//////
//////                    input = new ObjectInputStream(new FileInputStream(fileName.getAbsolutePath() + "/" + fileChooser.getSelectedFile().getName()));
//////                    Object object = input.readObject();
//////                    if (object instanceof Canvas2D) {
//////                        Canvas2D c2d = (Canvas2D) object;
//////                        canvas.setShape(c2d.getShapes());
//////                        canvas.setMyImages(c2d.getMyImages());
//////                        System.out.println("your picture is succesfull loaded ");
//////                    }
//////
//////                } catch (Exception exeption) {


                canvas.repaint();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadXml(String path) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(path));
            doc.getDocumentElement().normalize();
            NodeList rectangleNodes = doc.getElementsByTagName("rectangle"); // pernei ta rectangle
            for (int i = 0; i < rectangleNodes.getLength(); i++) {
                Node node = rectangleNodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    int posx, posy, width, height;
                    posx = Integer.parseInt(getValue("posx", element));
                    System.out.println("posx: " + posx);
                    posy = Integer.parseInt(getValue("posy", element));
                    System.out.println("posy: " + posy);
                    width = Integer.parseInt(getValue("width", element));
                    System.out.println("width: " + width);
                    height = Integer.parseInt(getValue("height", element));
                    System.out.println("height: " + getValue("height", element));
                    canvas.addShape(new Rect(posx, posy, width, height));
                }
            }



            NodeList circleNode = doc.getElementsByTagName("circle"); // pernei tous kyklous pou uparxoun sto xml
            for (int i = 0; i < circleNode.getLength(); i++) {
                Node node = circleNode.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    int posx, posy, radious;
                    posx = Integer.parseInt(getValue("posx", element));
                    System.out.println("posx: " + posx);
                    posy = Integer.parseInt(getValue("posy", element));
                    System.out.println("posy: " + posy);
                    radious = Integer.parseInt(getValue("radious", element));
                    System.out.println("radious: " + radious);

                    canvas.addShape(new Circle(posx, posy, radious));
                }
            }



            NodeList squareNode = doc.getElementsByTagName("square"); // pernei ta tetragwna pou yparxoun sto xml
            for (int i = 0; i < squareNode.getLength(); i++) {
                Node node = squareNode.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    int posx, posy, radious;
                    posx = Integer.parseInt(getValue("posx", element));
                    System.out.println("posx: " + posx);
                    posy = Integer.parseInt(getValue("posy", element));
                    System.out.println("posy: " + posy);
                    radious = Integer.parseInt(getValue("radious", element));
                    System.out.println("radious: " + radious);

                    canvas.addShape(new Square(posx, posy, radious));
                }
            }



            NodeList lineNode = doc.getElementsByTagName("line"); // pernei tis lines pou yparxoun sto xml
            for (int i = 0; i < lineNode.getLength(); i++) {
                Node node = lineNode.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    int posx, posy, finalPosx, finalPosy;
                    posx = Integer.parseInt(getValue("posx", element));
                    System.out.println("posx: " + posx);
                    posy = Integer.parseInt(getValue("posy", element));
                    System.out.println("posy: " + posy);
                    finalPosx = Integer.parseInt(getValue("finalPosx", element));
                    System.out.println("finalPosx: " + finalPosx);
                    finalPosy = Integer.parseInt(getValue("finalPosy", element));
                    System.out.println("finalPosy: " + finalPosy);
                    canvas.addShape(new Line(posx, posy, finalPosx, finalPosy));
                }
            }
            
            
               NodeList trigonNode = doc.getElementsByTagName("trygon"); // pernei tis lines pou yparxoun sto xml
            for (int i = 0; i < trigonNode.getLength(); i++) {
                Node node = trigonNode.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    int posx1, posy1, posx2,posy2,posx3,posy3;
                    posx1 = Integer.parseInt(getValue("posx1", element));
                    System.out.println("posx1: " + posx1);
                    posy1 = Integer.parseInt(getValue("posy1", element));
                    System.out.println("posy: " + posy1);
                    
                       posx2 = Integer.parseInt(getValue("posx2", element));
                    System.out.println("posx2: " + posx2);
                    posy2 = Integer.parseInt(getValue("posy2", element));
                    System.out.println("posy2: " + posy2);
                         posx3 = Integer.parseInt(getValue("posx3", element));
                    System.out.println("posx3: " + posx3);
                    posy3 = Integer.parseInt(getValue("posy3", element));
                    System.out.println("posy3: " + posy3);
                    canvas.addShape(new Trigon(posx1, posy1,posx2, posy2,posx3, posy3));
                }
            }



            System.out.println(" loading xml ");
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
    }

    private static String getValue(String tag, Element element) {
        NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }
}
