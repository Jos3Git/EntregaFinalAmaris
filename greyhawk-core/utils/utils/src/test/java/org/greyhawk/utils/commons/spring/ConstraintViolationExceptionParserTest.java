package org.greyhawk.utils.commons.spring;

import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import org.greyhawk.core.utils.commons.spring.ConstraintViolationExceptionParser;
import org.greyhawk.core.utils.commons.spring.ConstraintViolationExceptionParser.Violation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ConstraintViolationExceptionParserTest {

  @Test
  void should_parse_correctly() {
    Assertions.assertEquals("[ConstraintViolationExceptionParser.Violation(error=strange_message, field=myerror)]",
        buildViolation("error1", "strange_message", "myerror").toString());
    Assertions.assertEquals("[ConstraintViolationExceptionParser.Violation(error=name, field=myerror)]",
        buildViolation("error2", "{javax.validation.constraints.name.message}", "myerror").toString());
  }

  @SuppressWarnings("unchecked")
  protected List<Violation> buildViolation(String msg, String template, String field) {
    // when
    final ConstraintViolation<String> violation = Mockito.mock(ConstraintViolation.class);
    Mockito.when(violation.getMessageTemplate()).thenReturn(template);
    final var path = Mockito.mock(Path.class);
    Mockito.when(path.toString()).thenReturn(field);
    Mockito.when(violation.getPropertyPath()).thenReturn(path);
    final var exc = new ConstraintViolationException(msg, Set.of(violation));
    return new ConstraintViolationExceptionParser(exc).getViolations();
  }

}
