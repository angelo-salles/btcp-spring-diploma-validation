package br.com.mod10.diplomavalidation;

import br.com.mod10.diplomavalidation.form.SubjectForm;
import br.com.mod10.diplomavalidation.utils.CalculateAverage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CertificateServiceImplTest {

  private List<SubjectForm> subjectsMock;

  @BeforeEach
  public void init() {
    SubjectForm s1 = new SubjectForm("Mock 1", 5);
    SubjectForm s2 = new SubjectForm("Mock 2", 8);
    SubjectForm s3 = new SubjectForm("Mock 3", 10);

    this.subjectsMock = new ArrayList<>(Arrays.asList(new SubjectForm[]{s1, s2, s3}));
  }

  @Test
  public void shouldReturnTheAverageOfNotes() {
    double expectedAverage = (double) 23 / 3;

    double responseAverage = CalculateAverage.calcAverage(this.subjectsMock);

    Assertions.assertEquals(expectedAverage, responseAverage);
  }
}
