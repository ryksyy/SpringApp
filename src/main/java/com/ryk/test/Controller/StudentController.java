package com.ryk.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryk.test.Services.StudentService;
import com.ryk.test.data.Student;

@RestController
public class StudentController {

    @Autowired
    StudentService sService;

    @Autowired 
    CourseController cService;

    @GetMapping("getStudents")
    public List<Student> getStudents() {
        return sService.getStudents();
    }

    @DeleteMapping("dropAllData") //empties all 3 files, mainly for debugging purposes
    public void dropAllData(){
        sService.dropAllData();
    }

    @PostMapping("addStudent")
    public Student addStudent(@RequestBody Student student){
        sService.addStudent(student);
        return student;
    }

    @GetMapping("searchStudentId")
    public String searchStudentId(@RequestParam String id){
        Student stud = sService.getStudentById(id);
        if(stud != null){
            String res = "Name: " + stud.getName() + "\r\nCredits: " + stud.getCredits() + "\r\nID: " + stud.getStudentId() + "\r\nAge: " + stud.getAge() + "\r\nCourses " + stud.getCourses();
            return res;
        }else{
            return "No such student, try another Id";
        }
    }

    @PutMapping("enroll")
    public String enrollStudent(@RequestBody String studentId, @RequestBody String courseId){
        return "Succesfully added " + sService.getStudentById(studentId).getName() + "to course ";
    }
}
