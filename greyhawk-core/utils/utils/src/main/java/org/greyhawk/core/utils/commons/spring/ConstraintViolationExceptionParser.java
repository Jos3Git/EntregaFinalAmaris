package org.greyhawk.core.utils.commons.spring;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
public class ConstraintViolationExceptionParser {

  private static final String VALIDATION_PREFIX = "{javax.validation.constraints.";
  private static final String VALIDATION_POSTFIX = ".message}";

  private final ConstraintViolationException exception;

  @ToString
  @Getter
  @RequiredArgsConstructor
  public static class Violation {
    private final String error;
    private final String field;
  }

  public List<Violation> getViolations() {
    return exception.getConstraintViolations().stream().map(e -> buildViolation(e)).collect(Collectors.toList());
  }

  protected Violation buildViolation(final ConstraintViolation<?> e) {
    return new Violation(getError(e.getMessageTemplate()), getField(e.getPropertyPath()));
  }

  protected String getError(final String template) {
    return Optional.ofNullable(template).filter(e -> e.startsWith(VALIDATION_PREFIX)).map(e -> {
      String err = e.substring(VALIDATION_PREFIX.length());
      err = err.substring(0, err.length() - VALIDATION_POSTFIX.length());
      return err;
    }).orElse(template);
  }

  protected String getField(final Path path) {
    return (null == path) ? null : path.toString();
  }

}