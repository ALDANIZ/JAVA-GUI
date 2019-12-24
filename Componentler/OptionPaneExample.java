package Componentler;

import javax.swing.*;
public class OptionPaneExample {


    JFrame f;

    OptionPaneExample(){

        f=new JFrame();
        f.setSize(500,500);
        JOptionPane.showMessageDialog(f,"Hello, Welcome to Javatpoint.");
        JOptionPane.showMessageDialog(f,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE);
        String name=JOptionPane.showInputDialog(f,"Enter Name");
        System.out.println(name);


        int input = JOptionPane.showConfirmDialog(f, "Do you like bacon?");
        // 0=yes, 1=no, 2=cancel
        System.out.println(input);


        String[] options = {"abc", "def", "ghi", "jkl"};

        int x = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
                "Click a button",
                JOptionPane.WARNING_MESSAGE,  JOptionPane.WARNING_MESSAGE, null, options, options[0]);


        System.out.println(x);


    }
    public static void main(String[] args) {
        new OptionPaneExample();
    }
}