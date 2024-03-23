package com.example.javacw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class srrController {

    @FXML
    private Button Button;
    @FXML
    private Label outputLabel;

    @FXML
    private Label MessageLabel;

    public void handleMainMenuButton() throws Exception { //To go back to menuScene
        Parent root = FXMLLoader.load(getClass().getResource("menuScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root, 950, 600));
    }

    public void simulateRace(ActionEvent event) { //Simulates the random race and saves the race details in the text file
        ArrayList<ArrayList> driversDetailsList = Driver.driversDetailsList;
        LocalDate date = LocalDate.now(); //The Current Date
        String[] raceLocations = {"Nyirád", "Höljes", "Montalegre", "Barcelona", "Rīga", "Norway"}; //Random Location List
        StringBuilder raceDetails = new StringBuilder();
        raceDetails.append(" ").append("\n");
        raceDetails.append("=======RACE DETAILS=======").append("\n"); //Title
        raceDetails.append(" ").append("\n");
        raceDetails.append("Date: ").append(date).append("\n"); //date
        raceDetails.append(" ").append("\n");
        Random random = new Random();
        for (int i = 0; i < driversDetailsList.size(); i++) {
            int position = i + 1; //Calculates the position of the driver
            int points = 0; //Initialize the points into 0
            switch (position) {
                case 1:
                    points = 10;
                    break;
                case 2:
                    points = 7;
                    break;
                case 3:
                    points = 5;
                    break;
                default:
                    points = 0;
            }

            ArrayList<String> driverDetails = driversDetailsList.get(i); //Adding the driver details to the driverDetailsList
            driverDetails.add("Position: " + position);
            driverDetails.add("Points: " + points);


            //Appending the race details to String Builder
            raceDetails.append("Driver: ").append("\t").append(driverDetails.get(0)).append("\t")
                    .append(", Position: ").append("\t").append(position).append("\t")
                    .append(", Points: ").append("\t").append(points).append("\t")
                    .append(", Location: ").append("\t").append(raceLocations[random.nextInt(raceLocations.length)]).append("\t")
                    .append("\n");
        }
        try {
            //Writes the race details into the file
            BufferedWriter writer = new BufferedWriter(new FileWriter("raceDetails.txt", true));
            writer.write(raceDetails.toString());
            writer.close();
            MessageLabel.setText("Race Simulated Successfully");
        } catch (IOException e) {
            MessageLabel.setText("Error Simulating Race");
        }
    }

    public void loadRaceDetails(ActionEvent event) { //Loads the race
        //Read race details from the file and display it on the label
        try {
            BufferedReader reader = new BufferedReader(new FileReader("raceDetails.txt"));
            String line;
            StringBuilder data = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
            reader.close();
            outputLabel.setText("Race details loaded successfully:\n" + data.toString());
        } catch (IOException e) {
            outputLabel.setText("Error loading race details from file: ");
        }
    }
}
