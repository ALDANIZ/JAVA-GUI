package Componentler;

import java.io.*;
public class BufferedInputStreamExample2 {
    public static void main(String args[]){
        try{
            int i;
            FileInputStream fin=new FileInputStream("dosyaOlustur.txt");
            BufferedInputStream bin=new BufferedInputStream(fin);
            String a;



            while((i=bin.read())!=-1)
                System.out.print((char)i);
            bin.close();
            fin.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
