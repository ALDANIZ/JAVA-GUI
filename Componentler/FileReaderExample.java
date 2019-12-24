package Componentler;

import java.io.FileReader;
import java.io.*;

public class FileReaderExample {


        public static void main(String args[])throws Exception{

            FileReader fr=new FileReader("dosyaOlustur.txt");
            BufferedReader br=new BufferedReader(fr);


            int i;
            while((i=fr.read())!=-1)
                System.out.print((char)i);
            fr.close();
        }
    }
