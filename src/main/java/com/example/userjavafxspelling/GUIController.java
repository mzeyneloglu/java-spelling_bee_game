package com.example.userjavafxspelling;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

public class GUIController {

    @FXML
    private Button btnDelete;


    @FXML
    private Button btnEnter;

    @FXML
    private Button btnMiddle;

    @FXML
    private Button btnSuffle;

    @FXML
    private Button btnWord;

    @FXML
    private Button btnWord1;

    @FXML
    private Button btnWord2;

    @FXML
    private Button btnWord3;

    @FXML
    private Button btnWord4;

    @FXML
    private Button btnWord5;

    @FXML
    private TextField textField;

    @FXML
    private  Label labelScoreWord;

    @FXML
    private ListView listView;
    @FXML
    private Label labelSecondScore;

    // ----------------------------------------------------------- DELETE CHARACTERS FROM TEXT FIELD
    @FXML
    void actionBtnDelete(ActionEvent event) {
        // Code write here
        if(!textField.getText().trim().isEmpty())
            textField.setText(textField.getText(0, textField.getLength()-1));
    }
    // ----------------------------------------------------------- DELETE CHARACTERS FROM TEXT FIELD

    // ----------------------------------------------------------- CHECK CORRECT WORDS AND ADD LIST VIEW
    @FXML
    void actionBtnEnter(ActionEvent event){
        if(textField.getText().length() < 4){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Too short", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }
        else {
            // Correct Word Score List
            int[] correctWordNumbers = {Integer.parseInt(labelScoreWord.getText())};
            int [] scoreWord = {Integer.parseInt(labelSecondScore.getText())};
            ArrayList <String> correctWordList = new ArrayList<>();
            try {
                // Text Reader
                String charactersPath = "src/main/resources/com/example/userjavafxspelling/pangrams.txt";
                String wordListPath = "src/main/resources/com/example/userjavafxspelling/sozluk.txt";
                WordListReader wordListReaderCharacters = new WordListReader(charactersPath);
                WordListReader wordListReader = new WordListReader(wordListPath);
                // String Array List
                HashSet<String> characterList = wordListReaderCharacters.wordReader();
                HashSet<String> wordList = wordListReader.wordReader();
                // Random Char Generator
                int counter = 0;
                RandomCharGenerator randomCharGenerator = new RandomCharGenerator();
                // Correct Word Check
                CorrectWords correctWords = new CorrectWords();

                // Action Code Blocks
                String textFieldString = textField.getText();
                correctWords.correctCheckWord(wordList ,textField);
                randomCharGenerator.charGenerator(counter,characterList);
                char middleWord = randomCharGenerator.getMiddleWord();
                boolean middleCheck = false;
                for(int i = 0; i < textFieldString.length(); i++){
                    if(textFieldString.charAt(i) == middleWord)
                        // Checking correct words
                        middleCheck = true;
                }
                if(correctWords.isCheckWord() && middleCheck && !listView.getItems().contains(textFieldString)){

                    // Check Pangram Word
                    if(textFieldString.contains(btnWord.getText()) && textFieldString.contains(btnWord1.getText())
                            && textFieldString.contains(btnWord2.getText()) && textFieldString.contains(btnWord3.getText())
                            && textFieldString.contains(btnWord4.getText()) && textFieldString.contains(btnWord5.getText())
                            && textFieldString.contains(btnMiddle.getText())){
                        correctWordNumbers[0] += 1;
                        scoreWord[0] += 7;
                        correctWordList.add(textField.getText());
                        listView.getItems().add(textField.getText());
                    }
                    // Score Plus and Add Listview
                    else {
                        correctWordNumbers[0] += 1;
                        scoreWord[0] += textField.getText().length() - 3;
                        correctWordList.add(textField.getText());
                        listView.getItems().add(textField.getText());
                    }
                }
                // Alert Windows
                else if (!correctWords.isCheckWord() && randomCharGenerator.containsChar(textFieldString,middleWord) && textField.getText().length() >= 4){
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Not in the word list", ButtonType.OK);
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.show();
                }

                // Middle Word Exception
                if(!randomCharGenerator.containsChar(textFieldString,middleWord) && textFieldString.length() >= 4 ){
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Missing center letter", ButtonType.OK);
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.show();
                }

                // Founded Word Counter
                labelScoreWord.setText(Integer.toString(correctWordNumbers[0]));
                labelSecondScore.setText(Integer.toString(scoreWord[0]));

                // Reset text field when click the button enter
                textField.setText("");

            }catch (FileNotFoundException ex){
                ex.printStackTrace();
            }
        }

    }
    @FXML
    void actionTextField(ActionEvent event) {
        if(textField.getText().length() < 4){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Too short", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }
        else {
            // Correct Word Score List
            int[] correctWordNumbers = {Integer.parseInt(labelScoreWord.getText())};
            int [] scoreWord = {Integer.parseInt(labelSecondScore.getText())};
            ArrayList <String> correctWordList = new ArrayList<>();
            ArrayList <String> scoreWordNumbers = new ArrayList<>();
            try {
                // Text Reader
                String charactersPath = "src/main/resources/com/example/userjavafxspelling/pangrams.txt";
                String wordListPath = "src/main/resources/com/example/userjavafxspelling/sozluk.txt";
                WordListReader wordListReaderCharacters = new WordListReader(charactersPath);
                WordListReader wordListReader = new WordListReader(wordListPath);
                // String Array List
                HashSet<String> characterList = wordListReaderCharacters.wordReader();
                HashSet<String> wordList = wordListReader.wordReader();
                // Random Char Generator
                int counter = 0;
                RandomCharGenerator randomCharGenerator = new RandomCharGenerator();
                // Correct Word Check
                CorrectWords correctWords = new CorrectWords();

                // Action Code Blocks
                String textFieldString = textField.getText();
                correctWords.correctCheckWord(wordList ,textField);
                randomCharGenerator.charGenerator(counter,characterList);
                char middleWord = randomCharGenerator.getMiddleWord();
                boolean middleCheck = false;
                for(int i = 0; i < textFieldString.length(); i++){
                    if(textFieldString.charAt(i) == middleWord)
                        // Checking correct words
                        middleCheck = true;
                }
                if(correctWords.isCheckWord() && middleCheck && !listView.getItems().contains(textFieldString)){
                    // Check Pangram Word
                    if(textFieldString.contains(btnWord.getText()) && textFieldString.contains(btnWord1.getText())
                            && textFieldString.contains(btnWord2.getText()) && textFieldString.contains(btnWord3.getText())
                            && textFieldString.contains(btnWord4.getText()) && textFieldString.contains(btnWord5.getText())
                            && textFieldString.contains(btnMiddle.getText())){
                        correctWordNumbers[0] += 1;
                        scoreWord[0] += 7;
                        correctWordList.add(textField.getText());
                        listView.getItems().add(textField.getText());
                    }
                    // Score Plus and Add Listview
                    else {
                        correctWordNumbers[0] += 1;
                        scoreWord[0] += textField.getText().length() - 3;
                        correctWordList.add(textField.getText());
                        listView.getItems().add(textField.getText());
                    }
                }
                // Alert Windows
                else if (!correctWords.isCheckWord() && randomCharGenerator.containsChar(textFieldString,middleWord) && textField.getText().length() >= 4){
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Not in the word list", ButtonType.OK);
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.show();
                }

                // Middle Word Exception
                if(!randomCharGenerator.containsChar(textFieldString,middleWord) && textFieldString.length() >= 4 ){
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Missing center letter", ButtonType.OK);
                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                    alert.show();
                }
                // Founded Word Counter
                labelScoreWord.setText(Integer.toString(correctWordNumbers[0]));
                labelSecondScore.setText(Integer.toString(scoreWord[0]));

                // Reset text field when click the button enter
                textField.setText("");

            }catch (FileNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }
    // ----------------------------------------------------------- CHECK CORRECT WORDS AND ADD LIST VIEW
    @FXML
    void actionBtnSuffle(ActionEvent event) {
        try
        {
            // Text Reader
            String charactersPath = "src/main/resources/com/example/userjavafxspelling/pangrams.txt";
            WordListReader wordListReaderCharacters = new WordListReader(charactersPath);

            // String Array List
            HashSet<String> characterList = wordListReaderCharacters.wordReader();

            // Random Char Generator
            RandomCharGenerator randomCharGenerator = new RandomCharGenerator();
            randomCharGenerator.charGenerator(0,characterList);
            String randomString = randomCharGenerator.getShuffleString();

            btnWord.setText(String.valueOf(randomString.charAt(0)));
            btnWord1.setText(String.valueOf(randomString.charAt(1)));
            btnWord2.setText(String.valueOf(randomString.charAt(2)));
            btnWord3.setText(String.valueOf(randomString.charAt(3)));
            btnWord4.setText(String.valueOf(randomString.charAt(4)));
            btnWord5.setText(String.valueOf(randomString.charAt(5)));

            char middleWord = randomCharGenerator.getMiddleWord();
            btnMiddle.setText(String.valueOf(middleWord));

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }

    }
    @FXML
    void keyEventTextField(KeyEvent keyEvent) {
        // Force the field to be alphabetic only
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("^\\p{Alpha}+$")) {
                    textField.setText(newValue.replaceAll("[^\\\\p{Alpha}+$]", ""));
                }
                else
                    textField.setText(newValue.toUpperCase());
            }
        });
    }
    @FXML
    void buttonClickEvent(ActionEvent event) {
        String letterChar = ((Button)event.getSource()).getText();
        textField.appendText(letterChar);
    }


}
