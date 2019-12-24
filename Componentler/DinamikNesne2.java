package Componentler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DinamikNesne2 {


    final JFrame frame = new JFrame("Test");
    JButton button=new JButton();

    public  DinamikNesne2()
    {
        frame.setLayout(new GridLayout(1, 1));
        button.setText("Eklemek için tıklayın");
        frame.add(button);
        button.addActionListener((ActionListener) this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt)
    {
        frame.add(new JLabel("Yeni Etiket"));
        frame.validate();
        frame.repaint();
    }

    public static void main(String[]args)
    {
        DinamikNesne2 acojfar=new  DinamikNesne2();
    }

}
