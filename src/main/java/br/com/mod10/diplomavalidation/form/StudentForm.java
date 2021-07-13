package br.com.mod10.diplomavalidation.form;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentForm {
  @NotNull(message = "Name must not be null")
  @Size(min = 8, max = 50, message = "Name must have at least 8 character and 50 at maximum")
  @Pattern(regexp = "^[a-zA-Z]+$")
  private String name;

  @NotNull(message = "List of subject must not be null")
  @Valid
  private List<SubjectForm> subjects;

  public StudentForm() {
  }

  public StudentForm(String name, List<SubjectForm> subjects) {
    this.name = name;
    this.subjects = subjects;
  }

  public String getName() {
    return name;
  }

  public List<SubjectForm> getSubjects() {
    return subjects;
  }
}
