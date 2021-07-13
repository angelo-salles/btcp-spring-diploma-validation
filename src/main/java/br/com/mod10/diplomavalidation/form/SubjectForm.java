package br.com.mod10.diplomavalidation.form;

import javax.validation.constraints.*;

public class SubjectForm {
  @NotNull(message = "Subject must not be null")
  @Size(min = 8, max = 50, message = "Subject must have at least 8 character and 50 at maximum")
  @Pattern(regexp = "^([a-zA-Z]+\\s)*[a-zA-Z]+$", message = "Subject name must have only characters")
  private String subject;

  @NotNull(message = "Note must not be null")
  @Digits(fraction = 0, message = "Note must be integer", integer = 2)
  @Min(value = 0, message = "Minumum note is 0")
  @Max(value = 10, message = "Max note is 10")
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
