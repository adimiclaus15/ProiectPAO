package Servicii;

import javax.swing.*;
import java.io.IOException;

public class ShowFacFrame {
    private JFrame f;
    private JLabel label;
    public ShowFacFrame() throws IOException {
        f = new JFrame("Facultati");
        FacultateS fs = FacultateS.getInst();
        label = new JLabel("<html><pre>" + fs.showFac() + "</pre></html>");
        f.add(label);
        f.setSize(500,500);
        f.setVisible(true);
    }
}
