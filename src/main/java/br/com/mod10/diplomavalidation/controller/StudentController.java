package br.com.mod10.diplomavalidation.controller;

import br.com.mod10.diplomavalidation.dto.StudentDTO;
import br.com.mod10.diplomavalidation.form.StudentForm;
import br.com.mod10.diplomavalidation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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

  @PostMapping("/analyzeNotes/{id}")
  public ResponseEntity<?> analyzeNotes(@PathVariable long id) {
    return ResponseEntity.status(HttpStatus.CREATED).body(studentService.degree(id));
  }

  @PostMapping
  public ResponseEntity<?> saveStudent(@RequestBody @Valid StudentForm studentForm, UriComponentsBuilder uriComponentsBuilder) {
    StudentDTO student = this.studentService.save(studentForm);
    URI uri = uriComponentsBuilder.path("/api/aula1/student/{id}").buildAndExpand(student.getId()).toUri();
    return ResponseEntity.created(uri).body(student);
  }

  @GetMapping("/students")
  public ResponseEntity<?> getAllStudents() {
    return ResponseEntity.ok().body(this.studentService.findAll());
  }

  @GetMapping("/student/{id}")
  public ResponseEntity<?> getStudentById(@PathVariable long id) {
    return ResponseEntity.ok(this.studentService.findById(id));
  }
}
