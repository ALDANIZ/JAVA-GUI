package Componentler;

import javax.swing.*;
import java.awt.*;

public class ProgressBarExample extends JFrame{

    JProgressBar jb;

    int i=0,num=0;

    ProgressBarExample(){


        jb=new JProgressBar(0,2000);
        jb.setBounds(40,40,160,30);

        jb.setMaximum(3000);
        jb.setMinimum(0);

        jb.setOrientation(1);
        jb.setCursor(Cursor.getPredefinedCursor(9));
        jb.setValue(0);
        jb.setStringPainted(true);


        add(jb);
        setSize(250,150);
        setLayout(null);


    }



    public void iterate(){



        while(i<=2000){

            jb.setValue(i);
            i=i+10;

            try{

                Thread.sleep(150);

            }


            catch(Exception e){



            }
        }
    }


    public static void main(String[] args) {

        ProgressBarExample m=new ProgressBarExample();
        m.setVisible(true);
        m.iterate();
    }
}