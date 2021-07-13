package br.com.mod10.diplomavalidation;

import br.com.mod10.diplomavalidation.converter.StudentConverter;
import br.com.mod10.diplomavalidation.dto.DegreeDTO;
import br.com.mod10.diplomavalidation.form.StudentForm;
import br.com.mod10.diplomavalidation.form.SubjectForm;
import br.com.mod10.diplomavalidation.repository.StudentRepository;
import br.com.mod10.diplomavalidation.service.StudentService;
import br.com.mod10.diplomavalidation.utils.CalculateAverage;
import br.com.mod10.diplomavalidation.utils.StudentSituation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CertificateServiceImplTest {

  private StudentRepository studentRepository;
  private StudentService studentService;
  private List<SubjectForm> subjectsMock;
  private StudentForm studentMock;

  @BeforeEach
  public void init() {
    SubjectForm s1 = new SubjectForm("Mock 1", 5);
    SubjectForm s2 = new SubjectForm("Mock 2", 8);
    SubjectForm s3 = new SubjectForm("Mock 3", 10);

    this.subjectsMock = new ArrayList<>(Arrays.asList(new SubjectForm[]{s1, s2, s3}));
    this.studentMock = new StudentForm("Mock", this.subjectsMock);
    this.studentRepository = Mockito.mock(StudentRepository.class);
    this.studentService = new StudentService(this.studentRepository);
  }

  @Test
  public void shouldReturnTheAverageOfNotes() {
    double expectedAverage = (double) 23 / 3;

    double responseAverage = CalculateAverage.calcAverage(this.subjectsMock);

    Assertions.assertEquals(expectedAverage, responseAverage);
  }

  @Test
  public void shouldReturnApprovedWithCongratulations() {
    String message = StudentSituation.status(9.7);

    Assertions.assertTrue(message.contains("Parabéns"));
  }

  @Test
  public void shouldReturnApproved() {
    String message = StudentSituation.status(6.8);

    Assertions.assertTrue(message.contains("aprovado"));
  }

  @Test
  public void shouldReturnRecovery() {
    String message = StudentSituation.status(4.7);

    Assertions.assertTrue(message.contains("recuperação"));
  }

  @Test
  public void shouldReturnReproved() {
    String message = StudentSituation.status(2.0);

    Assertions.assertTrue(message.contains("reprovado"));
  }

  @Test
  public void shoulReturnAnApprovedObject() {
    String message = "Você foi aprovado! Sua média foi de: 7,7";
    double average = 7.7;

    DegreeDTO responseDegree = studentService.degree(this.studentMock);

    Assertions.assertTrue(message.equalsIgnoreCase(responseDegree.getMessage()));
    Assertions.assertTrue(average == responseDegree.getAverage());
    Assertions.assertTrue(this.studentMock.getName().equalsIgnoreCase(responseDegree.getStudent().getName()));
    Assertions.assertTrue(this.subjectsMock.get(0).getSubject().equalsIgnoreCase(responseDegree.getStudent().getSubjects().get(0).getSubject()));
    Assertions.assertTrue(this.subjectsMock.get(0).getNote() == responseDegree.getStudent().getSubjects().get(0).getNote());
  }

  @Test
  public void shouldCallFindAllMethodFromRepository() {
    this.studentService.findAll();
    Mockito.verify(this.studentRepository).findAll();
  }
}
