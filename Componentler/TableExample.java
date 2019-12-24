package Componentler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;


public class TableExample {

    JFrame f;

    TableExample(){

        f=new JFrame();

        DefaultTableModel model = new DefaultTableModel();
        Vector v = new Vector();



        Object data[]={"Deniz","Imanli","00000"};


        model.addColumn("Isim",data);
        model.addColumn("Soyisim");
        model.addColumn("Numara");
        model.addRow(data);

        JTable jt=new JTable();




        jt.setModel(model);
        jt.setColumnSelectionAllowed(false);
        jt.setCellSelectionEnabled(false);

        jt.setRowHeight(20);
        jt.setGridColor(Color.red);
        jt.setShowHorizontalLines(false);
        //jt.setTableHeader(true);
        jt.getColumnCount();
        jt.getValueAt(0,0);
        jt.getColumnName(0);
        jt.getValueAt(0,0);

        jt.setBounds(30,40,200,300);

        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        f.setSize(300,400);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new TableExample();
    }
}