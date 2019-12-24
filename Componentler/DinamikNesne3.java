package Componentler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DinamikNesne3 {


    public static void main(String[] args)
    {
        final JFrame frame = new JFrame("Test");
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new JButton(new AbstractAction("Eklemek için tıklayın")
                //AbstractAction : Standart Action özelliklerinin tanımlandığı sınıftır. ActionPerformed bu sınıfa dahildir
        {
            public void actionPerformed(ActionEvent e)
            {
                SwingUtilities.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        frame.add(new JLabel("Yeni Etiket"));
                        frame.validate();
                        frame.repaint();
                    }
                });
            }

        }));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }


}
