package com.example.javacw;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class rffController implements Initializable{
    @FXML
    private Button Button;

    @FXML
    private Button displayButton;

    @FXML
    private Label dataLabel;

    @FXML
    private Label rffErrorMessage;

    @FXML
    private Label rffSuccessMessage;

    @FXML
    private void rffSubmit() { //handling rff button
        try {
            //Creating a BufferedWriter Method ro read data
            BufferedReader reader = new BufferedReader(new FileReader("driverList.txt"));
            String line;
            //reading data
            StringBuilder data = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
            reader.close(); //closing the reader
            dataLabel.setText(data.toString());
            rffSuccessMessage.setText("Data Loaded Successfully");
        } catch (IOException e) { //Catching IO Exception
            rffErrorMessage.setText("Error Saving the data, Please Try Again");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { //Method to Initialize the controller
        displayButton.setOnAction(event -> rffSubmit());
    }

    public void handleAddButton() throws Exception{ //To go from rffScene to addScene
        Parent root = FXMLLoader.load(getClass().getResource("addScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }

    public void handleDeleteButton() throws Exception{ //To go from rffScene to deleteScene
        Parent root = FXMLLoader.load(getClass().getResource("deleteScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }

    public void handleSaveDataButton() throws Exception{ //To go from rffScene to stfScene
        Parent root = FXMLLoader.load(getClass().getResource("stfScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root,950,600));

    }

    public void handleMainMenuButton() throws Exception { //To go back to menuScene
        Parent root = FXMLLoader.load(getClass().getResource("menuScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root, 950, 600));
    }

}

