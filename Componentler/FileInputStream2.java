package Componentler;

import java.io.FileInputStream;

public class FileInputStream2 {

    public static void main(String args[]){

        try{

            FileInputStream fin=new FileInputStream("dosyaOlustur.txt");

            int i=fin.read();

            System.out.print((char)i);

            fin.close();

        }catch(Exception e){System.out.println(e);}
    }
}
