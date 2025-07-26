package com.example.University.System.service;

import com.example.University.System.model.Course;
import com.example.University.System.model.Student;

import java.util.List;

public interface CourseService {
    Course save (Course course);
    Course update (Course course);
    boolean delete(Integer id);
    List<Course> getAll();
    Course assignInstructorToCourse (Integer courseId, Integer instructorId);

}
