package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String[] data = new String[] {"", "", "", ""};

        try (FileInputStream inputStream = new FileInputStream(file)){

            int c;
            boolean flg = false;
            int it = 0;
            while ((c = inputStream.read()) != -1) {
                if(c == '\r'){
                    flg = false;
                    it++;
                }
                if(flg) data[it] += (char)c;
                if(c == ' ') flg = true;
            }
            if (it == 4)
               throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile(data[0], Integer.parseInt(data[1]), data[2], Long.parseLong(data[3]));
    }

}
