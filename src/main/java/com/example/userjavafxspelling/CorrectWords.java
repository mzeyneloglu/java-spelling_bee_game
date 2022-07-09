package com.example.userjavafxspelling;

import javafx.scene.control.TextField;
import java.util.HashSet;
import java.util.Locale;


public class CorrectWords {

    // Fields
    private boolean checkWord;

    public void correctCheckWord(HashSet<String> wordList, TextField textField) {
        this.checkWord = false;
        if (wordList.contains(textField.getText().toLowerCase())){
            this.checkWord = true;

        }
    }

    // Return Correct List Method
    public HashSet<String> returnCorrectList(HashSet<String> wordList, TextField textField) {
        HashSet<String> correctWordList = new HashSet<>();
        this.checkWord = false;
        if (wordList.contains(textField.getText())){
            this.checkWord = true;
            correctWordList.add(textField.getText());
        }
        return correctWordList;
    }

    // Get Methods
    public boolean isCheckWord(){
        return this.checkWord;
    }
}