package br.edu.ifal.devops.controller;

import br.edu.ifal.devops.model.StudyTask;
import br.edu.ifal.devops.service.StudyTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/study-tasks")
public class StudyTaskController {
    @Autowired
    private final StudyTaskService studyTaskService;


    public StudyTaskController(StudyTaskService studyTaskService) {
        this.studyTaskService = studyTaskService;
    }

    @GetMapping
    public ResponseEntity<List<StudyTask>> getAll(){
        List<StudyTask> studyTasks = studyTaskService.getAll();
        return ResponseEntity.ok().body(studyTasks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<StudyTask>> getById(@PathVariable Long id){
        Optional<StudyTask> studyTask = studyTaskService.getById(id);
        return ResponseEntity.ok().body(studyTask);
    }

    @PostMapping
    public ResponseEntity<StudyTask> insert(@RequestBody StudyTask studyTask){
        studyTask = studyTaskService.insert(studyTask);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(studyTask.getId()).toUri();
        return ResponseEntity.created(uri).body(studyTask);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StudyTask> update(@PathVariable Long id, @RequestBody StudyTask studyTask){
        studyTask = studyTaskService.update(id, studyTask);
        return ResponseEntity.ok().body(studyTask);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studyTaskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
