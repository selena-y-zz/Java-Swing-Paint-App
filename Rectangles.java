package drawApp;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Rectangles implements MyShapes {
    private Rectangle rectangle;

    private Color color;
    private Color fill;
    private int lineThick;

    private boolean filled;

    private boolean selected;


    public Rectangles(Rectangle rectangle, Color color, int lineThick)
    {
        this.rectangle = rectangle;
        this.color = color;
        this.lineThick = lineThick;
        this.filled = false;
    }

    public Color getColor() {
        return color;
    }
    public int getLineThick() {
        return lineThick;
    }

    @Override
    public void setFill(Color c) {
        fill = c;
    }

    @Override
    public Color getFill() {
        return fill;
    }

    @Override
    public void setFilled() {
        filled = true;
    }

    @Override
    public boolean getFilled() {
        return filled;
    }

    @Override
    public boolean getSelected() {
        return selected;
    }
    @Override
    public void setSelected(boolean b) {
        selected = b;
    }

    @Override
    public String getType() {
        return "Rectangles";
    }

    @Override
    public Rectangle getRect() {
        return rectangle;
    }

    @Override
    public Ellipse2D.Double getCircle() {
        return null;
    }

    @Override
    public Line2D.Double getLine() {
        return null;
    }

}
