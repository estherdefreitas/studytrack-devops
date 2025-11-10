package br.edu.ifal.devops.service;

import br.edu.ifal.devops.model.StudyPlan;
import br.edu.ifal.devops.repository.StudyPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudyPlanService {
    
    @Autowired
    private StudyPlanRepository studyPlanRepository;

    public List<StudyPlan> getAll(){
        return studyPlanRepository.findAll();
    }

    public Optional<StudyPlan> getById(Long id){
        return studyPlanRepository.findById(id);
    }

    public StudyPlan insert(StudyPlan studyPlan) {
        return studyPlanRepository.save(studyPlan);
    }

    public void delete(Long id) {
        studyPlanRepository.deleteById(id);
    }

    public StudyPlan update(Long id, StudyPlan studyPlan) {
        StudyPlan studyPlanModel = studyPlanRepository.getReferenceById(id);
        updateData(studyPlanModel,studyPlan);
        return studyPlanRepository.save(studyPlanModel);
    }

    private void updateData(StudyPlan studyPlanModel, StudyPlan studyPlan) {
        studyPlanModel.setStudent(studyPlan.getStudent());
        studyPlanModel.setCourse(studyPlan.getCourse());
        studyPlanModel.setTargetHours(studyPlan.getTargetHours());
        studyPlanModel.setDeadline(studyPlan.getDeadline());
    }

}
