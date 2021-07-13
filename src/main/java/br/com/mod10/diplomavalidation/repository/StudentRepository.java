package br.com.mod10.diplomavalidation.repository;

import br.com.mod10.diplomavalidation.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
  private static Student student;

  public Student findAll() {
    return student;
  }

  public void save(Student std) {
    student = std;
  }
}
