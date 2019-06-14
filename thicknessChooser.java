package drawApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class thicknessChooser extends JPanel {
    private drawCanvas canvas;

    thicknessButtons one;
    thicknessButtons six;
    thicknessButtons nine;

    public thicknessChooser(drawCanvas c) {
        this.setFocusable(true);
        this.setLayout(new GridLayout(3, 1, 0, 7));

        this.canvas = c;

        one = new thicknessButtons(1);
        six = new thicknessButtons(6);
        nine = new thicknessButtons(9);

        one.setIcon(new ImageIcon(((new ImageIcon("/Users/selenaa/Desktop/Spring 2019/CS349/x296yang/assignments/a1/src/Icons/1px.png")).
                getImage()).getScaledInstance(160, 5, java.awt.Image.SCALE_SMOOTH)));
        one.setBackground(Color.WHITE);
        one.setFocusable(false);
        one.setOpaque(true);

        six.setIcon(new ImageIcon(((new ImageIcon("/Users/selenaa/Desktop/Spring 2019/CS349/x296yang/assignments/a1/src/Icons/3px.png")).
                getImage()).getScaledInstance(160, 8, java.awt.Image.SCALE_SMOOTH)));
        six.setBackground(Color.WHITE);
        six.setFocusable(false);
        six.setOpaque(true);

        nine.setIcon(new ImageIcon(((new ImageIcon("/Users/selenaa/Desktop/Spring 2019/CS349/x296yang/assignments/a1/src/Icons/5px.png")).
                getImage()).getScaledInstance(160, 12, java.awt.Image.SCALE_SMOOTH)));
        nine.setBackground(Color.WHITE);
        nine.setFocusable(false);
        nine.setOpaque(true);

        add(one);
        add(six);
        add(nine);

        one.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        six.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        nine.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectSetThick(1);
            }
        });

        six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectSetThick(6);
            }
        });

        nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectSetThick(9);
            }
        });

    }

    public void selectSetThick(int thick) {
        canvas.setSelectedThick(thick);

        if (thick == 1) {
            one.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            six.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            nine.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        } else if (thick == 6) {
            one.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            six.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            nine.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        } else if (thick == 9) {
            one.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            six.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            nine.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }
}
