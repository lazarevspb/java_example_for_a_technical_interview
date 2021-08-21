package ru.lazarev.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lazarev.dao.StudentRepository;
import ru.lazarev.domain.Student;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public void save(Student student) {
    studentRepository.save(student);
  }

  public void delete(Long id) {
    studentRepository.deleteById(id);
  }

  public Optional<Student> getById(Long id) {
    return studentRepository.findById(id);
  }

  public List<Student> findByTitleLike(String title) {
    return studentRepository.findByTitleLike(title);
  }
}
