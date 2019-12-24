package Componentler;

import java.io.File;

public class DosyaSil {

    public static void main(String[] args) {

        File file = new File("dosyaOlustur.txt");
        file.delete();
     }
    }
