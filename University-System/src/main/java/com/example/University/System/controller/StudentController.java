package com.example.University.System.controller;

import com.example.University.System.model.Student;
import com.example.University.System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save-student")
    Student addStudent (@RequestBody Student student){
        return studentService.save(student);
    }
    @PutMapping("/update-student")
    Student updateStudent (@RequestBody Student student){
        return studentService.update(student);
    }
    @DeleteMapping("/delete-student/{id}")
    boolean deleteStudent(@PathVariable Integer id){
        return studentService.delete(id);
    }
    @GetMapping("/get-students")
    List<Student> getAllStudent(){
        return studentService.getAll();
    }
    @GetMapping("/get-student/{id}")
    Student getStudentById(@PathVariable Integer id){
        return studentService.getById(id);
    }
    @PostMapping("/register-Student-To-Course/{studentId}/{courseId}")
    Student registerStudentToCourse(@PathVariable Integer studentId,@PathVariable Integer courseId){
        return studentService.registerStudentToCourse(studentId, courseId);
    }
}
