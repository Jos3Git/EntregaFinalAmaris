package org.greyhawk.rest.server.conventions.api.inbounds.rest.errorhandler;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaErrorDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionsHandler extends ResponseEntityExceptionHandler implements SimpleResponseExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(final HttpMediaTypeNotAcceptableException ex, final HttpHeaders headers,
      final HttpStatus status, final WebRequest request) {
    // wrong accept type, i.e. impossible to return a body
    return buildObjectResponse(status, null);
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(final Exception ex, final Object body, final HttpHeaders headers,
      final HttpStatus status, final WebRequest request) {
    return buildObjectResponse(status, ex.toString());
  }

  protected ResponseEntity<Object> buildObjectResponse(final HttpStatus status, final String msg) {
    final var error = ResponseMetaErrorDto.builder().message(msg).build();
    final var metaData = ResponseMetaDto.builder().status("" + status).error(error).build();
    final SimpleResponseDto<Void> body = new SimpleResponseDto<>(metaData, null);
    return ResponseEntity.status(status).body(body);
  }

}
