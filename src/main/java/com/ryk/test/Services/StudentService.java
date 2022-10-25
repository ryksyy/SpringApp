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

}
