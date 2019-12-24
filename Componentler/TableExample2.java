package Componentler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableExample2 {

    JFrame f;

    TableExample2(){

        f=new JFrame();

        DefaultTableModel model=new DefaultTableModel();

        String satir[]={"Isim","Soyisim","Numara"};
        String bilgi[]={"Deniz","Imanli","0000"};

        model.addColumn(satir);
        model.addRow(bilgi);

        JTable jt=new JTable();
        //jt.getValueAt();
        //jt.getSelectedColumn();
        //jt.getSelectedRow();
        //jt.setValueAt();








        jt.setModel(model);
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