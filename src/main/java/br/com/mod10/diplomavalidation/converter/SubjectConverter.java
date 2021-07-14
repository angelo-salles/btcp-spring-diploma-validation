package br.com.mod10.diplomavalidation.converter;

import br.com.mod10.diplomavalidation.dto.SubjectDTO;
import br.com.mod10.diplomavalidation.entity.Subject;
import br.com.mod10.diplomavalidation.form.SubjectForm;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class SubjectConverter {
  public static Subject subjectFormToEntity(SubjectForm subjectForm) {
    ModelMapper mapper = new ModelMapper();
    Subject subject = mapper.map(subjectForm, Subject.class);
    return subject;
//    return new Subject(
//            subjectForm.getSubject(),
//            subjectForm.getNote()
//    );
  }

  public static List<Subject> subjectFormToEntity(List<SubjectForm> subjectForms) {
    List<Subject> subjects = new ArrayList<>();

    for (SubjectForm subjectForm : subjectForms) {
      subjects.add(subjectFormToEntity(subjectForm));
    }

    return subjects;
  }

  public static SubjectDTO subjectEntityToDTO(Subject subject) {
    ModelMapper mapper = new ModelMapper();
    SubjectDTO subjectDTO = mapper.map(subject, SubjectDTO.class);
    return subjectDTO;
//    return new SubjectDTO(
//            subject.getId(),
//            subject.getSubject(),
//            subject.getNote()
//    );
  }

  public static List<SubjectDTO> subjectEntityToDTO(List<Subject> subjects) {
    List<SubjectDTO> subjectDTOS = new ArrayList<>();

    for (Subject subject : subjects) {
      subjectDTOS.add(subjectEntityToDTO(subject));
    }

    return subjectDTOS;
  }
}
