package com.example.javacw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WRCApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("coverScene.fxml"));
        primaryStage.setTitle("WORLD RALLY CROSS");
        primaryStage.setScene(new Scene(root,950,600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}