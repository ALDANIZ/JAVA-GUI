package Componentler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DinamikNesne1  {


    public static void main(String[] args)
    {
        final JFrame frame = new JFrame("Test");
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new JButton(new AbstractAction("Eklemek için tıklayın")
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.add(new JLabel("Yeni Etiket"));
                frame.validate();
                frame.repaint();;
            }
        }));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

}
