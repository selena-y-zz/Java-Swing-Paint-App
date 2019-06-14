package drawApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class drawTools extends JPanel{
    private drawCanvas canvas;

    JButton SELECT;
    JButton ERASER;
    JButton LINE;
    JButton CIRCLE;
    JButton RECT;
    JButton FILL;

    public drawTools(drawCanvas c) {
        //this.setFocusable(false);
        this.setLayout(new GridLayout(3, 2));

        this.canvas = c;

        SELECT = new JButton();
        SELECT.setIcon(new ImageIcon(((new ImageIcon("/Users/selenaa/Desktop/Spring 2019/CS349/x296yang/assignments/a1/src/Icons/select.png")).
                getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
        SELECT.setFocusable(false);
        SELECT.setFocusPainted(false);


        ERASER = new JButton();
        ERASER.setIcon(new ImageIcon(((new ImageIcon("/Users/selenaa/Desktop/Spring 2019/CS349/x296yang/assignments/a1/src/Icons/erase.png")).
                getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
        ERASER.setFocusable(false);
        ERASER.setFocusPainted(false);


        LINE = new JButton();
        LINE.setIcon(new ImageIcon(((new ImageIcon("/Users/selenaa/Desktop/Spring 2019/CS349/x296yang/assignments/a1/src/Icons/line.png")).
                getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
        LINE.setFocusable(false);
        LINE.setFocusPainted(false);


        CIRCLE = new JButton();
        CIRCLE.setIcon(new ImageIcon(((new ImageIcon("/Users/selenaa/Desktop/Spring 2019/CS349/x296yang/assignments/a1/src/Icons/circle.png")).
                getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
        CIRCLE.setFocusable(false);
        CIRCLE.setFocusPainted(false);

        RECT = new JButton();
        RECT.setIcon(new ImageIcon(((new ImageIcon("/Users/selenaa/Desktop/Spring 2019/CS349/x296yang/assignments/a1/src/Icons/rectangle.png")).
                getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
        RECT.setFocusable(false);
        RECT.setFocusPainted(false);

        FILL = new JButton();
        FILL.setIcon(new ImageIcon(((new ImageIcon("/Users/selenaa/Desktop/Spring 2019/CS349/x296yang/assignments/a1/src/Icons/paint.png")).
                getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
        FILL.setFocusable(false);
        FILL.setFocusPainted(false);

        ERASER.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        SELECT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        LINE.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        CIRCLE.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        RECT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        FILL.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(SELECT);
        add(ERASER);
        add(LINE);
        add(CIRCLE);
        add(RECT);
        add(FILL);

        SELECT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setSelected("Select");
                SELECT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                ERASER.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                LINE.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                CIRCLE.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                RECT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                FILL.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            }
        });
        ERASER.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setSelected("Eraser");

                ERASER.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                SELECT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                LINE.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                CIRCLE.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                RECT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                FILL.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            }
        });
        LINE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setSelected("Line");

                LINE.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                ERASER.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                SELECT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                CIRCLE.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                RECT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                FILL.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            }
        });
        CIRCLE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setSelected("Circle");

                CIRCLE.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                ERASER.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                LINE.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                SELECT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                RECT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                FILL.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            }
        });
        RECT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setSelected("Rectangle");

                RECT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                ERASER.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                LINE.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                CIRCLE.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                SELECT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                FILL.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            }
        });
        FILL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setSelected("Fill");

                FILL.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                ERASER.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                LINE.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                CIRCLE.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                RECT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                SELECT.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            }
        });

    }

}
