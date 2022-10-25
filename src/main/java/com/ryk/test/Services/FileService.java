package com.ryk.test.Services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import org.springframework.stereotype.Service;

import com.ryk.test.data.ClassCourse;
import com.ryk.test.data.OnlineCourse;
import com.ryk.test.data.Student;

@Service
public class FileService {
    //As text documents are finicky to work with creating universal methods for reading and writing data into one file is going to be
    //unreadable and messy
    //there will be three files, students, onlineCourses and classRoomCourses with independant read and write functions
    //I realize this is not the optimal way (or even good really) but since the project is small enough scale and
    //text document manipulation is a part of the course this is the way I'm going to make it
    

    /*-------------------- WRITE METHODS ------------------ */
    //These are passed the server side, saved in memory lists of courses and they write that data directly to a file
    //To avoid overwriting already written data the services call the read methods on start up to catch up to what is already in the files
    public void writeStudents(List<Student> students){
        try{
        FileWriter fw = new FileWriter(new File("./text/students.txt"));
        for (Student student : students) {
            fw.write(student.getName() + System.lineSeparator());
            fw.write(student.getAge() + System.lineSeparator());
            fw.write(student.getStudentId() + System.lineSeparator());
            fw.write(student.getCredits() + System.lineSeparator());
            fw.write(student.getCourses() + System.lineSeparator());
        }
        fw.close();
        }catch(IOException e){
            System.out.println("Error writing students: " + e);
        }
    }

    public void writeOnline(List<OnlineCourse> oCourses) {
        try{
        FileWriter fw = new FileWriter(new File("./text/onlinecourses.txt"));
        for (OnlineCourse onlineCourse : oCourses) {
            fw.write(onlineCourse.getCourseCred() + System.lineSeparator());
            fw.write(onlineCourse.getCourseName() + System.lineSeparator());
            fw.write(onlineCourse.getCourseId() + System.lineSeparator());
            fw.write(onlineCourse.getTeacher() + System.lineSeparator());
            fw.write(onlineCourse.getZoomLink() + System.lineSeparator());
            fw.write(onlineCourse.getRecordingLink() + System.lineSeparator());
        }
        fw.close();
        }catch(IOException e){
            System.out.println("Error writing onlinecourses: " + e);
        }
    }
    
    public void writeClass(List<ClassCourse> cCourses){
        try{
        FileWriter fw = new FileWriter(new File("./text/classcourses.txt"));
        for (ClassCourse classCourse : cCourses) {
            fw.write(classCourse.getCourseCred() + System.lineSeparator());
            fw.write(classCourse.getCourseName() + System.lineSeparator());
            fw.write(classCourse.getCourseId() + System.lineSeparator());
            fw.write(classCourse.getTeacher() + System.lineSeparator());
            fw.write(classCourse.getClassRoom() + System.lineSeparator());
            fw.write(classCourse.getWeekDay() + System.lineSeparator());
            fw.write(classCourse.getStartTime() + System.lineSeparator());
            fw.write(classCourse.getClassLenght() + System.lineSeparator());
        }
        fw.close();
        }catch(IOException e){
            System.out.println("Error writing classCourses: " + e);
        }
    }


    /*-------------------- READ METHODS ------------------ */
    //Pull data from the text file, and add to students var, each student has 5rows of information
    //so dividing row amount by 5 will return how many students are saved
    //which allows us to gather each individual student information and saving it before moving to the next one
    //similar logic will be used to implement course reading
    public List<Student> readStudents() {
        try{
            Scanner sc = new Scanner(new File("./text/students.txt"));
            List<Student> students = new ArrayList<>();
            int rows = 0;
            while(sc.hasNextLine()){
                rows++;
                sc.nextLine();
            }
            sc = new Scanner(new File("./text/students.txt"));

            rows = rows / 5;
            if(rows > 0){
                for(int i = 0; i < rows; i++){
                Student stud;
                String name = sc.nextLine();
                int age = Integer.parseInt(sc.nextLine());
                String id = sc.nextLine();
                int credits = Integer.parseInt(sc.nextLine());
                String courseString = sc.nextLine();
                List<String> courses = new ArrayList<>();
                courses.add(courseString);
                stud = new Student(name, age, credits);
                stud.setCourses(courses);
                stud.setStudentId(id);
                students.add(stud);
                }
            }
        
        sc.close();
        return students;
        }catch(FileNotFoundException e){
            System.out.println("Error reading students: " + e);
            return null;
        }
    }
}
