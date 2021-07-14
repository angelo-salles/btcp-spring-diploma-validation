package br.com.mod10.diplomavalidation.converter;

import br.com.mod10.diplomavalidation.dto.SubjectDTO;
import br.com.mod10.diplomavalidation.entity.Subject;
import br.com.mod10.diplomavalidation.form.SubjectForm;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class SubjectConverterTest {

  @Test
  public void shouldReturnAnInstanceOfSubjectEntity() {
    Subject subject = SubjectConverter.subjectFormToEntity(new SubjectForm("Materia I", 8));

    Subject expectedSubject = new Subject("Materia I", 8);

    Assertions.assertNotNull(subject);
    assertThat(subject).usingRecursiveComparison().isEqualTo(expectedSubject);
  }

  @Test
  public void shouldReturnAListOfSubjectEntities() {
    SubjectForm s1 = new SubjectForm("Materia I", 8);
    SubjectForm s2 = new SubjectForm("Materia II", 9);
    List<SubjectForm> subjectForms = new ArrayList<>(Arrays.asList(s1, s2));

    Subject sub1 = new Subject("Materia I", 8);
    Subject sub2 = new Subject("Materia II", 9);
    List<Subject> expectedSubjects = new ArrayList<>(Arrays.asList(sub1, sub2));

    List<Subject> subjects = SubjectConverter.subjectFormToEntity(subjectForms);

    Assertions.assertNotNull(subjects);
    assertThat(subjects).usingRecursiveComparison().isEqualTo(expectedSubjects);
  }

  @Test
  public void shouldReturnAnInstanceOfSubjectDTO() {
    SubjectDTO subjectDTO = SubjectConverter.subjectEntityToDTO(new Subject("Materia I", 8));

    SubjectDTO expectedSubject = new SubjectDTO(null,"Materia I", 8);

    Assertions.assertNotNull(subjectDTO);
    assertThat(subjectDTO).usingRecursiveComparison().isEqualTo(expectedSubject);
  }

  @Test
  public void shouldReturnAListOfSubjectDTOs() {
    Subject s1 = new Subject("Materia I", 8);
    Subject s2 = new Subject("Materia II", 9);
    List<Subject> subjects = new ArrayList<>(Arrays.asList(s1, s2));

    SubjectDTO sub1 = new SubjectDTO(null, "Materia I", 8);
    SubjectDTO sub2 = new SubjectDTO(null, "Materia II", 9);
    List<SubjectDTO> expectedSubjects = new ArrayList<>(Arrays.asList(sub1, sub2));

    List<SubjectDTO> subjectDTOS = SubjectConverter.subjectEntityToDTO(subjects);

    Assertions.assertNotNull(subjectDTOS);
    assertThat(subjectDTOS).usingRecursiveComparison().isEqualTo(expectedSubjects);
  }
}
