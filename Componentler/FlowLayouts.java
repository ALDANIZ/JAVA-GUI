package Componentler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.glass.ui.Cursor.setVisible;

public class FlowLayouts  extends JFrame implements ActionListener {


    JPanel panel = new JPanel();
    public FlowLayouts()
    {
        FlowLayout experimentLayout = new FlowLayout();
        experimentLayout.setAlignment(FlowLayout.TRAILING);

        panel.setLayout(experimentLayout);
        add(panel);
        for(int i=0;i<10;i++)
        {
            JButton button=new JButton("CLICK HERE");
            button.setText(String.valueOf(i)+" nolu");
            panel.add(button);
            button.addActionListener(this);
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
        FlowLayouts acojfar=new FlowLayouts();
    }


}
