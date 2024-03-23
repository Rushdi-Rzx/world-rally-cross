package com.example.javacw;

import java.util.*;
public class DriversList {

    private String Name;
    private String Age;
    private String Team;
    private String Car;
    private String Points;


    public DriversList(String Name, String Age, String Team, String Car, String Points) { //Constructor to initialize data
        this.Name = Name;
        this.Age = Age;
        this.Team = Team;
        this.Car = Car;
        this.Points = Points;
    }

    //Getter methods
    public String getName() {
        return Name;
    }

    public String getAge() {
        return Age;
    }

    public String getTeam() {
        return Team;
    }

    public String getCar() {
        return Car;
    }

    public String getPoints() {

        return Points;
    }
}