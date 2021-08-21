package ru.lazarev.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.lazarev.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  List<Student> findByTitleLike(String title);

  @NonNull
  Optional<Student> findById(@NonNull Long id);

}
