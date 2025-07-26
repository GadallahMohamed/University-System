package com.example.University.System.service;

import com.example.University.System.model.Course;
import com.example.University.System.model.Instructor;
import com.example.University.System.model.Student;

import java.util.List;

public interface InstructorService {
    Instructor save (Instructor instructor);
    Instructor update (Instructor instructor);
    boolean delete(Integer id);
    List<Instructor> getAll();
    List<Course> getCoursesByInstructorId(Integer instructorId);

}
