package com.ryk.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ryk.test.Services.StudentService;
import com.ryk.test.data.Student;

@RestController
public class StudentController {

    @Autowired
    StudentService sService;

    @GetMapping("getStudents")
    public List<Student> getStudents() {
        return sService.getStudents();
    }

    @PostMapping("addStudent")
    public Student addStudent(@RequestBody Student student){
        sService.addStudent(student);
        return student;
    }
}
