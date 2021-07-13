package br.com.mod10.diplomavalidation.entity;

public class Subject {
  private String subject;
  private Integer note;

  public Subject() {
  }

  public Subject(String subject, Integer note) {
    this.subject = subject;
    this.note = note;
  }

  public String getSubject() {
    return subject;
  }

  public Integer getNote() {
    return note;
  }
}
