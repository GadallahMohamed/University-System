package com.example.University.System.service.Impl;

import com.example.University.System.model.Course;
import com.example.University.System.model.Student;
import com.example.University.System.repo.CourseRepo;
import com.example.University.System.repo.StudentRepo;
import com.example.University.System.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private CourseRepo courseRepo;


    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student update(Student student) {
        if (!studentRepo.existsById(student.getId())){
            throw new EntityNotFoundException("student not found");
        }
        return studentRepo.save(student);
    }

    @Override
    public boolean delete(Integer id) {
        if (!studentRepo.existsById(id)){
            return false;
        }
        studentRepo.deleteById(id);
        return true;
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student getById(Integer id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("student not found"));
    }

    @Override
    public Student registerStudentToCourse(Integer studentId, Integer courseId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        student.getCourses().add(course);
        return studentRepo.save(student);

    }
}

