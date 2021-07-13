package br.com.mod10.diplomavalidation.repository;

import br.com.mod10.diplomavalidation.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
  private static List<Student> students = new ArrayList<>();

  public List<Student> findAll() {
    return students;
  }

  public void save(Student student) {
    students.add(student);
  }
}
