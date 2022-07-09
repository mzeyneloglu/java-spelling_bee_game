package com.example.userjavafxspelling;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader mainLoader = new FXMLLoader(StartApplication.class.getResource("maingui.fxml"));
        Scene mainGui = new Scene(mainLoader.load(), 600, 380);
        stage.setTitle("Spelling Bee!");
        stage.setScene(mainGui);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}