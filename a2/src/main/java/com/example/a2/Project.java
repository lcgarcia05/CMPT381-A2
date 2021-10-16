package com.example.a2;

import java.time.LocalDate;
import java.time.LocalTime;

/*
    An object model of a project
 */
public class Project {
    private String pName;
    private LocalDate pStartDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String pDescription;
    private double totalHours;
    private double totalMinutes;

    public Project(String name, LocalDate startDate, String description, LocalTime startTime, LocalTime endTime){
        this.pName = name;
        this.pStartDate = startDate;
        this.pDescription = description;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    @Override
    public String toString() {
        return String.format("Project Name: %s \n" +
                             "Start Date: %tD \n" +
                             "Description: %s \n" +
                             "Start Time: %tT \n" +
                             "End Time: %tT \n" +
                             "Total Hours: %.2f", pName, pStartDate, pDescription, startTime, endTime, totalHours);
    }

    public void updateStartTime(LocalTime s){
        this.startTime = s;
    }

    public void updateEndTime(LocalTime s){
        this.endTime = s;
    }

    public void updateTotalHours(double h){
        this.totalHours = totalHours + h + totalMinutes;
    }

    public void updateTotalMinutes(double m){
        this.totalMinutes = m / 60;
    }

    public double getTotalHours(){
        return this.totalMinutes;
    }
}
