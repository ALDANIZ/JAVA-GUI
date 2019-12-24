package Componentler;

import javax.swing.*;
public class SliderExample1 extends JFrame{
    public SliderExample1() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
        slider.setOrientation(1);
        slider.setValue(10);
        ;slider.getValue();
        System.out.println(slider.getValue());
        JPanel panel=new JPanel();
        panel.add(slider);
        add(panel);
    }

    public static void main(String s[]) {
        SliderExample1 frame=new SliderExample1();
        frame.pack();
        frame.setVisible(true);
    }
}