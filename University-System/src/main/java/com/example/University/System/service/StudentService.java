package com.example.University.System.service;

import com.example.University.System.model.Student;

import java.util.List;

public interface StudentService {
    Student save (Student student);
    Student update (Student student);
    boolean delete(Integer id);
    List<Student> getAll();
    Student getById(Integer id);
    Student registerStudentToCourse(Integer studentId, Integer courseId);
}
