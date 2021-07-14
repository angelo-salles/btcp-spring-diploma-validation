package br.com.mod10.diplomavalidation.dto;

import java.util.List;

public class StudentDTO {
  private Long id;
  private String name;
  private List<SubjectDTO> subjects;


  public StudentDTO() {
  }

  public StudentDTO(Long id, String name, List<SubjectDTO> subjects) {
    this.name = name;
    this.subjects = subjects;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<SubjectDTO> getSubjects() {
    return subjects;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSubjects(List<SubjectDTO> subjects) {
    this.subjects = subjects;
  }
}
