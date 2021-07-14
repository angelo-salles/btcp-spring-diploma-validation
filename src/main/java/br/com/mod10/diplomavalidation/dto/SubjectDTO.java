package br.com.mod10.diplomavalidation.dto;

public class SubjectDTO {
  private Long id;
  private String subject;
  private Integer note;

  public SubjectDTO() {
  }

  public SubjectDTO(Long id, String subject, Integer note) {
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
