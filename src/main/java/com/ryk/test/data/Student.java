package com.ryk.test.data;

import java.util.ArrayList;
import java.util.List;

//model for student data
public class Student {
    private String name;
    private int age;
    private String studentId; //unique identifier, ignoring the possibility of two students of the same name and age
    private int credits;
    private List<String> courses = new ArrayList<>(); //will contain a list of courseIds

    //create a new "blank" students and assign them id
    public Student(String name, int age, int credits) {
        this.name = name;
        this.age = age;
        this.credits = credits;
        this.studentId = (age + name + "id");
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public int getCredits() {
        return this.credits;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<String> getCourses() {
        return this.courses;
    }

    public void addCourse(String course) {
        this.courses.add(course);
    }
}
