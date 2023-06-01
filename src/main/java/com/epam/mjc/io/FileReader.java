package com.epam.mjc.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file){
        String string ="";
        java.io.FileReader reader = null;
        try{
            reader = new java.io.FileReader(file.getAbsoluteFile());
            int data = reader.read();
            while(data !=-1){
                string +=(char) data;
                data = reader.read();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("no");
            }
        }


        String[] values = new String[4];
        int j = 0;
        for(String i : string.split("\n")){
            int start = i.indexOf(": ")+1;
            String value = i.substring(start).trim();
            values[j]= value;
            j++;
        }
        String name = values[0];
        Integer age = Integer.valueOf(values[1]);
        String email = values[2];
        Long phone = Long.valueOf(values[3]);

        return new Profile(name,age,email,phone);
    }

}
