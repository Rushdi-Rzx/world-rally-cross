package com.example.javacw;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class vrlController {
    @FXML
    private Label raceListLabel;
    @FXML
    private javafx.scene.control.Button Button;

    public void handleMainMenuButton() throws Exception { //To go back to menuScene
        Parent root = FXMLLoader.load(getClass().getResource("menuScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root, 950, 600));
        BufferedWriter writer = new BufferedWriter(new FileWriter("raceDetails.txt")); //This clears the Label When going back to the menu
        writer.write("");
        writer.close();
    }

    public void initialize() {
        try {
            //Reads the data from the raceDetails.txt
            BufferedReader reader = new BufferedReader(new FileReader("raceDetails.txt"));
            String line;
            ArrayList<String> races = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                races.add(line);
            }
            reader.close();

            for (int i = 0; i < races.size() - 1; i++) {
                //Using Bubble Sort to sort the date
                for (int j = 0; j < races.size() - i - 1; j++) {
                    String race1 = races.get(j);
                    String race2 = races.get(j + 1);
                    LocalDate date1 = parseDate(race1);
                    LocalDate date2 = parseDate(race2);
                    if (date1 != null && date2 != null && date1.isAfter(date2)) {
                        Collections.swap(races, j, j + 1);
                    }
                }
            }

            //Creating raceList and setting it to raceListLabel
            StringBuilder raceList = new StringBuilder();
            raceList.append("====================RACE LIST====================").append("\n");
            for (String race : races) {
                raceList.append(race).append("\n");
            }
            raceListLabel.setText(raceList.toString());

        } catch (IOException e) {
            raceListLabel.setText("Error loading file"); //Handles exception if an error occurs
        }
    }
    private LocalDate parseDate(String raceDetails) {
        String[] lines = raceDetails.split("\n"); //Splits into an array list of line
        for (String line : lines) { //Loop through all the lines
            if (line.startsWith("Date: ")) { //checks the line start with "Date: "
                String dateString = line.substring(6).trim();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //Formatting the date
                return LocalDate.parse(dateString, formatter); //Prase the date string into a LocalDate object
            }
        }
        return null;
    }
}