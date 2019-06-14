package drawApp;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Circles implements MyShapes {
    private Ellipse2D.Double circle;
    private Color color;
    private int lineThick;
    private Color fill;

    boolean filled;
    boolean selected;


    public Circles(Ellipse2D.Double circle, Color color, int lineThick) {
        this.circle = circle;
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
        return "Circles";
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public Ellipse2D.Double getCircle() {
        return circle;
    }

    @Override
    public Line2D.Double getLine() {
        return null;
    }

}
