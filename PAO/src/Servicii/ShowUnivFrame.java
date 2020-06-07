package Servicii;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ShowUnivFrame {
    private JFrame f;
    private JLabel label;
    public ShowUnivFrame() throws IOException {
        f = new JFrame("Universitati");
        UniversitateS u = UniversitateS.getInst();
        label = new JLabel("<html><pre>" + u.showUniv() + "</pre></html>");
        f.add(label);
        f.setSize(500,500);
        f.setVisible(true);
    }
}
