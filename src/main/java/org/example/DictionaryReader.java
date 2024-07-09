package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryReader {
    public List<String> dictionary;

    public DictionaryReader() {
        this.dictionary = new ArrayList<>();
    }

    public List<String> readFile(String fileName) {

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileName))) {

            String str = bufferedReader.readLine();
            while (str != null) {
                dictionary.add(str);
                str = bufferedReader.readLine();
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
        return dictionary;
    }
}