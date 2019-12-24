package Componentler;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class TreeExample {

    JFrame f;

    TreeExample(){

        f=new JFrame();
        DefaultMutableTreeNode style=new DefaultMutableTreeNode("Style");
        DefaultMutableTreeNode color=new DefaultMutableTreeNode("color");
        DefaultMutableTreeNode font=new DefaultMutableTreeNode("font");
        style.add(color);
        style.add(font);


        DefaultMutableTreeNode red=new DefaultMutableTreeNode("red");
        DefaultMutableTreeNode blue=new DefaultMutableTreeNode("blue");
        DefaultMutableTreeNode black=new DefaultMutableTreeNode("black");
        DefaultMutableTreeNode green=new DefaultMutableTreeNode("green");

        color.add(red); color.add(blue); color.add(black); color.add(green);

        DefaultTreeModel model2=new DefaultTreeModel(style);



        JTree jt=new JTree(model2);

        jt.setRootVisible(true);
        System.out.println(jt.getRowCount());
        System.out.println(jt.isRootVisible());
        jt.setSelectionRow(1);
        System.out.println(jt.getSelectionCount());



        f.add(jt);
        f.setSize(200,200);
        f.setVisible(true);
    }


    public static void main(String[] args) {
        new TreeExample();
    }

}
