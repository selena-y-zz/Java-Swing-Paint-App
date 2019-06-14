package drawApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuBar extends JMenuBar {

    protected JMenu menu;
    protected JMenuItem m1_new;
    protected JMenuItem m2_load;
    protected JMenuItem m3_save;

    public menuBar() { //constructor

        menu = new JMenu("File");
        m1_new = new JMenuItem("New");
        m2_load = new JMenuItem("Load");
        m3_save = new JMenuItem("Save");


        ActionHandler ah = new ActionHandler();


        m1_new.addActionListener(ah);
        menu.add(m1_new);
        m2_load.addActionListener(ah);
        menu.add(m2_load);
        m3_save.addActionListener(ah);
        menu.add(m3_save);
    }


    private class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == m1_new) {
                Main.mainApp.getDrawCanvas().getRCL().clear();
                Main.mainApp.getDrawCanvas().repaint();
            } else if (event.getSource() == m2_load) {
            } else if (event.getSource() == m3_save) {
                Main.mainApp.saveFile();
            }

        }
    }

}
