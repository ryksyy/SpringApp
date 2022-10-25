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
        students = fService.readStudents();
        students.add(sData);
        fService.writeStudents(students);
    }

    public List<Student> getStudents() {
        students = fService.readStudents();
        return students;
    }

    public void dropAllData(){
        fService.dropAllData();
    }

    public Student getStudentById(String id){    
            for (Student student : students) {
                if(student.getStudentId().equals(id)){
                    return student;
                }
            }   
        return null;     
    }

    public Student enrollStudent(String studentId, String courseId){
        for (Student student : students) {
            if(student.getStudentId().equals(studentId)){
                student.addCourse(courseId);
            }
        }



        return new Student(courseId, 0, 0);
    }

}
