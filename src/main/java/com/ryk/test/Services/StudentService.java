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
