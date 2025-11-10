package br.edu.ifal.devops.controller;

import br.edu.ifal.devops.model.Student;
import br.edu.ifal.devops.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        List<Student> students = studentService.getAll();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Student>> getById(@PathVariable Long id){
        Optional<Student> student = studentService.getById(id);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody Student student){
        student = studentService.insert(student);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).body(student);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student){
        student = studentService.update(id, student);
        return ResponseEntity.ok().body(student);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
