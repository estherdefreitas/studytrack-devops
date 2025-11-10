package br.edu.ifal.devops.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_study_plan")
public class StudyPlan implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_study_plan")
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    @Column(name = "target_hours")
    private Integer targetHours;

    @Column(name = "deadline")
    private LocalDate deadline;
}
