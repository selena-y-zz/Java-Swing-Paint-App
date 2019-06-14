package drawApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class colorChooser extends JPanel {
    private drawCanvas canvas;
    private colorPicker c;

    private JButton choose;

    public colorChooser(drawCanvas c) {

        setLayout(new BorderLayout());

        this.canvas = c;

        choose = new JButton("Color Chooser");
        choose.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        choose.setFocusable(false);

        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color c = JColorChooser.showDialog(choose,"Choose Colour",Color.BLACK);
                canvas.setSelectedColor(c);

                choose.setBackground(Color.WHITE);
                choose.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

                unsetC();
            }
        });

        this.add(choose, BorderLayout.CENTER);
    }

    public JButton getChoose() {
        return choose;
    }

    public void setC(colorPicker c) {
        this.c = c;
    }

    public void unsetC () {
        c.getBlack().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.getBlue().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.getGreen().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.getPink().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.getRed().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        c.getYellow().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

}
