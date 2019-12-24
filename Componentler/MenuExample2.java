package Componentler;

import javax.swing.*;
import java.awt.event.*;


public class MenuExample2 implements ActionListener{

    JFrame f;
    JMenuBar mb;
    JMenu file,edit,help;
    JMenuItem cut,copy,paste,selectAll;
    JTextArea ta;


    MenuExample2(){

        f=new JFrame();
        cut=new JMenuItem("cut");
        copy=new JMenuItem("copy");
        paste=new JMenuItem("paste");

        selectAll=new JMenuItem("selectAll");
        cut.setAccelerator(KeyStroke.getKeyStroke('a'));

        JSeparator a;

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);


        mb=new JMenuBar();
        file=new JMenu("File");
        edit=new JMenu("Edit");
        help=new JMenu("Help");
        edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll);

        mb.add(file);mb.add(edit);mb.add(help);


        ta=new JTextArea();
        ta.setBounds(5,5,360,320);
        f.add(mb);f.add(ta);
        f.setJMenuBar(mb);
        f.setLayout(null);
        f.setSize(400,400);
        f.setVisible(true);
        System.out.println(edit.getItemCount());


    }


    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==cut)
            ta.cut();


        if(e.getSource()==paste)
            ta.paste();


        if(e.getSource()==copy)
            ta.copy();


        if(e.getSource()==selectAll)
            ta.selectAll();
    }


    public static void main(String[] args) {
        new MenuExample2();
    }


}