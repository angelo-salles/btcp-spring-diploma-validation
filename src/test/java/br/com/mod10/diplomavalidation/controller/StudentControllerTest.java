package br.com.mod10.diplomavalidation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.mod10.diplomavalidation.converter.StudentConverter;
import br.com.mod10.diplomavalidation.entity.Student;
import br.com.mod10.diplomavalidation.exception.handler.StudentNotExistsException;
import br.com.mod10.diplomavalidation.form.StudentForm;
import br.com.mod10.diplomavalidation.form.SubjectForm;
import br.com.mod10.diplomavalidation.repository.StudentRepository;
import br.com.mod10.diplomavalidation.service.StudentService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("teste")
@AutoConfigureMockMvc
public class StudentControllerTest {

  @Autowired
  private MockMvc mock;

  @Autowired
  private ObjectMapper objectMapper = new ObjectMapper();

  @Autowired
  private StudentService studentService;

  @Autowired
  private StudentRepository studentRepository;

  @BeforeEach
  public void init() {
    this.studentRepository.deleteAll();
  }

  @Test
  public void shouldReturnAnInstanceOfStudentController() {
    StudentController studentController = new StudentController();

    Assertions.assertNotNull(studentController);
  }

  @Test
  public void shouldSaveAnStudent() throws Exception {
    String payload = objectMapper.writeValueAsString(createStudentForm());

    mock.perform(post("/api/aula1")
        .contentType("application/json")
        .content(payload))
    .andExpect(status().isCreated());
  }

  @Test
  public void shouldReturnAListOfAllStudents() throws Exception{
    this.studentRepository.save(createStudent());

    mock.perform(get("/api/aula1/students"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$").isNotEmpty())
        .andExpect(jsonPath("$[0].name").value("Mock Form"));
  }

  @Test
  public void shouldReturnASpecifStudent() throws Exception {
    Student student = this.studentRepository.save(createStudent());

    mock.perform(get("/api/aula1/student/{id}", student.getId()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$").isNotEmpty())
        .andExpect(jsonPath("$.name").value("Mock Form"))
        .andExpect(jsonPath("$.subjects").exists())
        .andExpect(jsonPath("$.subjects").isNotEmpty())
        .andExpect(jsonPath("$.subjects[0].subject").value(student.getSubjects().get(0).getSubject()));
  }

  @Test
  public void shouldReturnStudentNotExistsExceptionForGetStudentById() throws Exception {
    mock.perform(get("/api/aula1/student/{id}", 10l))
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$").isNotEmpty())
            .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof StudentNotExistsException))
            .andExpect(result -> Assertions.assertTrue(result.getResolvedException().getMessage().contains("não cadastrado")));
  }

  @Test
  public void shouldReturnADegreeOfAStudent() throws Exception {
    Student student = this.studentRepository.save(createStudent());

    mock.perform(post("/api/aula1/analyzeNotes/{id}", student.getId()))
         .andExpect(status().isOk())
         .andExpect(content().contentType(MediaType.APPLICATION_JSON))
         .andExpect(jsonPath("$").isNotEmpty())
         .andExpect(jsonPath("$.message").isString())
         .andExpect(jsonPath("$.message").isNotEmpty())
         .andExpect(jsonPath("$.average").isNumber())
         .andExpect(jsonPath("$.student").exists())
         .andExpect(jsonPath("$.student.name").value(student.getName()));
  }

  @Test
  public void shouldReturnStudentNotExistsExceptionWhenStudentNotExists() throws Exception {
    mock.perform(post("/api/aula1/analyzeNotes/{id}", 10l))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof StudentNotExistsException))
        .andExpect(result -> Assertions.assertTrue(result.getResolvedException().getMessage().contains("não cadastrado")));
  }

  private StudentForm createStudentForm() {
    return new StudentForm("Mock Form", createSubjectFormList());
  }

  private Student createStudent() {
    return StudentConverter.studentFormToEntity(createStudentForm());
  }

  private List<SubjectForm> createSubjectFormList() {
    SubjectForm subjectForm1 = new SubjectForm("Subject I", 8);
    SubjectForm subjectForm2 = new SubjectForm("Subject II", 9);

    return new ArrayList<>(Arrays.asList(subjectForm1, subjectForm2));
  }

}
