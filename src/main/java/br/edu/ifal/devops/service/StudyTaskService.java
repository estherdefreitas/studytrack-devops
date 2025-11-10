package br.edu.ifal.devops.service;

import br.edu.ifal.devops.model.StudyTask;
import br.edu.ifal.devops.repository.StudyTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudyTaskService {
    
    @Autowired
    private StudyTaskRepository studyTaskRepository;

    public List<StudyTask> getAll(){
        return studyTaskRepository.findAll();
    }

    public Optional<StudyTask> getById(Long id){
        return studyTaskRepository.findById(id);
    }

    public StudyTask insert(StudyTask studyTask) {
        return studyTaskRepository.save(studyTask);
    }

    public void delete(Long id) {
        studyTaskRepository.deleteById(id);
    }

    public StudyTask update(Long id, StudyTask studyTask) {
        StudyTask studyTaskModel = studyTaskRepository.getReferenceById(id);
        updateData(studyTaskModel,studyTask);
        return studyTaskRepository.save(studyTaskModel);
    }

    private void updateData(StudyTask studyTaskModel, StudyTask studyTask) {
        studyTaskModel.setStudyPlan(studyTask.getStudyPlan());
        studyTaskModel.setTitle(studyTask.getTitle());
        studyTaskModel.setStatus(studyTask.getStatus());
        studyTaskModel.setDoneAt(studyTask.getDoneAt());
    }
}
