package org.greyhawk.rest.server.conventions.api.inbounds.rest.errorhandler;

import java.util.List;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaErrorDetailsDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface SimpleResponseExceptionHandler {

  default <S> ResponseEntity<SimpleResponseDto<S>> buildResponse(final HttpStatus status, final String msg) {
    return buildResponse(status, msg, null);
  }

  default <S> ResponseEntity<SimpleResponseDto<S>> buildResponse(HttpStatus status, String msg, List<ResponseMetaErrorDetailsDto> errors) {
    return SimpleResponseDto.error("" + status.value(), msg, errors);
  }

}
