package com.sanjaykanwar.courseapi.controllers;

import com.sanjaykanwar.courseapi.models.Course;
import com.sanjaykanwar.courseapi.services.CourseService;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/hello")
    public String sayHi(){
        return  "Hi";
    }

    @RequestMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllTopics();
    }

    @RequestMapping("/courses/{id}")
    public Course getCourseById(@PathVariable String id){
        return courseService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void createCourse(@RequestBody Course course){
        courseService.create(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id){
        courseService.update(course, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.delete(id);
    }
}
