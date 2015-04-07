package erasmus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

/**
 *
 * @author gaitanesnikos
 */
public class Fr extends JFrame {//implements Runnable 
    
    private JPopupMenu popup;
    private JPanel SceneComponent;
    private JButton canvasBackround;
    private JFileChooser fileChooser;
    private JMenu menu;
    private JMenuItem options;
    private JMenuItem changeColor;
    static String selectedElement;
    private JMenuItem delete;
    private JMenuBar menuBar;
    private JMenuItem loadPicture;
    private JMenuItem savePicture;
    private JMenuItem loadShape;
    private JMenuItem saveShape;
    private JMenuItem exit;
    private JToolBar toolbar;
    private Canvas2D canvas;
    private List list;
    private ArrayList toolbarButtons;
    public static int width = 700, height = 700;

    /**
     *
     */
    public Fr() {
        initialize();
        addMenu();
        add(canvas);
        // canvas.addShape(new Rect(20, 20));
        //canvas.addShape(new Circle(0, 0, 20));
        //  canvas.addShape(new Line());
        //  canvas.addShape(new Square(0,0,20));
        //  canvas.addShape(new Trigon());
        SceneComponent.add(list);
        add(SceneComponent, BorderLayout.BEFORE_FIRST_LINE);
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     *
     */
    private void initialize() {
        menu = new JMenu("menu");
        menuBar = new JMenuBar();
        loadPicture = new JMenuItem("load picture");
        savePicture = new JMenuItem("save picture");
        loadShape = new JMenuItem("load shapes");
        saveShape = new JMenuItem("save shapes");
        changeColor = new JMenuItem("change shape color");
        exit = new JMenuItem("exit");
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        toolbar = new JToolBar();
        SceneComponent = new JPanel();
        popup = new JPopupMenu();
        canvasBackround = new JButton("change canvas backround");
        
        list = new List();
        options = new JMenuItem("options");
        delete = new JMenuItem("delete");
        toolbarButtons = new ArrayList();
        createToolBar();
    }
    
    private void createToolBar() {
        for (int i = 0; i < 5; i++) {
            JButton jButton = null;
            if (i == 0) {
                jButton = new JButton(new ImageIcon("circle.png"));
                jButton.setToolTipText("Circle");
                jButton.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        canvas.addShape(new Circle(0, 0, 20));
                    }
                });
                
            }
            if (i == 1) {
                jButton = new JButton(new ImageIcon("rec.png"));
                jButton.setToolTipText("Rextangle");
                jButton.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        canvas.addShape(new Rect(20, 20));
                    }
                });
            }
            if (i == 2) {
                jButton = new JButton(new ImageIcon("line.png"));
                jButton.setToolTipText("Line");
                jButton.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        canvas.addShape(new Line());
                    }
                });
            }
            if (i == 3) {
                jButton = new JButton(new ImageIcon("square.png"));
                jButton.setToolTipText("Square");
                jButton.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        canvas.addShape(new Square(0, 0, 40));
                    }
                });
            }
            if (i == 4) {
                jButton = new JButton(new ImageIcon("trigon.png"));
                jButton.setToolTipText("Trigon");
                jButton.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        canvas.addShape(new Trigon());
                    }
                });
            }
            
            toolbar.setOrientation(JToolBar.VERTICAL);
            toolbarButtons.add(jButton);
            toolbar.add(jButton);
            
            add(toolbar, BorderLayout.BEFORE_LINE_BEGINS);
        }
        
        
    }

    /**
     *
     */
    private void addMenu() {
        setJMenuBar(menuBar);
        canvas = new Canvas2D(this);
        menuBar.add(menu);
        menu.add(loadPicture);
        menu.add(savePicture);
        menu.add(loadShape);
        menu.add(saveShape);
        menu.add(exit);
        editMenu();
        popup.add(delete);
        popup.add(options);
        delete.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(selectedElement);
                for (int i = 0; i < canvas.getShapes().size(); i++) {
                    if (canvas.getShapes().get(i).toString().equals(selectedElement)) {
                        canvas.getShapes().remove(i);
                        list.remove(selectedElement);
                        canvas.repaint();
                        canvas.validate();
                        repaint();
                        validate();
                        list.validate();
                    }
                }
                for (int i = 0; i < canvas.getMyImages().size(); i++) {
                    if (canvas.getMyImages().get(i).toString().equals(selectedElement)) {
                        canvas.getMyImages().remove(i);
                        list.remove(selectedElement);
                        canvas.repaint();
                        canvas.validate();
                        repaint();
                        validate();
                        list.validate();
                    }
                }
            }
        });
        options.addActionListener(new ActionListener() { //otan patithei to options apo tin list mou

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < canvas.getMyImages().size(); i++) {
                    if (selectedElement.equals(canvas.getMyImages().get(i).toString())) {// an einai eikona 
                        new ImagesOptions((MyImage) canvas.getMyImages().get(i), canvas);
                    }
                }
                
                for (int i = 0; i < canvas.getShapes().size(); i++) { // an einai rectangle
                    if (selectedElement.equals(canvas.getShapes().get(i).toString())) {// an to epilegmeno stoixeio einai ena apo ta sxoimata ( sygrinw ta string tous )
                        if (canvas.getShapes().get(i) instanceof Rect) {
                            new RectOptions((Rect) (canvas.getShapes().get(i)), canvas);
                        }
                        if (canvas.getShapes().get(i) instanceof Circle) {// an einai circle
                            new CircleOptions((Circle) (canvas.getShapes().get(i)), canvas);
                        }
                        if (canvas.getShapes().get(i) instanceof Line) {// an einai line
                            new LineOptions((Line) (canvas.getShapes().get(i)), canvas);
                            
                        }
                        if (canvas.getShapes().get(i) instanceof Square) {// an einai line
                            new SquareOptions((Square) (canvas.getShapes().get(i)), canvas);
                        }
                        if (canvas.getShapes().get(i) instanceof Trigon) {// an einai line
                            new TrigonOptions((Trigon) (canvas.getShapes().get(i)), canvas);
                        }
                    }
                }
            }
        });
        changeColor.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < canvas.getShapes().size(); i++) {
                    if (Fr.selectedElement.equals(canvas.getShapes().get(i).toString())) {
                        ((Shapes) canvas.getShapes().get(i)).setColor(JColorChooser.showDialog(null, "select shape backround", Color.orange));
                    }
                    
                }
            }
        });
        
        
        
    }

    /**
     *
     */
    private void editMenu() {
        loadPicture.addActionListener(new LoadImage(this, canvas, fileChooser));
        savePicture.addActionListener(new SaveImage(this, canvas, fileChooser));
        exit.addActionListener(new Exit());
        saveShape.addActionListener(new SavaShapes(this, canvas, fileChooser));
        loadShape.addActionListener(new LoadShapes(this, canvas, fileChooser));
    }

    /**
     *
     * @param url
     * @return
     */
    public Image getImage(String url) { // pernw mia eikona 
        return getToolkit().getImage(url);
    }

    /**
     * basic kanei update stin lista me ta objects pou einai mesa ston canva mou
     */
    public void updateList() {
        
        
        
        if (canvas.getShapes().size() + canvas.getMyImages().size() == list.getItemCount()) {
            return;
        }
        
        list.removeAll();
        for (int i = 0; i < canvas.getShapes().size(); i++) {// vazw stin list ta onomata twn shapes-images
            final int j = i;
            
            
            list.add(canvas.getShapes().get(i).toString());
            
            list.addMouseListener(optionsElements);
        }
        
        for (int i = 0; i < canvas.getMyImages().size(); i++) {
            final int j = i;
            
            
            list.add(canvas.getMyImages().get(i).toString());
            SceneComponent.add(list);
            list.addMouseListener(optionsElements);
        }
        canvas.repaint();
        repaint();
        validate();
        
    }
    /**
     *
     */
    MouseListener optionsElements = new MouseListener() {
        
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.isPopupTrigger()) {
            }
            
            if (e.getClickCount() == 2) {
                //System.out.println(" show options  ");
                List list = (List) e.getSource();
                selectedElement = list.getSelectedItem();
                boolean isShape = false;
                for (int i = 0; i < canvas.getShapes().size(); i++) {
                    if (Fr.selectedElement.equals(canvas.getShapes().get(i).toString())) {
                        isShape = true;
                    }
                }
                if (isShape) { // an einai shape exei mia parapanw epilogi na allaksei xroma sto sigekrimeno shape
                    popup.add(changeColor);
                } else {
                    popup.remove(changeColor);
                }
                
                popup.show(e.getComponent(), e.getX(), e.getY());
                
            }
        }
        
        @Override
        public void mousePressed(MouseEvent e) {
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
        }
    };
    
////    @Override
////    public void run() {
////        while (true) {
////            try {
////                Thread.sleep(1000);
////                
////               // updateList();
////              
////            } catch (InterruptedException ex) {
////                ex.printStackTrace();
////            }
////        }
////    }
}
