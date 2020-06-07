package Servicii;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame {
    private JFrame f;
    private JButton b1, b2, b3, b4, b5;
    public MainFrame() {
        f = new JFrame("Main");
        b1 = new JButton("Vizualizeaza Universitati");
        b2 = new JButton("Vizualizeaza Facultati");
        b3 = new JButton("Vizualizeaza Specializari");
        b4 = new JButton("Vizualizeaza Studenti");
        b5 = new JButton("Adaugare Studenti");
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(5,1));
        f.setSize(300, 300);
        f.setVisible(true);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    new ShowUnivFrame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    new ShowFacFrame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    new ShowStudFrame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    new ShowStudFrame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    new AddStudFrame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
