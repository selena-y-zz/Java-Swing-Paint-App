package drawApp;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class drawCanvas extends JPanel implements KeyListener, ClipboardOwner {
    colorPicker cp;
    thicknessChooser tc;

    private Point startPoint;
    private Point endPoint;
    private Point tempPoint;
    private Point tempPoint2;
    private int index;


    private Rectangle rec;
    private Ellipse2D.Double circle;
    private Line2D.Double aLine;

    //array of all shapes drawn
    private ArrayList<MyShapes> RCL = new ArrayList<>();


    private String selectedTool; //the selected button from drawTools
    private Color selectedColor; //the selected color from colorPicker
    private int selectedThick; // the selected thickness from thicknessChooser


    public drawCanvas(String selected, Color c, int thick) {
        this.setFocusable(true);
        setBackground(Color.WHITE);

        MyMouseListener ml = new MyMouseListener();
        addMouseListener(ml);
        addMouseMotionListener(ml);

        addKeyListener(this);

        this.selectedTool = selected;
        this.selectedColor = c;
        this.selectedThick = thick;
    }

    public void setSelected(String s) {
        selectedTool = s;
    }
    public void setSelectedColor(Color c){
        selectedColor = c;
    }
    public void setSelectedThick(int t) {
        selectedThick = t;
    }


    public void addRectangle(Rectangle rectangle) {
        Rectangles cr = new Rectangles(rectangle, selectedColor, selectedThick);
        RCL.add(cr);
    }

    public void addLine(Line2D.Double line) {
        Lines ls = new Lines(line, selectedColor, selectedThick);
        RCL.add(ls);
    }
    public void addCircle(Ellipse2D.Double circ) {
        Circles circs = new Circles(circ, selectedColor, selectedThick);
        RCL.add(circs);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() ==  KeyEvent.VK_ESCAPE) {
            for (int i = RCL.size() - 1; i >= 0; --i) {
                RCL.get(i).setSelected(false);
            }
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_C ) {
            //System.out.println("snapshot taken");
            takeSnapShot();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        System.out.println( "Lost Clipboard Ownership" );
    }

    class MyMouseListener extends MouseInputAdapter {

        MyShapes tempShape;
        int x2;
        int y2;

        public void mouseClicked(MouseEvent e) {
            for (int i = RCL.size() - 1; i >= 0; --i) {
                RCL.get(i).setSelected(false);
            }


            tempPoint = e.getPoint(); //point at which the mouse is clicked on
            if (selectedTool == "Eraser") {
                //iterate through shapes array to delete the top most shape that contains tempPoint
                for (int i = RCL.size() - 1; i >= 0; --i) {

                    if (RCL.get(i).getType() == "Rectangles") {
                        if (RCL.get(i).getRect().contains(tempPoint)) { //if rectangle contains the point
                            index = i;
                            RCL.remove(index);
                            break;
                        }
                    } else if (RCL.get(i).getType() == "Circles") {
                        if (RCL.get(i).getCircle().contains(tempPoint.x, tempPoint.y)) { //if circle contains the point
                            index = i;
                            RCL.remove(index);

                            break;
                        }

                    } else if (RCL.get(i).getType() == "Lines") {
                        if (aLine.ptSegDist((Point2D) tempPoint) <= 5) {
                            index = i;
                            RCL.remove(index);
                            break;
                        }
                    }
                }

            } else if (selectedTool == "Fill") {
                for (int i = RCL.size() - 1; i >= 0; --i) {

                    if (RCL.get(i).getType() == "Rectangles") {
                        if (RCL.get(i).getRect().contains(tempPoint)) { //if rectangle contains the point
                            RCL.get(i).setFill(selectedColor);
                            RCL.get(i).setFilled();

                            break;
                        }
                    } else if (RCL.get(i).getType() == "Circles") {
                        if (RCL.get(i).getCircle().contains(tempPoint.x, tempPoint.y)) { //if circle contains the point
                            RCL.get(i).setFill(selectedColor);
                            RCL.get(i).setFilled();

                            break;
                        }
                    }
                }
            } else if (selectedTool == "Select") {
                for (int i = RCL.size() - 1; i >= 0; --i) {

                    if (RCL.get(i).getType() == "Rectangles") {
                        if (RCL.get(i).getRect().contains(tempPoint)) { //if rectangle contains the point
                            RCL.get(i).setSelected(true);
                            cp.selectSetColor(tempShape.getColor());
                            tc.selectSetThick(tempShape.getLineThick());

                            break;
                        }
                    } else if (RCL.get(i).getType() == "Circles") {
                        if (RCL.get(i).getCircle().contains(tempPoint.x, tempPoint.y)) { //if circle contains the point
                            RCL.get(i).setSelected(true);
                            cp.selectSetColor(tempShape.getColor());
                            tc.selectSetThick(tempShape.getLineThick());

                            break;
                        }

                    } else if (RCL.get(i).getType() == "Lines") {
                        if (aLine.ptSegDist((Point2D)tempPoint) <= 5) {
                            RCL.get(i).setSelected(true);
                            cp.selectSetColor(tempShape.getColor());
                            tc.selectSetThick(tempShape.getLineThick());

                            break;
                        }
                    }
                }
            }
            repaint();
        }

        public void mousePressed(MouseEvent e) {

            for (int i = RCL.size() - 1; i >= 0; --i) {
                RCL.get(i).setSelected(false);
            }

            if (selectedTool == "Rectangle") {
                startPoint = e.getPoint();
                rec = new Rectangle();
            } else if (selectedTool == "Line") {
                startPoint = e.getPoint();
                aLine = new Line2D.Double();
            } else if (selectedTool == "Circle") {
                startPoint = e.getPoint();
                circle = new Ellipse2D.Double();
            } else if (selectedTool == "Select") {
                Point tp = e.getPoint();

                for (int i = RCL.size() - 1; i >= 0; --i) {
                    if (RCL.get(i).getType() == "Rectangles") {
                        if (RCL.get(i).getRect().contains(tp)) { //if rectangle contains the point
                            tempShape = RCL.get(i);
                            x2 = tp.x;
                            y2 = tp.y;
                            cp.selectSetColor(tempShape.getColor());
                            tc.selectSetThick(tempShape.getLineThick());

                            RCL.get(i).setSelected(true);

                            break;
                        }
                    } else if (RCL.get(i).getType() == "Circles") {
                        if (RCL.get(i).getCircle().contains(tp.x, tp.y)) { //if circle contains the point
                            tempShape = RCL.get(i);
                            x2 = tp.x;
                            y2 = tp.y;
                            cp.selectSetColor(tempShape.getColor());
                            tc.selectSetThick(tempShape.getLineThick());

                            RCL.get(i).setSelected(true);

                            break;
                        }

                    } else if (RCL.get(i).getType() == "Lines") {
                        if (aLine.ptSegDist((Point2D) tp) <= 5) {
                            tempShape = RCL.get(i);
                            tempPoint2 = e.getPoint();
                            x2 = tp.x;
                            y2 = tp.y;
                            cp.selectSetColor(tempShape.getColor());
                            tc.selectSetThick(tempShape.getLineThick());

                            RCL.get(i).setSelected(true);

                            break;
                        }
                    }
                }
            }
        }

        public void mouseDragged(MouseEvent e) {

            //https://stackoverflow.com/questions/40945461/java-swing-draw-rectangle-in-mouse-drag-and-drop
            int a = Math.min(startPoint.x, e.getX());
            int b = Math.min(startPoint.y, e.getY());
            int width = Math.abs(startPoint.x-e.getX());
            int height = Math.abs(startPoint.y-e.getY());

            if (selectedTool == "Rectangle") {
                rec.setBounds(a, b, width, height);
                //repaint();
            } else if (selectedTool == "Line") {
                endPoint = e.getPoint();
                aLine.setLine((Point2D)startPoint, (Point2D)endPoint);
            } else if (selectedTool == "Circle") {
                circle.setFrame((double)a, (double)b, (double)width, (double)height);
                //repaint();
            } else if (selectedTool == "Select") {
                int newX = e.getX();
                int newY = e.getY();
                int dx = newX - x2;
                int dy = newY - y2;

                if (tempShape.getType() == "Rectangles") {
                    tempShape.getRect().translate(dx, dy);

                } else if (tempShape.getType() == "Circles") {
                    tempShape.getCircle().setFrame(tempShape.getCircle().getX() + dx, tempShape.getCircle().getY() + dy, tempShape.getCircle().getWidth(), tempShape.getCircle().getHeight());

                } else if (tempShape.getType() == "Lines") {

                    double dx1 = tempPoint2.getX() - newX;
                    double dy1 = tempPoint2.getY() - newY;


                    tempShape.getLine().setLine(tempShape.getLine().getP1().getX() - dx1,
                            tempShape.getLine().getP1().getY() - dy1,
                            tempShape.getLine().getP2().getX() - dx1,
                            tempShape.getLine().getP2().getY() - dy1);

                    tempPoint2.x = newX;
                    tempPoint2.y = newY;

                }

                x2 = newX;
                y2 = newY;
            }

            repaint();
        }

        public void mouseReleased(MouseEvent e) {
            if (selectedTool == "Rectangle") {
                if (rec.width != 0 || rec.height != 0) {
                    addRectangle(rec);
                }
            } else if (selectedTool == "Line") {
                if (endPoint.x - startPoint.x != 0) {
                    addLine(aLine);
                }
            } else if (selectedTool == "Circle") {
                addCircle(circle);
            } else if (selectedTool == "Select") {
                x2 = e.getX();
                y2 = e.getY();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MyShapes myS : RCL) {
            if (myS.getType() == "Rectangles") {
                Graphics2D g1d = (Graphics2D)g;
                Rectangle r = myS.getRect();
                if (myS.getFilled()) {
                    g1d.setColor(myS.getFill());
                    g1d.fill(r);
                }
                g1d.setColor(myS.getColor());
                if (myS.getSelected()) {
                    g1d.setStroke(new BasicStroke(myS.getLineThick(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
                } else if (!myS.getSelected()) {
                    g1d.setStroke(new BasicStroke(myS.getLineThick()));
                }
                g1d.drawRect(r.x, r.y, r.width, r.height);

            } else if (myS.getType() == "Circles") {
                Graphics2D g1d = (Graphics2D)g;
                Ellipse2D.Double circ = myS.getCircle();
                if (myS.getFilled()) {
                    g1d.setColor(myS.getFill());
                    g1d.fill(circ);
                }
                g1d.setColor(myS.getColor());
                if (myS.getSelected()) {
                    g1d.setStroke(new BasicStroke(myS.getLineThick(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
                } else if (!myS.getSelected()) {
                    g1d.setStroke(new BasicStroke(myS.getLineThick()));
                }
                g1d.draw(circ);

            } else if (myS.getType() == "Lines") {
                Graphics2D g1d = (Graphics2D)g;
                Line2D.Double tempLine = myS.getLine();
                g1d.setColor(myS.getColor());
                if (myS.getSelected()) {
                    g1d.setStroke(new BasicStroke(myS.getLineThick(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
                } else if (!myS.getSelected()) {
                    g1d.setStroke(new BasicStroke(myS.getLineThick()));
                }
                g1d.draw(tempLine);
            }
        }

        if (selectedTool == "Rectangle") {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(selectedColor);
            g2d.setStroke(new BasicStroke(selectedThick));
            g2d.draw(rec);
        } else if (selectedTool == "Line") {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(selectedColor);
            g2d.setStroke(new BasicStroke(selectedThick));
            g2d.draw(aLine);

        } else if (selectedTool == "Circle") {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(selectedColor);
            g2d.setStroke(new BasicStroke(selectedThick));
            g2d.draw(circle);
        }
    }

    public void setColorPicker (colorPicker colorPick) {
        this.cp = colorPick;
    }

    public void setTc(thicknessChooser tc) {
        this.tc = tc;
    }
    public ArrayList<MyShapes> getRCL () {
        return RCL;
    }


    //https://coderanch.com/t/333565/java/BufferedImage-System-Clipboard
    private class TransferableImage implements Transferable {

        Image i;

        public TransferableImage( Image i ) {
            this.i = i;
        }

        public Object getTransferData( DataFlavor flavor )
                throws UnsupportedFlavorException, IOException {
            if ( flavor.equals( DataFlavor.imageFlavor ) && i != null ) {
                return i;
            }
            else {
                throw new UnsupportedFlavorException( flavor );
            }
        }

        public DataFlavor[] getTransferDataFlavors() {
            DataFlavor[] flavors = new DataFlavor[ 1 ];
            flavors[ 0 ] = DataFlavor.imageFlavor;
            return flavors;
        }

        public boolean isDataFlavorSupported( DataFlavor flavor ) {
            DataFlavor[] flavors = getTransferDataFlavors();
            for ( int i = 0; i < flavors.length; i++ ) {
                if ( flavor.equals( flavors[ i ] ) ) {
                    return true;
                }
            }

            return false;
        }
    }


    //https://coderanch.com/t/333565/java/BufferedImage-System-Clipboard
    public void takeSnapShot() {
        try {
            Robot robot = new Robot();
            Dimension screenSize  = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screen = new Rectangle( screenSize );
            BufferedImage i = robot.createScreenCapture( screen );
            TransferableImage trans = new TransferableImage( i );
            Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
            c.setContents( trans, this );
        }
        catch ( AWTException x ) {
            x.printStackTrace();
            System.exit( 1 );
        }
    }

}
