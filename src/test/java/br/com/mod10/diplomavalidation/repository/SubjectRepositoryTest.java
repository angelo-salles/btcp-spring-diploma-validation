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

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class SubjectRepositoryTest {

  @Autowired
  private SubjectRepository subjectRepository;

  @BeforeEach
  public void init() {
    this.subjectRepository.deleteAll();
  }

  @Test
  public void shouldReturnTheSubjectSavedInDB() {
    Subject subject = createSubject();

    Subject subjectResponse = this.subjectRepository.save(subject);

    Assertions.assertNotNull(subjectResponse);
    Assertions.assertEquals(subjectResponse, subject);
  }

  @Test
  public void shouldReturnAnSubject() {
    Subject subject = this.subjectRepository.save(createSubject());

    Optional<Subject> subjectOptional = this.subjectRepository.findById(subject.getId());

    Assertions.assertTrue(subjectOptional.isPresent());
  }

  @Test
  public void shouldNotReturnASubjectThatDoesNotExists() {
    Optional<Subject> subjectOptional = this.subjectRepository.findById(1l);

    Assertions.assertFalse(subjectOptional.isPresent());
  }

  @Test
  public void shouldReturnAnListOfSubjects() {
    this.subjectRepository.save(createSubject());

    Iterable<Subject> subjects = this.subjectRepository.findAll();

    Assertions.assertNotNull(subjects);
  }

  @Test
  public void shouldReturnNullForFindAllSubjects() {
    Iterable<Subject> subjectsIterable = this.subjectRepository.findAll();
    List<Subject> subjects = Streamable.of(subjectsIterable).toList();

    Assertions.assertEquals(subjects.size(), 0);
  }

  private Subject createSubject() {
    Subject subject = new Subject("Mock I", 8);
    return subject;
  }
}
