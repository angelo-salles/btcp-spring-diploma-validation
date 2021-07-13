package br.com.mod10.diplomavalidation.repository;

import br.com.mod10.diplomavalidation.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
  private List<Student> students = new ArrayList<>();

  public List<Student> findAll() {
    return this.students;
  }

  public void save(Student student) {
    this.students.add(student);
  }
}
