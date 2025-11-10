package br.edu.ifal.devops.repository;

import br.edu.ifal.devops.model.StudyPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyPlanRepository extends JpaRepository<StudyPlan, Long> {
}
