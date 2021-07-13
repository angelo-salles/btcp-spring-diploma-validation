package br.com.mod10.diplomavalidation.dto;

public class SubjectDTO {
  private String subject;
  private Integer note;

  public SubjectDTO() {
  }

  public SubjectDTO(String subject, Integer note) {
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
