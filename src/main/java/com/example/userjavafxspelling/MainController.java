package com.example.userjavafxspelling;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button buttonPC;

    @FXML
    private Button buttonUser;

    @FXML
    void actionButtonPC(ActionEvent event) {
        try {
            // FXML Loader
            FXMLLoader pcMainLoader = new FXMLLoader(StartApplication.class.getResource("pcmain.fxml"));
            Scene pcGui = new Scene(pcMainLoader.load() , 1000,700);
            // Scene Setup
            Stage stage = new Stage();
            stage.setScene(pcGui);
            stage.show();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    @FXML
    void actionButtonUser(ActionEvent event) {
        try{
            // FXML Loader
            FXMLLoader pcMainLoader = new FXMLLoader(StartApplication.class.getResource("usermain.fxml"));
            Scene userGui = new Scene(pcMainLoader.load() , 1000,700);
            // Scene Setup
            Stage stage = new Stage();
            stage.setScene(userGui);
            stage.show();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

}
