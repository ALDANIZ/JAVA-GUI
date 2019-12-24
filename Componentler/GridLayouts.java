package Componentler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.glass.ui.Cursor.setVisible;

public class GridLayouts extends JFrame implements ActionListener{

    JPanel panel = new JPanel();
    public GridLayouts()
    {
        GridLayout experimentLayout = new GridLayout(5,2);
        panel.setLayout(experimentLayout);
        add(panel);
        for(int i=0;i<10;i++)
        {
            JButton button=new JButton();
            button.setText(String.valueOf(i)+" nolu button");
            panel.add(button);
            button.addActionListener((ActionListener) this);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt)
    {
        panel.add(new JButton("Button"));
        panel.revalidate();
        repaint();
        JButton b = (JButton) evt.getSource();
        System.out.println(b.getText());
    }

    public static void main(String[]args)
    {
        GridLayouts acojfar=new GridLayouts();
    }

}
