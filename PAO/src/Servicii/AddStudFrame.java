package Servicii;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddStudFrame {
    private JLabel jl_id, jl_univ, jl_fac, jl_spec, jl_nume, jl_medie;
    private JTextField jt_id, jt_univ, jt_fac, jt_spec, jt_nume, jt_medie;
    private JButton b;
    private JFrame f;
    public AddStudFrame() throws IOException{
        f = new JFrame("Adaugare Student");
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(500,500);
        jl_id = new JLabel("Id:");
        jl_univ = new JLabel("Universitate:");
        jl_fac = new JLabel("Facultate:");
        jl_spec = new JLabel("Specializare:");
        jl_nume = new JLabel("Nume:");
        jl_medie = new JLabel("Medie:");
        jl_id.setBounds(20,20,100,20);
        jl_univ.setBounds(20,50,100,20);
        jl_fac.setBounds(20,80,100,20);
        jl_spec.setBounds(20,110,100,20);
        jl_nume.setBounds(20,140,100,20);
        jl_medie.setBounds(20,170,100,20);
        f.add(jl_id);
        f.add(jl_univ);
        f.add(jl_fac);
        f.add(jl_spec);
        f.add(jl_nume);
        f.add(jl_medie);

        jt_id = new JTextField(20);
        jt_univ = new JTextField(20);
        jt_fac = new JTextField(20);
        jt_spec = new JTextField(20);
        jt_nume = new JTextField(20);
        jt_medie = new JTextField(20);
        jt_id.setBounds(130,20,150,20);
        jt_univ.setBounds(130,50,150,20);
        jt_fac.setBounds(130,80,150,20);
        jt_spec.setBounds(130,110,150,20);
        jt_nume.setBounds(130,140,150,20);
        jt_medie.setBounds(130,170,150,20);
        f.add(jt_id);
        f.add(jt_univ);
        f.add(jt_fac);
        f.add(jt_spec);
        f.add(jt_nume);
        f.add(jt_medie);

        b = new JButton("Submit");
        b.setBounds(50,300,150,50);
        f.add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    StudentS s = StudentS.getInst();
                    s.addStud(Integer.parseInt(jt_id.getText()), jt_univ.getText(), jt_fac.getText(), jt_spec.getText(), jt_nume.getText(), Double.parseDouble(jt_medie.getText()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
