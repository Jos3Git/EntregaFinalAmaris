package org.greyhawk.rest.server.conventions.api.inbounds.rest.errorhandler;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.greyhawk.core.utils.commons.spring.ConstraintViolationExceptionParser;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaErrorDetailsDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class ConstraintViolationExceptionHandler implements SimpleResponseExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public final ResponseEntity<SimpleResponseDto<Void>> handleConstraintViolationException(final ConstraintViolationException ex,
      final WebRequest request) {
    final var violations = new ConstraintViolationExceptionParser(ex).getViolations();
    String i18nMsg = ex.getMessage();
    // TODO i18n, con params
    List<ResponseMetaErrorDetailsDto> errors = violations.stream()
        .map(v -> new ResponseMetaErrorDetailsDto(v.getField(), v.getError(), i18nMsg, null)).collect(Collectors.toList());
    return buildResponse(HttpStatus.UNPROCESSABLE_ENTITY, "ConstraintViolationException", errors);
  }

}