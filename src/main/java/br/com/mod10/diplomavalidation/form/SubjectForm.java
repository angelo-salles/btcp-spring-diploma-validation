package br.com.mod10.diplomavalidation.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class SubjectForm {
  @NotNull(message = "Subject must not be null")
  @Size(min = 8, max = 50, message = "Subject must have at least 8 character and 50 at maximum")
  @Pattern(regexp = "^[a-zA-Z]+$")
  private String subject;

  @NotNull(message = "Note must not be null")
  @Size(min = 1, max = 2, message = "Note must have at least 1 digit and 2 at maximum")
  @Pattern(regexp = "[1-9]|10")
  private Integer note;

  public SubjectForm() {
  }

  public SubjectForm(String subject, Integer note) {
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
