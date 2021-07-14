package br.com.mod10.diplomavalidation.converter;

import br.com.mod10.diplomavalidation.dto.StudentDTO;
import br.com.mod10.diplomavalidation.entity.Student;
import br.com.mod10.diplomavalidation.entity.Subject;
import br.com.mod10.diplomavalidation.form.StudentForm;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class StudentConverter {
  public static Student studentFormToEntity(StudentForm studentForm) {
    ModelMapper mapper = new ModelMapper();
    Student student = mapper.map(studentForm, Student.class);
    return student;
  }

  public static List<Student> studentFormToEntity(List<StudentForm> studentForms) {
    List<Student> students = new ArrayList<>();

    for (StudentForm studentForm : studentForms) {
      students.add(studentFormToEntity(studentForm));
    }

    return students;
  }

  public static StudentDTO studentEntityToDTO(Student student) {
    ModelMapper mapper = new ModelMapper();
    StudentDTO studentDTO = mapper.map(student, StudentDTO.class);
    return studentDTO;
  }

  public static List<StudentDTO> studentEntityToDTO(List<Student> students) {
    List<StudentDTO> studentDTOS = new ArrayList<>();

    for (Student student : students) {
      studentDTOS.add(studentEntityToDTO(student));
    }

    return studentDTOS;
  }
}
