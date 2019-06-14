package drawApp;


import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public interface MyShapes {
    String getType();

    Rectangle getRect();
    Ellipse2D.Double getCircle();
    Line2D.Double getLine();

    Color getColor();
    int getLineThick();

    void setFill(Color c);
    Color getFill();

    void setFilled();
    boolean getFilled();

    boolean getSelected();
    void setSelected(boolean b);

}
