package com.example.University.System.controller;

import com.example.University.System.model.Course;
import com.example.University.System.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/save-course")
    Course addCourse (@RequestBody Course course){
        return courseService.save(course);
    }
    @PutMapping("/update-course")
    Course updateCourse (@RequestBody Course course){
        return courseService.update(course);
    }
    @DeleteMapping("/delete-course/{id}")
    boolean deleteCourse(@PathVariable Integer id){
        return courseService.delete(id);
    }
    @GetMapping("/get-courses")
    List<Course> getAllCourses(){
        return courseService.getAll();
    }
    @PostMapping("/assign-Instructor-To-Course/{courseId}/{instructorId}")
    Course assignInstructorToCourse (@PathVariable Integer courseId,@PathVariable Integer instructorId){
        return courseService.assignInstructorToCourse(courseId, instructorId);
    }
}
