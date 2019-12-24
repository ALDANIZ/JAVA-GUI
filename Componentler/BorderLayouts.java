package Componentler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.javafx.fxml.expression.Expression.add;

public class BorderLayouts extends JFrame implements ActionListener {


    JPanel panel = new JPanel();
    public int sayi = 0;
    public BorderLayouts()
    {
        BorderLayout experimentLayout = new BorderLayout();
        panel.setLayout(experimentLayout);
        add(panel);
        for(sayi=0;sayi<5;sayi++)
        {
            JButton button=new JButton("Tıklayın");
            button.setText(String.valueOf(sayi));
            if (sayi == 0)
            {
                add(button,BorderLayout.PAGE_START);
                button.addActionListener(this);
            }
            if (sayi == 1)
            {
                add(button,BorderLayout.CENTER);
                button.addActionListener(this);
            }
            if (sayi == 2)
            {
                add(button,BorderLayout.LINE_START);
                button.addActionListener(this);
            }
            if (sayi == 3)
            {
                add(button,BorderLayout.LINE_END);
                button.addActionListener(this);
            }
            if (sayi == 4)
            {
                add(button,BorderLayout.PAGE_END);
                button.addActionListener((ActionListener) this);
            }
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
        BorderLayouts acojfar=new BorderLayouts();
    }

}
