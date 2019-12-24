package Componentler;

import javax.swing.*;

public class ComboBoxExample {
    JFrame f;
    ComboBoxExample(){
        f=new JFrame("ComboBox Example");
        //String country[]=new String[5];
        //country[]={"India","Aus","U.S.A","England","Newzealand"};
         String country[]={"India","Aus","U.S.A","England","Newzealand"};
        JComboBox cb=new JComboBox(country);
        cb.setBounds(50, 50,90,20);
        cb.setEditable(false);
        cb.setSelectedIndex(1);
        System.out.println(cb.getSelectedIndex());
        System.out.println(country[cb.getSelectedIndex()]);
        System.out.println(cb.getItemAt(2));
        System.out.println(cb.getItemCount());
        System.out.println(cb.getSelectedItem());
        f.add(cb);
        f.setLayout(null);
        f.setSize(400,500);
        f.setVisible(true);
    }


    public static void main(String[] args)
    {
        new ComboBoxExample();
    }
}