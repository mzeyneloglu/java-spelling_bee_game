package com.example.userjavafxspelling;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomCharGenerator {
    // Field
    private String shuffleString;
    private char middleWord;
    // Constructor
    public RandomCharGenerator(){
        this.shuffleString = "";
        this.middleWord = 0;

    }

    public void charGenerator(int counter, HashSet<String> wordList) {
        char[] wordListCharacters;
        // HashSet to Array List
        ArrayList<String> wordLists = new ArrayList<>(wordList);
        wordListCharacters = wordLists.get(counter).toCharArray();
        this.middleWord = wordListCharacters[wordLists.get(counter).length()-1];
        List<Character> arrayListCharacters = new ArrayList<>();
        for (int j = 0; j < wordListCharacters.length; j++) {
            arrayListCharacters.add(wordListCharacters[j]);
        }
        // Remove Middle Word
        arrayListCharacters.remove(Character.valueOf(this.middleWord));
        // Convert Character List to String List
        String stringListCharacters = arrayListCharacters.toString()
                .substring(1, 3 * arrayListCharacters.size() - 1)
                .replaceAll(", ", "");

        // Shuffle 'stringListCharacters'
        this.shuffleString = shuffle(stringListCharacters);
    }


    // Shuffle String
    public String shuffle(String text) {
        // String --> ['S' ,'t' , 'r', 'i', 'n', 'g']
        char[] characters = text.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = (int) (Math.random() * characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
    // Contains Characters in String
    public  boolean containsChar(String s, char search) {
        if (s.length() == 0)
            return false;
        else
            return s.charAt(0) == search || containsChar(s.substring(1), search);
    }


    // Get Methods
    public String getShuffleString(){
        return this.shuffleString;
    }
    public char getMiddleWord(){
        return this.middleWord;
    }



}
