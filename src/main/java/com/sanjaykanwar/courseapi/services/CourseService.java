package com.sanjaykanwar.courseapi.services;

import com.sanjaykanwar.courseapi.models.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Service
public class CourseService {

    private List<Course> courses =new ArrayList<Course>(Arrays.asList(
            new Course("Java", "Spring", "Java Spring Boot Framework"),
            new Course("Javascript", "Express", "Javascript Express  Framework")
));

    public List<Course> getAllTopics(){
            return courses;
    }

    public Course getTopic(final String id){
        Predicate<Course> getTopicById = (item) -> item.getId().equals(id);
        return courses.stream().filter(getTopicById).findFirst().get();
    }

    public void create(Course course){
        courses.add(course);
    }


    public void update(Course newCourse, String id){
        Predicate<Course> getTopicById = (item) -> item.getId().equals(id);
        courses.set(courses.indexOf(courses.stream().filter(getTopicById).findFirst().get()), newCourse);
    }


    public void delete(String id){
        Predicate<Course> getTopicById = (item) -> item.getId().equals(id);
        courses.remove(courses.indexOf(courses.stream().filter(getTopicById).findFirst().get()));
    }

}
