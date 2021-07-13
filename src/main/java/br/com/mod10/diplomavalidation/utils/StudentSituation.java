package br.com.mod10.diplomavalidation.utils;

public class StudentSituation {
  public static String status(Double average) {
    return "Sua média foi de: " + String.format("%.1f", average);
  }
}
