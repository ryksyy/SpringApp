package com.ryk.test.Controller;


import org.springframework.beans.factory.annotation.Autowired;
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
