package br.com.mod10.diplomavalidation.exception.handler;

public class StudentNotExistsException extends RuntimeException{
  public StudentNotExistsException(String message) {
    super(message);
  }
}
