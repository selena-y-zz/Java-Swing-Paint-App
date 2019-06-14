package drawApp;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Lines implements MyShapes {
    private Line2D.Double line;

    private Color color;
    private int lineThick;

    private boolean selected;

    public Lines(Line2D.Double line, Color color, int lineThick) {
        this.line = line;
        this.color = color;
        this.lineThick = lineThick;

    }
    public Line2D.Double getLine() {return line;}
    public Color getColor() {
        return color;
    }
    public int getLineThick() {
        return lineThick;
    }

    @Override
    public void setFill(Color c) {}

    @Override
    public Color getFill() {
        return null;
    }

    @Override
    public void setFilled() {

    }

    @Override
    public boolean getFilled() {
        return false;
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
        return "Lines";
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public Ellipse2D.Double getCircle() {
        return null;
    }
}