package org.greyhawk.rest.server.conventions.api.inbounds.rest.errorhandler;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class UncaughtErrorExceptionHandler implements SimpleResponseExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<SimpleResponseDto<Void>> handleException(final Exception ex, final WebRequest request) throws Exception {
    return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.toString());
  }

}