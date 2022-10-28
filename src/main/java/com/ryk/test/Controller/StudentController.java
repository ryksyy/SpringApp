package com.ryk.test.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryk.test.Services.CourseService;
import com.ryk.test.Services.StudentService;
import com.ryk.test.data.Student;

@RestController
public class StudentController {

    @Autowired
    StudentService sService;

    //Needed for enrolling students to a course
    @Autowired 
    CourseService cService;

    @GetMapping("getStudents")
    public List<Student> getStudents() {
        return sService.getStudents();
    }

    @GetMapping("getStudentsCourses")
    public String getStudentsCourses(@RequestParam String id){
        String res = "";
        List<String> courses = sService.getStudentsCourses(id);
        if(courses == null)
            return "Invalid course id";
        for (String string : courses) {
            res += string + ", ";
        }
        return res +  "Student is on " + courses.size() + " courses";
    }

    @GetMapping("getStudentsOn")
    public String getStudentsOn(@RequestParam String id){
        String res = "";

        if(sService.getStudentsOnCourse(id).size() < 1)
            return "Invalid course id";

        if(sService.getStudentsOnCourse(id) == null)
            return "No Students on that course";
        
        List<Student> tempStuds = sService.getStudentsOnCourse(id);
        for (Student stud : tempStuds) {
            res += stud.getName() + ", ";
        }

        return res + tempStuds.size() + " students on course " + id;
    }

    @DeleteMapping("dropAllData") //empties all 3 files, mainly for debugging purposes,definitely would add authentication or remove this if this was "going into prod"
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

    @PostMapping("enroll")
    public String enrollStudent(@RequestBody Map<String, String> json){
        //Spring needs to use Map to use requestbody elements as params effectively
        String studentId = json.get("studentId");
        String courseId = json.get("courseId");
        //Validates ids passed in body
        if(sService.getStudentById(studentId) == null)
            return "No such student p";
        if(cService.existsbyId(courseId) == 0)
            return "No such course";

        //Adds student to the course and performs a final check that the course exists and prevents funky errors
        if(cService.existsbyId(courseId) == 1 || cService.existsbyId(courseId) == 2){
            return sService.enrollStudent(studentId, courseId);
        }else{
            return "Error adding student to course, check you request body";
        }    
    }


}
