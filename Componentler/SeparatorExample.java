package Componentler;

import javax.swing.*;
class SeparatorExample
{


    JMenu menu, submenu;

    JMenuItem i1, i2, i3, i4, i5;



    SeparatorExample()  {

        JFrame f= new JFrame("Separator Example");

        JMenuBar mb=new JMenuBar();

        JSeparator sep = new JSeparator();

        menu=new JMenu("Menu");
        i1=new JMenuItem("Item 1");
        i2=new JMenuItem("Item 2");
        i1.setAccelerator(KeyStroke.getKeyStroke('a'));
        menu.add(i1);
        //menu.addSeparator();
        menu.add(sep);
        menu.add(i2);

        mb.add(menu);

        f.setJMenuBar(mb);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String args[])
    {
        new SeparatorExample();
    }}