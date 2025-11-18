-- Table: tb_course
CREATE TABLE tb_course (
                           id_course BIGSERIAL PRIMARY KEY,
                           code VARCHAR(255) UNIQUE,
                           name VARCHAR(255),
                           professor_name VARCHAR(255),
                           semester VARCHAR(255)
);

-- Table: tb_student
CREATE TABLE tb_student (
                            id_student BIGSERIAL PRIMARY KEY,
                            name VARCHAR(255),
                            email VARCHAR(255) UNIQUE,
                            registration VARCHAR(255)
);

-- Table: tb_study_plan
CREATE TABLE tb_study_plan (
                               id_study_plan BIGSERIAL PRIMARY KEY,
                               student_id_student BIGINT,
                               course_id_course BIGINT,
                               target_hours INTEGER,
                               deadline DATE,
                               CONSTRAINT fk_study_plan_student FOREIGN KEY (student_id_student) REFERENCES tb_student(id_student),
                               CONSTRAINT fk_study_plan_course FOREIGN KEY (course_id_course) REFERENCES tb_course(id_course)
);

-- Table: tb_study_task
CREATE TABLE tb_study_task (
                               id_study_task BIGSERIAL PRIMARY KEY,
                               study_plan_id_study_plan BIGINT,
                               title VARCHAR(255),
                               status VARCHAR(255) CHECK (status IN ('TODO','DOING','DONE')),
                               done_at TIMESTAMP,
                               CONSTRAINT fk_study_task_study_plan FOREIGN KEY (study_plan_id_study_plan) REFERENCES tb_study_plan(id_study_plan)
);