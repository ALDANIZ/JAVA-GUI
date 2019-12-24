package Componentler;

import java.io.FileWriter;

public class FileWriterExample1 {


    public static void main(String args[]){

        try{

            FileWriter fw=new FileWriter("dosyaOlustur.txt",true);
            fw.write("Welcome to javaTpoint.");
            fw.close();


        }catch(Exception e){System.out.println(e);}
        System.out.println("Success...");
    }
}
