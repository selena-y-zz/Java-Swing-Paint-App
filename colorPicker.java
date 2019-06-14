package drawApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class colorPicker extends JPanel {
    private drawCanvas canvas;

    private JButton black;
    private JButton red;
    private JButton blue;
    private JButton yellow;
    private JButton green;
    private JButton pink;

    private JButton colorChoose;

    public colorPicker(drawCanvas c, JButton colorChoose) {
        this.setFocusable(true);
        this.setLayout(new GridLayout(3,2,3,3));

        this.canvas = c;
        this.colorChoose = colorChoose;

        black = new JButton();
        black.setBackground(Color.BLACK);
        black.setFocusable(false);
        black.setOpaque(true);

        red = new JButton();
        red.setBackground(Color.RED);
        red.setFocusable(false);
        red.setOpaque(true);

        blue = new JButton();
        blue.setBackground(Color.BLUE);
        blue.setFocusable(false);
        blue.setOpaque(true);

        yellow = new JButton();
        yellow.setBackground(Color.YELLOW);
        yellow.setFocusable(false);
        yellow.setOpaque(true);

        green = new JButton();
        green.setBackground(Color.GREEN);
        green.setFocusable(false);
        green.setOpaque(true);

        pink = new JButton();
        pink.setBackground(Color.PINK);
        pink.setFocusable(false);
        pink.setOpaque(true);

        black.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        red.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        blue.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        yellow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        green.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pink.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        add(black);
        add(red);
        add(blue);
        add(yellow);
        add(green);
        add(pink);

        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectSetColor(Color.BLACK);
            }
        });

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectSetColor(Color.RED);
            }
        });

        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectSetColor(Color.BLUE);
            }
        });

        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectSetColor(Color.YELLOW);

            }
        });

        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectSetColor(Color.GREEN);
            }
        });


        pink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectSetColor(Color.PINK);
            }
        });

    }

    public JButton getBlack() {
        return black;
    }

    public JButton getRed() {
        return red;
    }

    public JButton getBlue() {
        return blue;
    }

    public JButton getYellow() {
        return yellow;
    }

    public JButton getGreen() {
        return green;
    }

    public JButton getPink() {
        return pink;
    }

    public void selectSetColor(Color c) {

        canvas.setSelectedColor(c);

        if (c == Color.BLACK) {
            black.setBorder(BorderFactory.createLineBorder(Color.RED));
            red.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            blue.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            yellow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            green.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            pink.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            colorChoose.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        } else if (c == Color.RED) {

            red.setBorder(BorderFactory.createLineBorder(Color.GREEN));
            black.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            blue.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            yellow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            green.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            pink.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            colorChoose.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        } else if (c == Color.BLUE) {

            blue.setBorder(BorderFactory.createLineBorder(Color.PINK));
            black.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            red.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            yellow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            green.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            pink.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            colorChoose.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        } else if (c == Color.YELLOW) {

            yellow.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            black.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            blue.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            red.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            green.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            pink.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            colorChoose.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        } else if (c == Color.GREEN) {

            green.setBorder(BorderFactory.createLineBorder(Color.RED));
            black.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            blue.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            yellow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            red.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            pink.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            colorChoose.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        } else if (c == Color.PINK) {

            pink.setBorder(BorderFactory.createLineBorder(Color.CYAN));
            black.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            blue.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            yellow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            green.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            red.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            colorChoose.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        } else {

            colorChoose.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            black.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            pink.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            blue.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            yellow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            green.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            red.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        }
    }
}
