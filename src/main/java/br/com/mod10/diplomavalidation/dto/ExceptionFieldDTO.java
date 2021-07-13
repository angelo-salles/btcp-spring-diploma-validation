package br.com.mod10.diplomavalidation.dto;

import java.util.Map;

public class ExceptionFieldDTO {
  private Map<String, String> errors;

  public ExceptionFieldDTO(Map<String, String> errors) {
    this.errors = errors;
  }

  public Map<String, String> getErrors() {
    return errors;
  }
}
