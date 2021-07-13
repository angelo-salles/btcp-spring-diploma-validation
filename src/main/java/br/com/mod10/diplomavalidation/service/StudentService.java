package br.com.mod10.diplomavalidation.service;

import br.com.mod10.diplomavalidation.converter.StudentConverter;
import br.com.mod10.diplomavalidation.dto.DegreeDTO;
import br.com.mod10.diplomavalidation.dto.StudentDTO;
import br.com.mod10.diplomavalidation.entity.Student;
import br.com.mod10.diplomavalidation.form.StudentForm;
import br.com.mod10.diplomavalidation.repository.StudentRepository;
import br.com.mod10.diplomavalidation.utils.CalculateAverage;
import br.com.mod10.diplomavalidation.utils.StudentSituation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class StudentService {

  private StudentRepository studentRepository;
  private DecimalFormat df = new DecimalFormat("#.#");

  public StudentService() {
  }

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public DegreeDTO degree(StudentForm studentForm) {
    double average = CalculateAverage.calcAverage(studentForm.getSubjects());
    String message = StudentSituation.status(average);

    Student student = StudentConverter.studentFormToEntity(studentForm);
    StudentDTO studentResponse = StudentConverter.studentEntityToDTO(student);

    return new DegreeDTO(
            message,
            Double.valueOf(df.format(average)),
            studentResponse
    );
  }
}
