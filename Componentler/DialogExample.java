package Componentler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DialogExample {

    public  JDialog d;


    DialogExample() {

        JFrame f = new JFrame();

        d = new JDialog();
        //d.setBackground(Color.RED);
        d.setTitle("B");
        f.add(d);
        d.setLayout(new FlowLayout());
        d.setBounds(10, 50, 100, 500);
        JButton b = new JButton("OK");


        d.add(new JLabel("Click button to continue."));
        d.add(b);
        d.setSize(300, 300);
        d.setVisible(true);

    }


    public static void main(String args[])
    {
        new DialogExample();
    }
}
