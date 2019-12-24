package Componentler;



import javax.swing.*;


public class ComboBoxExample2 {
    JFrame f;

    ComboBoxExample2() {
        f = new JFrame("ComboBox Example");
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("1");
        model.addElement("2");
        model.addElement("3");
        // model.setSelectedItem();
        // model.getIndexOf();
        // model.setSelectedItem();
        // model.getSelectedItem();
        // model.removeAllElements();
        // model.removeElementAt();
        // model.removeElement();
        System.out.println(model.getElementAt(0));
        JComboBox cb = new JComboBox();
        cb.setModel(model);
        cb.setSelectedIndex(2);
        cb.setSelectedItem("1");
        cb.setBounds(50, 50, 90, 20);
        cb.setEditable(false);
        f.add(cb);
        f.setLayout(null);
        f.setSize(400, 500);
        f.setVisible(true);
    }



    public static void main(String[] args) {
        new ComboBoxExample2();
    }
}
