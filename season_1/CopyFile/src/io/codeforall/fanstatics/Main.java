package io.codeforall.fanstatics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        FileInputStream fis = new FileInputStream("/Users/codecadet/Documents/my_exercises/season_1/CopyFile/rsc/sunflower.pdf");
        FileOutputStream fos = new FileOutputStream("/Users/codecadet/Documents/my_exercises/season_1/CopyFile/rsc/sunflower1.pdf");

    byte[] buffer = new byte[1024];

        //int num = fileInputStream.read(buffer);
        int bytesRead;

        while(((bytesRead) = fis.read(buffer)) != -1){

           // fos.write(buffer,0,bytesRead);
            fos.write(bytesRead);
        }

        fos.write(buffer);
        }









    }





