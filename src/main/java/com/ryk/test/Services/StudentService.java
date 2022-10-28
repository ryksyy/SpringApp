package com.ryk.test.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryk.test.data.Student;

@Service
public class StudentService {

    @Autowired
    FileService fService;

    private List<Student> students = new ArrayList<>();

    //read possible students first to not accidentally overwrite students.txt if adding a student before getting
    //then add new student to memory and write the whole student list, including from  file to the file again
    public void addStudent(Student sData){
        getStudents();
        students = fService.readStudents();
        students.add(sData);
        fService.writeStudents(students);
    }

    public List<Student> getStudents() {
        students = fService.readStudents();
        return students;
    }

    public List<String> getStudentsCourses(String id){
        if(getStudentById(id) == null)
            return null;
        Student studs = getStudentById(id);
        return studs.getCourses();
    }


    //goes through all students and checks if they have courses
    //if they have courses it goes through all their courses checking if one matches passed id(student has course ids saved)
    //if student has a course with given id it adds that student to a new student list
    //After it returns all studdents who match the criteria, or an empty array in case none do
    public List<Student> getStudentsOnCourse(String id){
        getStudents();
        List<Student> studs = new ArrayList<>();
        for (Student student : students) {
            if(!student.getCourses().isEmpty()){
                for (String s : student.getCourses()) {
                    if(s.equals(id)){
                        studs.add(student);
                    }
                }
            }
        }
        return studs;
    }

    public void dropAllData(){
        fService.dropAllData();
    }

    public Student getStudentById(String id){    
        getStudents();
            for (Student student : students) {
                if(student.getStudentId().equals(id)){
                    return student;
                }
            }   
        return null;     
    }

    //Finds student by id and adds passed courseId to the list of their courses
    public String enrollStudent(String studentId, String courseId){
        getStudents();
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getStudentId().equals(studentId)){
                students.get(i).addCourse(courseId);
                fService.writeStudents(students);
                return "Successfully enrolled student to course";
            }
        }

        return "No such student (issue in service)";
    }

}
