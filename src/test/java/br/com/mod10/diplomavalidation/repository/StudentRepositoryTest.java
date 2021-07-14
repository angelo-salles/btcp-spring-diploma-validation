package br.com.mod10.diplomavalidation.repository;

import br.com.mod10.diplomavalidation.entity.Student;
import br.com.mod10.diplomavalidation.entity.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.util.Streamable;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class StudentRepositoryTest {

  @Autowired
  private StudentRepository studentRepository;

  @BeforeEach
  public void init() {
    this.studentRepository.deleteAll();
  }

  @Test
  public void shouldReturnTheStudentSavedInDB() {
    Student student = createStudent();
    Student studentResponse = this.studentRepository.save(student);

    Assertions.assertNotNull(studentResponse);
    Assertions.assertEquals(studentResponse, student);
  }

  @Test
  public void shouldReturnAnStudent() {
    Student student = this.studentRepository.save(createStudent());

    Optional<Student> studentResponse = this.studentRepository.findById(student.getId());

    Assertions.assertTrue(studentResponse.isPresent());
  }

  @Test
  public void shouldNotReturnAStudentThatDoesNotExists() {
    Optional<Student> studentResponse = this.studentRepository.findById(1l);

    Assertions.assertFalse(studentResponse.isPresent());
  }

  @Test
  public void shouldReturnAnListOfStudents() {
    this.studentRepository.save(createStudent());

    Iterable<Student> students = this.studentRepository.findAll();

    Assertions.assertNotNull(students);
  }

  @Test
  public void shouldReturnNullForFindAllStudents() {
    Iterable<Student> studentsIterable = this.studentRepository.findAll();
    List<Student> students = Streamable.of(studentsIterable).toList();

    Assertions.assertEquals(students.size(), 0);
  }

  private Student createStudent() {
    Subject s1 = new Subject("Mock I", 8);
    Subject s2 = new Subject("Mock II", 7);
    Subject s3 = new Subject("Mock III", 9);
    Student student = new Student("Estudante", new ArrayList<>(Arrays.asList(s1, s2, s3)));

    return student;
  }
}
