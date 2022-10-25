package com.ryk.test.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryk.test.Services.CourseService;
import com.ryk.test.data.OnlineCourse;
import com.ryk.test.data.ClassCourse;

@RestController
public class CourseController {

    @Autowired
    CourseService cService;

    @GetMapping("getOnlineCourses")
    public List<OnlineCourse> getOnlineCourses(){
        return cService.getOnline();
    }

    @GetMapping("getClassRoomCourses")
    public List<ClassCourse> getClassRoom(){
        return cService.getClasses();
    }

    @PostMapping("addOnlineCourse")
    public OnlineCourse addOnlineCourse(@RequestBody OnlineCourse onlineCourse){
        cService.addOnlineCourse(onlineCourse);
        return onlineCourse;
    }

    @PostMapping("addClassCourse")
    public ClassCourse addClassCourse(@RequestBody ClassCourse classCourse){
        cService.addClassCourse(classCourse);
        return classCourse;
    }

    @GetMapping("searchCourseById")
    public String searchCourseId(@RequestParam String id){

        //Checks if such course exists at all and figures out if the course is a class or online course
        //returns course info as text for readability
        switch(cService.existsbyId(id)){
            case 0:
            return "No such course exists";
            case 1:
            ClassCourse classCourse = cService.searchClassById(id);
            return "Classroom course found " + ",\r\nCourse name: " + classCourse.getCourseName() + ",\r\nTeacher: " + classCourse.getTeacher() + ",\r\nRoom: " + classCourse.getClassRoom() + 
            ",\r\nWeekday: " + classCourse.getWeekDay() + ",\r\nStart time: " + classCourse.getStartTime() + ",\r\nLenght: " + classCourse.getClassLenght() + "h,\r\nID: " + classCourse.getCourseId()
            + "\r\nCredits: " + classCourse.getCourseCred();
            case 2:
            OnlineCourse oCourse = cService.searchOnlineById(id);
            return "Online course found" + ",\r\nCourse name: " + oCourse.getCourseName() + ",\r\nTeacher: " + oCourse.getTeacher() + ",\r\nZoom link: " + oCourse.getZoomLink() +
            ",\r\nRecordings Link: " + oCourse.getRecordingLink() + ",\r\nID: " + oCourse.getCourseId() + ",\r\nCredits: " + oCourse.getCourseCred();
            default:
            return "No such course exists";
        }
    }
    

}
