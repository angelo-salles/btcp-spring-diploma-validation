package br.com.mod10.diplomavalidation.utils;

import br.com.mod10.diplomavalidation.form.SubjectForm;

import java.util.List;

public class CalculateAverage {

  public static double calcAverage(List<SubjectForm> subjects) {
    double average = 0;

    for (SubjectForm subject : subjects) {
      average += subject.getNote();
    }

    return average / subjects.size();
  }
}
