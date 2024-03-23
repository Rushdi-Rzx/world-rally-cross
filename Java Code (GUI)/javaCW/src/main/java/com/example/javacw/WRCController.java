package com.example.javacw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WRCController {

    //Menu Buttons
    @FXML
    private Button Button;

    @FXML
    private Button ADDButton;

    //ADD Driver Details
    @FXML
    private TextField NameField;

    @FXML
    private Label NameError;

    @FXML
    private TextField AgeField;

    @FXML
    private Label AgeError;

    @FXML
    private TextField TeamField;

    @FXML
    private Label TeamError;

    @FXML
    private TextField CarField;

    @FXML Label CarError;

    @FXML
    private TextField PointsField;

    @FXML
    private Label PointsError;

    @FXML
    private Label AddedDetails;

    @FXML
    private Label ADDSuccessMessage;

    @FXML
    private Label ADDErrorMessage;


    //Delete Driver Details
    @FXML
    private TextField DeleteNameField;

    @FXML
    private Label DeleteMessageField;

    @FXML
    private Label DeleteDriverFoundMessage;

    @FXML
    private Label DeleteDriverNotFoundMessage;

    //Update Driver Details
    @FXML
    private TextField NewNameField;

    @FXML
    private Label NewNameError;

    @FXML
    private TextField NewAgeField;

    @FXML
    private Label NewAgeError;

    @FXML
    private TextField NewTeamField;

    @FXML
    private Label NewTeamError;

    @FXML
    private TextField NewCarField;

    @FXML Label NewCarError;

    @FXML
    private TextField NewPointsField;

    @FXML
    private Label NewPointsError;

    @FXML
    private TextField UpdateNameField;

    @FXML
    private Label UpdateMessageField;

    @FXML
    private Label UpdateFoundMessageField;

    @FXML
    private Label UpdateSuccessField;

    @FXML
    private Label UpdateErrorMessageField;

    @FXML
    private Button SaveDataButton;

    @FXML
    private Label SaveDataMessage;




    //Handling Main Interface Buttons
    public void handleCoverButton() throws Exception{ //To go from coverScene to menuScene
        Parent root = FXMLLoader.load(getClass().getResource("menuScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    public void handleMainMenuButton() throws Exception { //To go back to menuScene
        Parent root = FXMLLoader.load(getClass().getResource("menuScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root, 950, 600));
    }
    public void handleAddButton() throws Exception{ //To go from menuScene to addScene
        Parent root = FXMLLoader.load(getClass().getResource("addScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    public void handleDeleteButton() throws Exception{ //To go from menuScene to deleteScene
        Parent root = FXMLLoader.load(getClass().getResource("deleteScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    public void handleUpdateButton() throws Exception{ //To go from menuScene to updateScene
        Parent root = FXMLLoader.load(getClass().getResource("updateScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }
    public void handleVCTButton() throws Exception{ //To go from menuScene to vctScene
        Parent root = FXMLLoader.load(getClass().getResource("vctScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root,950,600));
    }

    public void handleSRRButton() throws Exception{ //To go from menuScene to srrScene
        Parent root = FXMLLoader.load(getClass().getResource("srrScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root,950,600));

    }

    public void handleRaceTableButton() throws Exception{ //To go from menuScene to vrlScene
        Parent root = FXMLLoader.load(getClass().getResource("vrlScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root,950,600));

    }

    public void handleSaveDataButton() throws Exception{ //To go from menuScene to stfScene
        Parent root = FXMLLoader.load(getClass().getResource("stfScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root,950,600));

    }

    public void handleLoadDataButton() throws Exception{ //To go from menuScene to rffScene
        Parent root = FXMLLoader.load(getClass().getResource("rffScene.fxml"));
        Stage window = (Stage) Button.getScene().getWindow();
        window.setScene(new Scene(root,950,600));

    }

    public void handleExitButton() throws Exception{
        System.exit(0);
    }


    int age, points, updateAge, updatePoints;
    /**Initializing variables for age,points,updateAge and updatePoints,
     So we Can convert the driverDetailsList String data to Int */
    String foundDriver, updatedDriver, existingDriver; /** Initializing variable */


//DRIVER ADDING
    public void addDriverDetails(){
        ArrayList driver = new ArrayList(); //ArrayList to store adding driver details

        driver.add(NameField.getText());  //Adds the user input data to the driver list
        driver.add(AgeField.getText());  //Adds the user input data to the driver list
        driver.add(TeamField.getText()); //Adds the user input data to the driver list
        driver.add(CarField.getText()); //Adds the user input data to the driver list
        driver.add(PointsField.getText()); //Adds the user input data to the driver list
        Driver.driversDetailsList.add(driver); //Adds the driver list to the main driverDetailsList in the Driver class
        ADDErrorMessage.setText("");
        AddedDetails.setText("");
        ADDSuccessMessage.setText("Driver Added Successfully"); //Displays the Driver Added Successfully Message
    }


    public void addSubmit(ActionEvent event) throws Exception {
        //Check if all TextFields are empty
        if (NameField.getText().isEmpty() && AgeField.getText().isEmpty() && TeamField.getText().isEmpty() && CarField.getText().isEmpty() && PointsField.getText().isEmpty()){
            ADDErrorMessage.setText("All the fields are Empty. Please Fill!"); //Displays a message if all are empty
        }
        //Check if any TextField is empty
        else if (NameField.getText().isEmpty() || AgeField.getText().isEmpty() || TeamField.getText().isEmpty() || CarField.getText().isEmpty() || PointsField.getText().isEmpty()) {
            ADDSuccessMessage.setText("");
            ADDErrorMessage.setText("Please Fill All the fields!"); //Displays a message if any TextField is empty
        }
        else if (!(AgeField.getText().isEmpty() || PointsField.getText().isEmpty())) { //Checks the Age and Points TextField isn't empty
            try{
                age = Integer.parseInt(AgeField.getText()); //Getting the Age, Converting it to a String and assigning it to the age Variable
                points = Integer.parseInt(PointsField.getText()); //Getting the Points, Converting it to a String and assigning it to the points Variable

                if ((age < 0) ||(points<0)){ //Check if the Age is Negative
                    throw new Exception("Negative Value");
                }
                if(existingEntries(NameField.getText())){ //Checks if the user Input Name is Already existing
                    AddedDetails.setText(existingDriver); //Displays the existing driver details
                    ADDSuccessMessage.setText("");
                    ADDErrorMessage.setText("Driver Already Exists"); //Displays a message if the driver already exist
                }
                else {
                    addDriverDetails(); //Adding the driver details on click "ADD Driver" button
                }
            }
            catch (NumberFormatException e){ //Catching None Integer Values
                ADDSuccessMessage.setText("");
                ADDErrorMessage.setText("Please Enter a Valid Age and Points");
            }

            catch (Exception exception){ //Catching Negative Values
                ADDSuccessMessage.setText("");
                ADDErrorMessage.setText("Negative values Cannot be Added");

            }
        }
    }
    public boolean existingEntries(String existingName){ //Method to check if there are any Existing Drivers
        boolean driverExisting = false; //Makes the driverExisting False
        for (int i = 0; i < Driver.driversDetailsList.size(); i++) { //Loop to check every element in the list
            if (existingName.equals(Driver.driversDetailsList.get(i).get(0))) { //Checks if the Name is equal to any element in the List
                //Getting the existing driver details
                existingDriver = Driver.driversDetailsList.get(i).get(0) + ", " + Driver.driversDetailsList.get(i).get(1) + ", " + Driver.driversDetailsList.get(i).get(2) + ", " + Driver.driversDetailsList.get(i).get(3) + ", " + Driver.driversDetailsList.get(i).get(4);
                driverExisting = true; //Makes the driverExisting True
            }
        }
        return driverExisting; //Returning the Variable
    }

    //DRIVER DELETING

    private void deleteDriver(){ //Method to Delete a Driver
        for (int i=0; i<Driver.driversDetailsList.size(); i++){ //Loops through the driverDetailsList
            if(DeleteNameField.getText().equals(Driver.driversDetailsList.get(i).get(0))){ //Checks If the user input Name matches to the list's name
                Driver.driversDetailsList.remove(i); //Removes all the driver details from the list
                DeleteDriverFoundMessage.setText("");
                DeleteMessageField.setText("Driver Deleted Successfully"); //Shows a success message
            }
        }
    }

    public boolean findDriver(String findDriverName) { //Method to find a driver
        boolean driverFound = false; //Makes the driverFound False
        for (int i = 0; i < Driver.driversDetailsList.size(); i++) {  //Loop to check every element in the list
            if (findDriverName.equals(Driver.driversDetailsList.get(i).get(0))) { //Checks if the Name is equal to any element in the List
                //Getting the found driver details
                foundDriver = Driver.driversDetailsList.get(i).get(0) + " , " + Driver.driversDetailsList.get(i).get(1) + " , " + Driver.driversDetailsList.get(i).get(2) + " , " + Driver.driversDetailsList.get(i).get(3) + " , " + Driver.driversDetailsList.get(i).get(4);
                driverFound = true; //Makes the driverFound True
            }
        }
        return driverFound; //Returning the Variable
    }

    public void deleteFind(ActionEvent actionEvent) throws Exception{ //Finds the Driver Deleting Name
        if(DeleteNameField.getText().isEmpty()){ //Check if the TextField is Empty
            DeleteDriverNotFoundMessage.setText("");
            DeleteDriverFoundMessage.setText("");
            DeleteMessageField.setText("");
            DeleteDriverNotFoundMessage.setText("Enter the Driver name to delete"); //Displays a message if empty
        }
        else{
            if(findDriver(DeleteNameField.getText())){ //Searching for the user input driver's name
                DeleteDriverNotFoundMessage.setText("");
                DeleteMessageField.setText("");
                DeleteDriverFoundMessage.setText("Driver Found");
                DeleteMessageField.setText(foundDriver); //Displays a message if found
            }
            else{
                DeleteDriverNotFoundMessage.setText("");
                DeleteDriverFoundMessage.setText("");
                DeleteMessageField.setText("");
                DeleteDriverNotFoundMessage.setText("Driver not found");  //Displays a message if not found
            }
        }
    }

    public void deleteSubmit(ActionEvent event) throws Exception { //Handles the Deleting button
        deleteDriver(); //Runs the deleteDriver method
    }

    // DIVER UPDATING
    private void updateDriver(){ //Method to update driver
        for (int i=0; i<Driver.driversDetailsList.size(); i++){ //Loops through the driverDetailsList
            if(UpdateNameField.getText().equals(Driver.driversDetailsList.get(i).get(0))){ //check if the user input Name is equal to Driver Name
                Driver.driversDetailsList.get(i).set(0, NewNameField.getText()); //Getting the Driver and setting the New Value
                Driver.driversDetailsList.get(i).set(1, NewAgeField.getText()); //Getting the Driver and setting the New Value
                Driver.driversDetailsList.get(i).set(2, NewTeamField.getText()); //Getting the Driver and setting the New Value
                Driver.driversDetailsList.get(i).set(3, NewCarField.getText()); //Getting the Driver and setting the New Value
                Driver.driversDetailsList.get(i).set(4, NewPointsField.getText()); //Getting the Driver and setting the New Value
                UpdateFoundMessageField.setText("");
                UpdateSuccessField.setText("Driver Updated Successfully"); //Success Message
            }
        }
    }
    public void updateFindButton(ActionEvent actionEvent) throws Exception{ //Method to find the Driver to Update
        if(UpdateNameField.getText().isEmpty()){ //check if the TextField is empty
            UpdateMessageField.setText("Enter the Driver name");//Displays error
        }
        else {
            if (findDriver(UpdateNameField.getText())){ //Finding the driver
                UpdateFoundMessageField.setText("Driver Found, Please Update the details");// Success Message
            }
            else
            {
                UpdateMessageField.setText("Driver Not Found"); //Error Message
            }
        }
    }

    public void updateSubmit(ActionEvent actionEvent) throws Exception{ //Method to validate and submit updated details
        //Check if all TextFields are empty
        if (NewNameField.getText().isEmpty() && NewAgeField.getText().isEmpty() && NewTeamField.getText().isEmpty() && NewCarField.getText().isEmpty() && NewPointsField.getText().isEmpty()){
            UpdateSuccessField.setText("");
            UpdateErrorMessageField.setText("All the fields are Empty. Please Fill!");
        }
        //Check if any TextField is empty
        else if (NewNameField.getText().isEmpty() || NewAgeField.getText().isEmpty() || NewTeamField.getText().isEmpty() || NewCarField.getText().isEmpty() || NewPointsField.getText().isEmpty())
        {
            UpdateMessageField.setText("");
            UpdateSuccessField.setText("");
            UpdateErrorMessageField.setText("Please Fill All the fields");//Displays a message if any TextField is empty
        } else if (!(NewAgeField.getText().isEmpty() || NewPointsField.getText().isEmpty())) {
            try{
                updateAge = Integer.parseInt(NewAgeField.getText()); //Getting the New Age, Converting it to a String and assigning it to the newAge Variable
                updatePoints = Integer.parseInt(NewPointsField.getText()); //Getting the New Points, Converting it to a String and assigning it to the newPoints Variable

                if ((updateAge < 0) ||(updatePoints<0)){ //Check if the Age is Negative
                    throw new Exception("Negative Value");
                }
                else
                {
                    updateDriver(); //Updating the driver details on click "Update Driver" button
                }
            }
            catch (NumberFormatException e){ //Catching None Integer Values
                UpdateSuccessField.setText("");
                UpdateErrorMessageField.setText("Please Enter a Valid Age and Points");
            }

            catch (Exception exception){ //Catching Negative Values
                UpdateSuccessField.setText("");
                UpdateErrorMessageField.setText("Negative values Cannot be Added");

            }
        }
    }

    public void saveDataToFile(){ //Method to Save Data to a Text File
        try {
            //Creating a BufferedWriter Method
            BufferedWriter writer = new BufferedWriter(new FileWriter("driverList.txt"));
            String tableHeader = String.format("%-20s %-10s %-20s %-20s %-10s",
                    "Name", "Age", "Team", "Car", "Points"); //Aligned Table header
            String lines = String.format("==========================================="); //Line to separate header
            writer.write(tableHeader); //writing the table header
            writer.newLine();
            writer.write(lines);//writing the line separator
            writer.newLine();

            for (ArrayList<String> driverDetails : Driver.driversDetailsList){ //write driverDetailsList data to the file
                String formattedLine = String.format("%-20s %-10s %-20s %-20s %-10s", //Aligning the driver details
                        driverDetails.get(0), driverDetails.get(1), driverDetails.get(2),
                        driverDetails.get(3), driverDetails.get(4));
                writer.write(formattedLine); //write the driver details
                writer.newLine();
            }
            writer.close(); //closing the writer

        } catch (IOException e) { //Handling IOExceptions
            SaveDataMessage.setText("Error Saving the data, Please Try Again");
        }
    }

    public void stfSubmit(){
        saveDataToFile(); //Calling the saveDataToFile() method
        SaveDataMessage.setText("Data saved to driversData.txt successfully."); //Success Message

    }




}


