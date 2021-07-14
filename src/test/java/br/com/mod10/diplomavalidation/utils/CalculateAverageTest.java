package br.com.mod10.diplomavalidation.utils;

import br.com.mod10.diplomavalidation.dto.StudentDTO;
import br.com.mod10.diplomavalidation.dto.SubjectDTO;
import br.com.mod10.diplomavalidation.repository.StudentRepository;
import br.com.mod10.diplomavalidation.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CalculateAverageTest {
  private List<SubjectDTO> subjectsMock;

  @BeforeEach
  public void init() {
    SubjectDTO s1 = new SubjectDTO(1l,"Mock 1", 5);
    SubjectDTO s2 = new SubjectDTO(2l,"Mock 2", 8);
    SubjectDTO s3 = new SubjectDTO(3l,"Mock 3", 10);

    this.subjectsMock = new ArrayList<>(Arrays.asList(new SubjectDTO[]{s1, s2, s3}));
  }

  @Test
  public void shouldReturnTheAverageOfNotes() {
    double expectedAverage = (double) 23 / 3;

    double responseAverage = CalculateAverage.calcAverage(this.subjectsMock);

    Assertions.assertEquals(expectedAverage, responseAverage);
  }
}
