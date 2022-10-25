package com.ryk.test.data;

public class ClassCourse extends Course{
    private String classRoom = "";
    private String weekDay = "";
    private String startTime = "";
    private double classLenght = 0.0; //in hours

    //child of Course, has information only relevant to itself

    public ClassCourse(String classRoom, String weekDay, String startTime, double classLenght) {
        this.classRoom = classRoom;
        this.weekDay = weekDay;
        this.startTime = startTime;
        this.classLenght = classLenght;
    }

    public String getClassRoom() {
        return this.classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getWeekDay() {
        return this.weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public double getClassLenght() {
        return this.classLenght;
    }

    public void setClassLenght(double classLenght) {
        this.classLenght = classLenght;
    }
    
}
