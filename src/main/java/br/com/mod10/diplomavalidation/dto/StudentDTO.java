package br.com.mod10.diplomavalidation.dto;

import java.util.List;

public class StudentDTO {
  private String name;
  private List<SubjectDTO> subjects;


  public StudentDTO() {
  }

  public StudentDTO(String name, List<SubjectDTO> subjects) {
    this.name = name;
    this.subjects = subjects;
  }

  public String getName() {
    return name;
  }

  public List<SubjectDTO> getSubjects() {
    return subjects;
  }
}
