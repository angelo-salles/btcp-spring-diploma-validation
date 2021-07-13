package br.com.mod10.diplomavalidation.converter;

import br.com.mod10.diplomavalidation.dto.StudentDTO;
import br.com.mod10.diplomavalidation.entity.Student;
import br.com.mod10.diplomavalidation.entity.Subject;
import br.com.mod10.diplomavalidation.form.StudentForm;

import java.util.ArrayList;
import java.util.List;

public class StudentConverter {
  public static Student studentFormToEntity(StudentForm studentForm) {
    return new Student(
            studentForm.getName(),
            SubjectConverter.subjectFormToEntity(studentForm.getSubjects())
    );
  }

  public static List<Student> studentFormToEntity(List<StudentForm> studentForms) {
    List<Student> students = new ArrayList<>();

    for (StudentForm studentForm : studentForms) {
      students.add(studentFormToEntity(studentForm));
    }

    return students;
  }

  public static StudentDTO studentEntityToDTO(Student student) {
    return new StudentDTO(
            student.getName(),
            SubjectConverter.subjectEntityToDTO(student.getSubjects())
    );
  }

  public static List<StudentDTO> studentEntityToDTO(List<Student> students) {
    List<StudentDTO> studentDTOS = new ArrayList<>();

    for (Student student : students) {
      studentDTOS.add(studentEntityToDTO(student));
    }

    return studentDTOS;
  }
}
