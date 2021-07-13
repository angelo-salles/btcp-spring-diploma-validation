package br.com.mod10.diplomavalidation.controller;

import br.com.mod10.diplomavalidation.form.StudentForm;
import br.com.mod10.diplomavalidation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/aula1")
public class StudentController {

  private StudentService studentService;

  public StudentController() {
  }

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping("/analyzeNotes")
  public ResponseEntity<?> analyzeNotes(@RequestBody @Valid StudentForm studentForm) {
    return ResponseEntity.status(HttpStatus.CREATED).body(studentService.degree(studentForm));
  }
}
