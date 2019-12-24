package Componentler;

import java.io.File;
import java.io.IOException;

public class DosyaOlustur {

    public static void main(String[] args) {

        File file=new File("dosyaOlustur.txt");

        try {
            if(!file.exists()){

            file.createNewFile(); }    //dosya oluşturuldu
        }

        catch (IOException e) {

            e.printStackTrace();
        }

    }

}
