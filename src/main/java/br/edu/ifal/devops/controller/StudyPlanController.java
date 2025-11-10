package br.edu.ifal.devops.controller;

import br.edu.ifal.devops.model.StudyPlan;
import br.edu.ifal.devops.service.StudyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/studyplans")
public class StudyPlanController {
    
    @Autowired
    private final StudyPlanService studyPlanService;


    public StudyPlanController(StudyPlanService studyPlanService) {
        this.studyPlanService = studyPlanService;
    }

    @GetMapping
    public ResponseEntity<List<StudyPlan>> getAll(){
        List<StudyPlan> studyPlans = studyPlanService.getAll();
        return ResponseEntity.ok().body(studyPlans);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<StudyPlan>> getById(@PathVariable Long id){
        Optional<StudyPlan> studyPlan = studyPlanService.getById(id);
        return ResponseEntity.ok().body(studyPlan);
    }

    @PostMapping
    public ResponseEntity<StudyPlan> insert(@RequestBody StudyPlan studyPlan){
        studyPlan = studyPlanService.insert(studyPlan);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(studyPlan.getId()).toUri();
        return ResponseEntity.created(uri).body(studyPlan);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StudyPlan> update(@PathVariable Long id, @RequestBody StudyPlan studyPlan){
        studyPlan = studyPlanService.update(id, studyPlan);
        return ResponseEntity.ok().body(studyPlan);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studyPlanService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
