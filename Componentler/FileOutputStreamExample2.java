package Componentler;

import java.io.FileOutputStream;

public class FileOutputStreamExample2 {

    public static void main(String args[]){


        try{

            FileOutputStream fout=new FileOutputStream("dosyaOlustur.txt");
            String s="Welcome to javaTpoint.";
            byte b[]=s.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");

        }catch(Exception e){System.out.println(e);}
    }
}
