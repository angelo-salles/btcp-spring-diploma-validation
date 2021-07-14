package br.com.mod10.diplomavalidation.utils;

import br.com.mod10.diplomavalidation.dto.SubjectDTO;
import br.com.mod10.diplomavalidation.entity.Subject;

import java.util.List;

public class CalculateAverage {

  public static double calcAverage(List<SubjectDTO> subjects) {
    double average = 0;

    for (SubjectDTO subject : subjects) {
      average += subject.getNote();
    }

    return average / subjects.size();
  }
}
