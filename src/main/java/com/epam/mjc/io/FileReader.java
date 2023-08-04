package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {

        try (FileInputStream inputStream = new FileInputStream(file)){
            String[] data = new String[] {"", "", "", ""};
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
                return new Profile(data[0], Integer.parseInt(data[1]), data[2], Long.parseLong(data[3]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        FileReader fileReader = new FileReader();
        Profile actual = fileReader.getDataFromFile(new File("src/main/resources/Profile.txt"));

    }
}
