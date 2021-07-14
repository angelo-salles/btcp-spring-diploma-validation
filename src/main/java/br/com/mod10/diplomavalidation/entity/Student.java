package br.com.mod10.diplomavalidation.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @JoinColumn(name = "student_id")
  private List<Subject> subjects = new ArrayList<>();

  public Student() {
  }

  public Student(String name, List<Subject> subjects) {
    this.name = name;
    this.subjects = subjects;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Subject> getSubjects() {
    return subjects;
  }

  public void setId(Long id) {
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
