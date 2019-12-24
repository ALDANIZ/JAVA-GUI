package Componentler;

import javax.swing.*;
import java.awt.*;

public class TextAreaExample
{
    TextAreaExample(){
        JFrame f= new JFrame();
        JTextArea area=new JTextArea("Welcome to javatpoin \n  fff");
        String text=area.getText();
        String words[]=text.split("\n");


        area.paste();;
        area.copy();
        area.cut();
        //area.remove();
        //area.removeAll();


        area.setSize(100,100);
        System.out.println(text);
        System.out.println(words[0]);
        System.out.println(words[1]);
        area.setBounds(10,30, 200,200);
        f.add(area);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String args[])
    {
        new TextAreaExample();
    }}