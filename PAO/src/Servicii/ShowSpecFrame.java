package Servicii;

import javax.swing.*;
import java.io.IOException;

public class ShowSpecFrame {
    private JFrame f;
    private JLabel label;
    public ShowSpecFrame() throws IOException {
        f = new JFrame("Specializari");
        SpecializareS ss = SpecializareS.getInst();
        label = new JLabel("<html><pre>" + ss.showSpec() + "</pre></html>");
        f.add(label);
        f.setSize(500,500);
        f.setVisible(true);
    }
}
