package Servicii;

import javax.swing.*;
import java.io.IOException;

public class ShowStudFrame {
    private JFrame f;
    private JLabel label;
    public ShowStudFrame() throws IOException {
        f = new JFrame("Studenti");
        StudentS ss = StudentS.getInst();
        label = new JLabel("<html><pre>" + ss.showStud() + "</pre></html>");
        f.add(label);
        f.setSize(500,500);
        f.setVisible(true);
    }
}
