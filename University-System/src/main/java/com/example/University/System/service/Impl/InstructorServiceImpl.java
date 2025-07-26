package com.example.University.System.service.Impl;

import com.example.University.System.model.Course;
import com.example.University.System.model.Instructor;
import com.example.University.System.repo.InstructorRepo;
import com.example.University.System.service.InstructorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepo instructorRepo;

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public Instructor update(Instructor instructor) {
        if (!instructorRepo.existsById(instructor.getId())){
            throw new EntityNotFoundException("Instructor not found");
        }
        return instructorRepo.save(instructor);
    }

    @Override
    public boolean delete(Integer id) {
        if (!instructorRepo.existsById(id)){
            return false;
        }
        instructorRepo.deleteById(id);
        return true;
    }

    @Override
    public List<Instructor> getAll() {
        return instructorRepo.findAll();
    }

    @Override
    public List<Course> getCoursesByInstructorId(Integer instructorId) {
        Instructor instructor = instructorRepo.findById(instructorId)
                .orElseThrow(()-> new EntityNotFoundException("Instructor not found"));
        return instructor.getCourses();
    }
}
