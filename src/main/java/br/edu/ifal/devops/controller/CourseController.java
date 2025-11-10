package br.edu.ifal.devops.controller;

import br.edu.ifal.devops.model.Course;
import br.edu.ifal.devops.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {
    
    @Autowired
    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAll(){
        List<Course> courses = courseService.getAll();
        return ResponseEntity.ok().body(courses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Course>> getById(@PathVariable Long id){
        Optional<Course> course = courseService.getById(id);
        return ResponseEntity.ok().body(course);
    }

    @PostMapping
    public ResponseEntity<Course> insert(@RequestBody Course course){
        course = courseService.insert(course);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).body(course);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course course){
        course = courseService.update(id, course);
        return ResponseEntity.ok().body(course);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
