package erasmus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gaitanesnikos
 */
public class SavaShapes implements ActionListener, Serializable {

    private JFileChooser fileChooser;
    private Fr frame;
    private Canvas2D canvas;

    public SavaShapes(Fr frame, Canvas2D canvas, JFileChooser fileChooser) {
        this.frame = frame;
        this.fileChooser = fileChooser;
        this.canvas = canvas;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            ObjectOutputStream output;
            int mode = fileChooser.showSaveDialog(frame);
            File fileName = fileChooser.getCurrentDirectory();
            if (mode != JFileChooser.CANCEL_OPTION) {


//                System.out.println("you save your File at :" + fileName.getAbsolutePath());
//                System.out.println("your File's name is " + fileChooser.getSelectedFile().getName());
//                output = new ObjectOutputStream(new FileOutputStream(fileName.getAbsolutePath() + "/" + fileChooser.getSelectedFile().getName() + ".xml"));
//                output.writeObject(canvas);
//              
//                output.close();


                XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
                // Create XMLEventWriter
                XMLEventWriter eventWriter = outputFactory
                        .createXMLEventWriter(new FileOutputStream(fileName.getAbsolutePath() + "/" + fileChooser.getSelectedFile().getName() + ".xml"));
                // Create a EventFactory
                XMLEventFactory eventFactory = XMLEventFactory.newInstance();
                XMLEvent end = eventFactory.createDTD("\n");
                // Create and write Start Tag
                StartDocument startDocument = eventFactory.createStartDocument();
                eventWriter.add(startDocument);

                // Create config open tag
                StartElement shapesElements = eventFactory.createStartElement("", "", "shapes");
                StartElement circleElements = eventFactory.createStartElement("", "", "circle");
                StartElement recElements = eventFactory.createStartElement("", "", "rectangle");
                StartElement lineElements = eventFactory.createStartElement("", "", "line");
                StartElement trigonElements = eventFactory.createStartElement("", "", "trygon");
                StartElement squareElements = eventFactory.createStartElement("", "", "square");
                eventWriter.add(shapesElements);
                eventWriter.add(end);
                
                
                
                for (int i = 0; i < canvas.getShapes().size(); i++) {// pernaw sto arxeio mou ta shapes pou iparxoun     
                    Shapes shape = (Shapes) canvas.getShapes().get(i);
                    if (shape instanceof Circle) {
                        eventWriter.add(circleElements);
                        eventWriter.add(end);
                        Circle circle = (Circle) shape;
                        createNode(eventWriter, "posx", Integer.toString(circle.getPosx()));
                        createNode(eventWriter, "posy", Integer.toString(circle.getPosy()));
                        createNode(eventWriter, "radious", Integer.toString(circle.getRadious()));
                        eventWriter.add(eventFactory.createEndElement("", "", "circle"));
                    }
                    if (shape instanceof Square) {
                        eventWriter.add(squareElements);
                        eventWriter.add(end);
                        Square square = (Square) shape;
                        createNode(eventWriter, "posx", Integer.toString(square.getPosx()));
                        createNode(eventWriter, "posy", Integer.toString(square.getPosy()));
                        createNode(eventWriter, "radious", Integer.toString(square.getRadious()));
                        eventWriter.add(eventFactory.createEndElement("", "", "square"));
                    }
                    if (shape instanceof Line) {
                        eventWriter.add(lineElements);
                        eventWriter.add(end);
                        Line line = (Line) shape;
                        createNode(eventWriter, "posx", Integer.toString(line.getPosx()));
                        createNode(eventWriter, "posy", Integer.toString(line.getPosy()));
                        createNode(eventWriter, "finalPosx", Integer.toString(line.getPosxDestination()));
                        createNode(eventWriter, "finalPosy", Integer.toString(line.getPosyDestination()));
                        eventWriter.add(eventFactory.createEndElement("", "", "line"));
                    }
                    if (shape instanceof Rect) {
                        eventWriter.add(recElements);
                        eventWriter.add(end);
                        Rect rect = (Rect) shape;
                        createNode(eventWriter, "posx", Integer.toString(rect.getPosx()));
                        createNode(eventWriter, "posy", Integer.toString(rect.getPosy()));
                        createNode(eventWriter, "width", Integer.toString(rect.getWidth()));
                        createNode(eventWriter, "height", Integer.toString(rect.getHeight()));
                        eventWriter.add(eventFactory.createEndElement("", "", "rectangle"));
                    }
                    if (shape instanceof Trigon) {
                        eventWriter.add(trigonElements);
                        eventWriter.add(end);
                        Trigon trigon = (Trigon) shape;
                        createNode(eventWriter, "posx1", Integer.toString(trigon.getPositionsX()[0]));
                        createNode(eventWriter, "posy1", Integer.toString(trigon.getPositionsY()[0]));
                        createNode(eventWriter, "posx2", Integer.toString(trigon.getPositionsX()[1]));
                        createNode(eventWriter, "posy2", Integer.toString(trigon.getPositionsY()[1]));
                        createNode(eventWriter, "posx3", Integer.toString(trigon.getPositionsX()[2]));
                        createNode(eventWriter, "posy3", Integer.toString(trigon.getPositionsY()[2]));

                        eventWriter.add(eventFactory.createEndElement("", "", "trygon"));
                    }

                }



                eventWriter.add(eventFactory.createEndElement("", "", "shapes"));
                eventWriter.add(end);
                eventWriter.add(eventFactory.createEndDocument());
                eventWriter.close();




                ///


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createNode(XMLEventWriter eventWriter, String name,
            String value) throws XMLStreamException {

        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");
        // Create Start node
        StartElement sElement = eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        // Create Content
        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);
        // Create End node
        EndElement eElement = eventFactory.createEndElement("", "", name);
        eventWriter.add(eElement);
        eventWriter.add(end);

    }
}
