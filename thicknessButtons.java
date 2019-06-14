package drawApp;

import javax.swing.*;

public class thicknessButtons extends JButton {

    int thickness;
    private boolean isClicked;

    public thicknessButtons(int px) {
        this.thickness = px;

        if (thickness == 3) {
            isClicked = true;
        } else {
            isClicked = false;
        }

    }
}
