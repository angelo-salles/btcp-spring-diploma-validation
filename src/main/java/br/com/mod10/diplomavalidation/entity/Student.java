package br.com.mod10.diplomavalidation.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Student")
public class Student {

  @Id
  private String id;

  private String name;

  private List<Subject> subjects = new ArrayList<>();

  public Student() {
  }

  public Student(String name, List<Subject> subjects) {
    this.name = name;
    this.subjects = subjects;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Subject> getSubjects() {
    return subjects;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSubjects(List<Subject> subjects) {
    this.subjects = subjects;
  }

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", subjects=" + subjects +
            '}';
  }
}
