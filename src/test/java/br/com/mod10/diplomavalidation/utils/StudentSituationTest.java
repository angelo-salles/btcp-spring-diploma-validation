package br.com.mod10.diplomavalidation.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentSituationTest {
  @Test
  public void shouldReturnApprovedWithCongratulations() {
    String message = StudentSituation.status(9.7);

    Assertions.assertTrue(message.contains("Parabéns"));
  }

  @Test
  public void shouldReturnApproved() {
    String message = StudentSituation.status(6.8);

    Assertions.assertTrue(message.contains("aprovado"));
  }

  @Test
  public void shouldReturnRecovery() {
    String message = StudentSituation.status(4.7);

    Assertions.assertTrue(message.contains("recuperação"));
  }

  @Test
  public void shouldReturnReproved() {
    String message = StudentSituation.status(2.0);

    Assertions.assertTrue(message.contains("reprovado"));
  }
}
