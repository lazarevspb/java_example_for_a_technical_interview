package ru.lazarev.lesson5.dao;

import java.util.List;
import java.util.UUID;
import ru.lazarev.lesson5.entity.Student;

public interface StudentDAO {

  void update(Student student);

  void save(Student student);

  void add(Student student);

  void delete(Student student);

  Student getStudent(UUID uuid);

  List<Student> getStudents();

  void close();
}
