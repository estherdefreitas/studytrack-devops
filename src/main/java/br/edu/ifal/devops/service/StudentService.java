package br.edu.ifal.devops.service;

import br.edu.ifal.devops.model.Student;
import br.edu.ifal.devops.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Optional<Student> getById(Long id){
        return studentRepository.findById(id);
    }

    public Student insert(Student student) {
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public Student update(Long id, Student student) {
        Student studentModel = studentRepository.getReferenceById(id);
        updateData(studentModel,student);
        return studentRepository.
    }

    private void updateData(Student studentModel, Student student) {
        studentModel.setName(student.getName());
        studentModel.setEmail(student.getEmail());
        studentModel.setRegistration(student.getRegistration());
    }
}
