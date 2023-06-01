package com.epam.mjc.io;

import java.io.File;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder string = new StringBuilder();
        try (java.io.FileReader reader = new java.io.FileReader(file.getAbsolutePath())){
            int data = reader.read();
            while (data != -1) {
                string.append((char) data);
                data = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        String[] values = new String[4];
        int j = 0;
        for (String i : string.toString().split("\n")) {
            int start = i.indexOf(": ") + 1;
            String value = i.substring(start).trim();
            values[j] = value;
            j++;
        }
        String name = values[0];
        Integer age = Integer.valueOf(values[1]);
        String email = values[2];
        Long phone = Long.valueOf(values[3]);

        return new Profile(name, age, email, phone);
    }

}
