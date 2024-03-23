package com.example.javacw;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class vctController implements Initializable{

    @FXML
    private Button Button;
    @FXML
    private TableColumn<DriversList, String> Car;
    @FXML
    private TableColumn<DriversList, String> Name;
    @FXML
    private TableColumn<DriversList, String> Points;
    @FXML
    private TableView<DriversList> Table;
    @FXML
    private TableColumn<DriversList, String> Team;
    @FXML
    private TableColumn<DriversList, String> Age;

    public void handleMainMenuButton() throws Exception { //To go back to menuScene
        Parent root = FXMLLoader.load(getClass().getResource("menuScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root, 950, 600));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Setting the cell value factories to each column of the table
        Name.setCellValueFactory(new PropertyValueFactory<DriversList, String>("Name"));
        Age.setCellValueFactory(new PropertyValueFactory<DriversList, String>("Age"));
        Team.setCellValueFactory(new PropertyValueFactory<DriversList, String>("Team"));
        Car.setCellValueFactory(new PropertyValueFactory<DriversList, String>("Car"));
        Points.setCellValueFactory(new PropertyValueFactory<DriversList, String>("Points"));

        ObservableList<DriversList> list = FXCollections.observableArrayList(); //ObservableList to store data

        for (int i = 0; i < Driver.driversDetailsList.size(); i++) {
            //Creating a DriverList object for each entry in driverDetailsList
            list.addAll(new DriversList((String) Driver.driversDetailsList.get(i).get(0),
                    (String) Driver.driversDetailsList.get(i).get(1),
                    (String) Driver.driversDetailsList.get(i).get(2),
                    (String) Driver.driversDetailsList.get(i).get(3),
                    (String) Driver.driversDetailsList.get(i).get(4)));
        }

        //Using the Bubble Sorting method to sort the Drivers in Descending order according to the points
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                int points1 = Integer.parseInt(list.get(j).getPoints());
                int points2 = Integer.parseInt(list.get(j + 1).getPoints());
                if (points1 < points2) {
                    DriversList temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        Table.setItems(list); //Setting the sorted data to the Table
    }
}
/**Reference - www.youtube.com. (n.d.). JavaFX and Scene Builder Course -
 * IntelliJ #30: TableView and TableColumn. [online]
 * Available at: https://www.youtube.com/watch?v=fnU1AlyuguE */