package drawApp;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class mainDrawApp extends JFrame {

    protected menuBar menubar; //menubar
    protected drawTools tools; //drawing tools
    protected drawCanvas canvas; //canvas to draw on
    protected colorPicker colorspick; //6 original colors
    protected colorChooser colorchoose; //color chooser button
    protected thicknessChooser thickchoose; //choose thickness of the lines

    public mainDrawApp(String appName) {

        setTitle(appName); //sets title of the application
        setSize(800, 600);
        setResizable(false);
        setLayout(new BorderLayout());

        JMenuBar menu_bar = new JMenuBar(); //creates new menubar bar
        menubar = new menuBar();
        menu_bar.add(menubar.menu);
        setJMenuBar(menu_bar);

        canvas = new drawCanvas("", Color.BLACK, 1);
        this.add(canvas, BorderLayout.CENTER);


        JPanel leftBar = new JPanel();
        leftBar.setLayout(new BoxLayout(leftBar, BoxLayout.Y_AXIS));


        tools = new drawTools(canvas); //creates drawing tools
        leftBar.add(tools);

        colorchoose = new colorChooser(canvas);
        colorspick = new colorPicker(canvas, colorchoose.getChoose());

        colorchoose.setC(colorspick);

        leftBar.add(colorspick);
        leftBar.add(colorchoose);

        thickchoose = new thicknessChooser(canvas);
        leftBar.add(thickchoose);

        this.add(leftBar, BorderLayout.WEST);

        canvas.setColorPicker(colorspick);
        canvas.setTc(thickchoose);
        //canvas.setDt(tools);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public drawCanvas getDrawCanvas(){
        return canvas;
    }


    //https://alvinalexander.com/java/java-file-save-write-text-binary-data
    public void saveFile() {
        try {
            JFileChooser chooseD = new JFileChooser();
            chooseD.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooseD.showSaveDialog(Main.mainApp);
            File f = chooseD.getSelectedFile();
            f = new File(f + ".jpg");

            //need to figure out what content to store.....
            //toString method (rectangle)...save string and go through shapes dump into file

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f));

            bufferedWriter.close();

        } catch (IOException exception) {
            System.err.println("Error saving file.");
        }
    }
}
