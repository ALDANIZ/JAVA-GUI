package Componentler;

import java.io.*;



public class BufferedReaderExample {

    public static void main(String args[])throws Exception{
        FileReader fr=new FileReader("dosyaOlustur.txt");
        BufferedReader br=new BufferedReader(fr);

        /*int i;
        while((i=br.read())!=-1){
            System.out.println((char)i);
        }

         */

        String data=br.readLine();
        System.out.println(data);
        String data2=br.readLine();
        System.out.println(data2);


        br.close();
        fr.close();
    }

}
