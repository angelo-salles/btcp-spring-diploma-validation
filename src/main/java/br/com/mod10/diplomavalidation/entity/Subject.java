package br.com.mod10.diplomavalidation.entity;

import org.springframework.data.annotation.Id;

public class Subject {
  @Id
  private String id;

  private String subject;

  private Integer note;

  public Subject() {
  }

  public Subject(String subject, Integer note) {
    this.subject = subject;
    this.note = note;
  }

  public String getId() {
    return id;
  }

  public String getSubject() {
    return subject;
  }

  public Integer getNote() {
    return note;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void setNote(Integer note) {
    this.note = note;
  }
}
