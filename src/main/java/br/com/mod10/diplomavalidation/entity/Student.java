package br.com.mod10.diplomavalidation.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {
  private String name;
  private List<Subject> subjects = new ArrayList<>();

  public Student() {
  }

  public Student(String name, List<Subject> subjects) {
    this.name = name;
    this.subjects = subjects;
  }

  public String getName() {
    return name;
  }

  public List<Subject> getSubjects() {
    return subjects;
  }
}
