package Componentler;

import javax.swing.*;
public class ListExample
{
    ListExample(){


        JFrame f= new JFrame();
        DefaultListModel l1 = new DefaultListModel();


        l1.addElement("Item1");
        l1.addElement("Item2");
        l1.addElement("Item3");
        l1.addElement("Item4");





        JList list = new JList(l1);
        list.setBounds(100,100, 75,75);
        list.setModel(l1);
        list.getSelectedValue();



        f.add(list);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);

    }



    public static void main(String args[])
    {
        new ListExample();
    }}