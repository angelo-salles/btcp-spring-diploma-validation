package br.com.mod10.diplomavalidation.entity;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String subject;
  private Integer note;

  public Subject() {
  }

  public Subject(String subject, Integer note) {
    this.subject = subject;
    this.note = note;
  }

  public Long getId() {
    return id;
  }

  public String getSubject() {
    return subject;
  }

  public Integer getNote() {
    return note;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void setNote(Integer note) {
    this.note = note;
  }
}
