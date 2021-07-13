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
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

@Service
public class StudentService {

  private StudentRepository studentRepository;
  private DecimalFormatSymbols dfs = new DecimalFormatSymbols (new Locale ("eng", "US"));
  private DecimalFormat df = new DecimalFormat("#.#", dfs);

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

  public void save(StudentForm studentForm) {
    this.studentRepository.save(StudentConverter.studentFormToEntity(studentForm));
  }

  public List<StudentDTO> findAll() {
    return StudentConverter.studentEntityToDTO(this.studentRepository.findAll());
  }
}
