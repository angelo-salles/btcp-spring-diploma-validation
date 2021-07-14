package br.com.mod10.diplomavalidation.converter;

import br.com.mod10.diplomavalidation.dto.StudentDTO;
import br.com.mod10.diplomavalidation.dto.SubjectDTO;
import br.com.mod10.diplomavalidation.entity.Student;
import br.com.mod10.diplomavalidation.entity.Subject;
import br.com.mod10.diplomavalidation.form.StudentForm;
import br.com.mod10.diplomavalidation.form.SubjectForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentConverterTest {
  @Test
  public void shouldReturnAnInstanceOfStudentEntity() {
    Student expectedStudent = new Student("Estudante", createSubjectList());

    Student student = StudentConverter.studentFormToEntity(new StudentForm("Estudante", createSubjectFormList()));

    Assertions.assertNotNull(student);
    assertThat(student).usingRecursiveComparison().isEqualTo(expectedStudent);
  }

  @Test
  public void shouldReturnAListOfStudentEntities() {
    StudentForm student1 = new StudentForm("Estudante I", createSubjectFormList());
    StudentForm student2 = new StudentForm("Estudante II", createSubjectFormList());
    List<StudentForm> studentForms = new ArrayList<>(Arrays.asList(student1, student2));

    Student std1 = new Student("Estudante I", createSubjectList());
    Student std2 = new Student("Estudante II", createSubjectList());
    List<Student> expectedSubjects = new ArrayList<>(Arrays.asList(std1, std2));

    List<Student> students = StudentConverter.studentFormToEntity(studentForms);

    Assertions.assertNotNull(students);
    assertThat(students).usingRecursiveComparison().isEqualTo(expectedSubjects);
  }

  @Test
  public void shouldReturnAnInstanceOfStudentDTO() {
    StudentDTO expectedStudent = new StudentDTO(null, "Estudante", createSubjectDTOList());

    StudentDTO student = StudentConverter.studentEntityToDTO(new Student("Estudante", createSubjectList()));

    Assertions.assertNotNull(student);
    assertThat(student).usingRecursiveComparison().isEqualTo(expectedStudent);
  }

  @Test
  public void shouldReturnAListOfStudentDTOs() {
    Student student1 = new Student("Estudante I", createSubjectList());
    Student student2 = new Student("Estudante II", createSubjectList());
    List<Student> students = new ArrayList<>(Arrays.asList(student1, student2));

    StudentDTO std1 = new StudentDTO(null, "Estudante I", createSubjectDTOList());
    StudentDTO std2 = new StudentDTO(null, "Estudante II", createSubjectDTOList());
    List<StudentDTO> expectedSubjects = new ArrayList<>(Arrays.asList(std1, std2));

    List<StudentDTO> studentDTOS = StudentConverter.studentEntityToDTO(students);

    Assertions.assertNotNull(studentDTOS);
    assertThat(studentDTOS).usingRecursiveComparison().isEqualTo(expectedSubjects);
  }

  private List<SubjectForm> createSubjectFormList() {
    SubjectForm s1 = new SubjectForm("Materia I", 8);
    SubjectForm s2 = new SubjectForm("Materia II", 9);
    return new ArrayList<>(Arrays.asList(s1, s2));
  }

  private List<Subject> createSubjectList() {
    Subject s1 = new Subject("Materia I", 8);
    Subject s2 = new Subject("Materia II", 9);
    return new ArrayList<>(Arrays.asList(s1, s2));
  }

  private List<SubjectDTO> createSubjectDTOList() {
    SubjectDTO s1 = new SubjectDTO(null, "Materia I", 8);
    SubjectDTO s2 = new SubjectDTO(null, "Materia II", 9);
    return new ArrayList<>(Arrays.asList(s1, s2));
  }
}
