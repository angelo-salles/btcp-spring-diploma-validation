package br.com.mod10.diplomavalidation.dto;

public class DegreeDTO {
  private String message;
  private Double average;
  private StudentDTO student;

  public DegreeDTO() {
  }

  public DegreeDTO(String message, Double average, StudentDTO student) {
    this.message = message;
    this.average = average;
    this.student = student;
  }

  public String getMessage() {
    return message;
  }

  public Double getAverage() {
    return average;
  }

  public StudentDTO getStudent() {
    return student;
  }
}
