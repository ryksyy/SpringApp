package com.ryk.test.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    

}
