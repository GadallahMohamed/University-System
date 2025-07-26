package com.example.University.System.service.Impl;

import com.example.University.System.model.Course;
import com.example.University.System.model.Instructor;
import com.example.University.System.repo.CourseRepo;
import com.example.University.System.repo.InstructorRepo;
import com.example.University.System.service.CourseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private InstructorRepo instructorRepo;

    @Override
    public Course save(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course update(Course course) {
        if (!courseRepo.existsById(course.getId())){
            throw new EntityNotFoundException("course not found");
        }
        return courseRepo.save(course);
    }

    @Override
    public boolean delete(Integer id) {
        if (!courseRepo.existsById(id)){
            return false;
        }
        courseRepo.deleteById(id);
        return true;
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course assignInstructorToCourse(Integer courseId, Integer instructorId) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("course not found"));
        Instructor instructor = instructorRepo.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("instructor not found"));
        course.setInstructor(instructor);
        return courseRepo.save(course);
    }
}







