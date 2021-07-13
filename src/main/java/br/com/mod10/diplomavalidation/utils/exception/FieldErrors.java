package br.com.mod10.diplomavalidation.utils.exception;

import br.com.mod10.diplomavalidation.dto.ExceptionFieldDTO;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldErrors {
  public static ExceptionFieldDTO processFieldErrors(List<FieldError> fieldErrors) {
    Map<String, String> exceptions = new HashMap<>();
    for (FieldError fieldError: fieldErrors) {
      exceptions.put(fieldError.getField(), fieldError.getDefaultMessage());
    }
    return new ExceptionFieldDTO(exceptions);
  }
}
