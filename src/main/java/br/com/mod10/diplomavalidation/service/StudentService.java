package br.com.mod10.diplomavalidation.service;

import br.com.mod10.diplomavalidation.controller.StudentController;
import br.com.mod10.diplomavalidation.converter.StudentConverter;
import br.com.mod10.diplomavalidation.dto.DegreeDTO;
import br.com.mod10.diplomavalidation.dto.StudentDTO;
import br.com.mod10.diplomavalidation.entity.Student;
import br.com.mod10.diplomavalidation.exception.handler.StudentNotExistsException;
import br.com.mod10.diplomavalidation.form.StudentForm;
import br.com.mod10.diplomavalidation.repository.StudentRepository;
import br.com.mod10.diplomavalidation.utils.CalculateAverage;
import br.com.mod10.diplomavalidation.utils.StudentSituation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

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

  public DegreeDTO degree(long id) {
    StudentDTO student = findById(id);
    double average = CalculateAverage.calcAverage(student.getSubjects());
    String message = StudentSituation.status(average);

    return new DegreeDTO(
            message,
            Double.valueOf(df.format(average)),
            student
    );
  }

  public StudentDTO save(Student student) {
    Student studentResponse = this.studentRepository.save(student);
    return StudentConverter.studentEntityToDTO(studentResponse);
  }

  public List<StudentDTO> findAll() {
    List<Student> students = Streamable.of(this.studentRepository.findAll()).toList();
    return StudentConverter.studentEntityToDTO(students);
  }

  public StudentDTO findById(long id) {
    Optional<Student> student = this.studentRepository.findById(id);

    if(student.isPresent()) {
      return StudentConverter.studentEntityToDTO(student.get());
    }

    throw new StudentNotExistsException("Estudante não cadastrado");
  }
}
