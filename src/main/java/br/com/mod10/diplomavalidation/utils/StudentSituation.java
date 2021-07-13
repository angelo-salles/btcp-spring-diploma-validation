package br.com.mod10.diplomavalidation.utils;

public class StudentSituation {
  public static String status(Double average) {
    String message = "Sua média foi de: " + String.format("%.1f", average);
    if(average >= 9) {
      return "Parabéns, você foi aprovado! " + message;
    } else if(average >= 5) {
      return "Você foi aprovado! " + message;
    } else if(average >= 3) {
      return "Você está de recuperação! " + message;
    } else {
      return "Você foi reprovado! " + message;
    }
  }
}
