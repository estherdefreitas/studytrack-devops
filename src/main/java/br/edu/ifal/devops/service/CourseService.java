package br.edu.ifal.devops.service;

import br.edu.ifal.devops.model.Course;
import br.edu.ifal.devops.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Optional<Course> getById(Long id){
        return courseRepository.findById(id);
    }

    public Course insert(Course course) {
        return courseRepository.save(course);
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    public Course update(Long id, Course course) {
        Course courseModel = courseRepository.getReferenceById(id);
        updateData(courseModel,course);
        return courseRepository.save(courseModel);
    }

    private void updateData(Course courseModel, Course course) {
        courseModel.setName(course.getName());
        courseModel.setCode(course.getCode());
        courseModel.setSemester(course.getSemester());
        courseModel.setProfessorName(course.getProfessorName());
    }
}
