package com.example.University.System.controller;

import com.example.University.System.model.Course;
import com.example.University.System.model.Instructor;
import com.example.University.System.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @PostMapping("/save-instructor")
    Instructor addInstructor (@RequestBody Instructor instructor){
        return instructorService.save(instructor);
    }
    @PutMapping("/update-instructor")
    Instructor updateInstructor (@RequestBody Instructor instructor){
        return instructorService.update(instructor);
    }
    @DeleteMapping("/delete-instructor/{id}")
    boolean deleteInstructor(@PathVariable Integer id){
        return instructorService.delete(id);
    }
    @GetMapping("/get-instructors")
    List<Instructor> getAllInstructors(){
        return instructorService.getAll();
    }
    @GetMapping("/get-Courses-By-InstructorId/{instructorId}")
    List<Course> getCoursesByInstructorId(@PathVariable Integer instructorId){
        return instructorService.getCoursesByInstructorId(instructorId);
    }
}
