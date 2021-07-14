package br.com.mod10.diplomavalidation;

import br.com.mod10.diplomavalidation.converter.StudentConverter;
import br.com.mod10.diplomavalidation.dto.DegreeDTO;
import br.com.mod10.diplomavalidation.dto.StudentDTO;
import br.com.mod10.diplomavalidation.dto.SubjectDTO;
import br.com.mod10.diplomavalidation.entity.Student;
import br.com.mod10.diplomavalidation.entity.Subject;
import br.com.mod10.diplomavalidation.exception.handler.StudentNotExistsException;
import br.com.mod10.diplomavalidation.form.StudentForm;
import br.com.mod10.diplomavalidation.form.SubjectForm;
import br.com.mod10.diplomavalidation.repository.StudentRepository;
import br.com.mod10.diplomavalidation.service.StudentService;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CertificateServiceImplTest {

  private StudentRepository studentRepository;
  private StudentService studentService;
  private List<SubjectDTO> subjectsMock;
  private StudentDTO studentMock;

  @BeforeEach
  public void init() {
    SubjectDTO s1 = new SubjectDTO(1l,"Mock I", 8);

    this.subjectsMock = new ArrayList<>(Arrays.asList(new SubjectDTO[]{s1}));
    this.studentMock = new StudentDTO(1l, "Mock", this.subjectsMock);
    this.studentRepository = Mockito.mock(StudentRepository.class);
    this.studentService = new StudentService(this.studentRepository);
  }

  @Test
  public void shoulReturnAnApprovedObject() {
    long id = 1l;

    Subject subject = new Subject("Mock I", 8);
    List<Subject> subjects = new ArrayList<>(Arrays.asList(new Subject[]{subject}));
    Optional<Student> student = Optional.of(new Student("Mock", subjects));
    Mockito.when(this.studentRepository.findById(id)).thenReturn(student);

    DegreeDTO expected = new DegreeDTO(
            "Você foi aprovado! Sua média foi de: 8,0",
            8.0,
            this.studentMock
    );

    DegreeDTO responseDegree = this.studentService.degree(id);

    assertThat(responseDegree).usingRecursiveComparison().isEqualTo(expected);
  }

  @Test
  public void shouldCallFindAllMethodFromRepository() {
    this.studentService.findAll();
    Mockito.verify(this.studentRepository).findAll();
  }

  @Test
  public void shouldCallFindByIdMethodFromRepository() {
    long id = 1l;
    Subject subject = new Subject("Mock I", 8);
    List<Subject> subjects = new ArrayList<>(Arrays.asList(new Subject[]{subject}));
    Optional<Student> student = Optional.of(new Student("Mock", subjects));
    Mockito.when(this.studentRepository.findById(id)).thenReturn(student);
    this.studentService.findById(id);
    Mockito.verify(this.studentRepository).findById(id);
  }

  @Test
  public void shouldReturnStudentNotExistsException() {
    long id = 1l;

    StudentNotExistsException exception = Assertions.assertThrows(
            StudentNotExistsException.class,
            () -> this.studentService.findById(id)
    );

    Assertions.assertTrue(exception.getMessage().contains("não cadastrado"));
  }

  @Test
  public void shouldCallSaveMethodFromRepository() {
    Subject subject = new Subject("Mock I", 8);
    List<Subject> subjects = new ArrayList<>(Arrays.asList(new Subject[]{subject}));
    Student student = new Student("Mock", subjects);

    Mockito.when(this.studentRepository.save(student)).thenReturn(student);

    this.studentService.save(student);
    Mockito.verify(this.studentRepository).save(student);
  }
}
