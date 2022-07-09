package com.example.userjavafxspelling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class WordListReader {
    // Field
    private String path;
    // Constructor
    public WordListReader(String path){
        this.path = path;
    }
    // Reader Method
    public HashSet<String> wordReader () throws FileNotFoundException {
        File txt = new File(path);
        Scanner scanner = new Scanner(txt);
        HashSet <String> words = new HashSet<String>();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            words.add(data);
        }
        scanner.close();
        return words;
    }
}
