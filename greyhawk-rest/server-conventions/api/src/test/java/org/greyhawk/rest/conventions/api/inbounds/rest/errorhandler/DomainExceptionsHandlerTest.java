package org.greyhawk.rest.conventions.api.inbounds.rest.errorhandler;

import java.io.IOException;

import org.greyhawk.core.utils.domain.exceptions.DomainError.ConflictException;
import org.greyhawk.core.utils.domain.exceptions.DomainError.ElementNotFoundException;
import org.greyhawk.core.utils.domain.exceptions.RequestError.BadRequestException;
import org.greyhawk.core.utils.domain.exceptions.RequestError.InvalidInputDataException;
import org.greyhawk.core.utils.domain.exceptions.ServiceError.TemporaryException;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.errorhandler.DomainExceptionsHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class DomainExceptionsHandlerTest {

  private DomainExceptionsHandler handler = new DomainExceptionsHandler();

  @Test
  void should_handle_known_exception() throws Exception {
    Assertions.assertEquals("<400,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=400, "
        + "error=ResponseMetaErrorDto(message=org.greyhawk.core.utils.domain.exceptions.RequestError$BadRequestException: msg, details=null)), "
        + "data=null)),[]>", handler.handleException(new BadRequestException("msg"), null).toString());
  }

  @Test
  void should_handle_unknown_exception() throws Exception {
    Assertions.assertEquals(
        "<500,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=500, "
            + "error=ResponseMetaErrorDto(message=java.io.IOException: msg, details=null)), data=null)),[]>",
        handler.handleException(new IOException("msg"), null).toString());
  }

  @Test
  void should_build_correct_sc() throws Exception {
    Assertions.assertEquals(HttpStatus.BAD_REQUEST, handler.handleException(new BadRequestException("msg"), null).getStatusCode());
    Assertions.assertEquals(HttpStatus.UNPROCESSABLE_ENTITY,
        handler.handleException(new InvalidInputDataException("msg", "code", "field"), null).getStatusCode());
    Assertions.assertEquals(HttpStatus.NOT_FOUND, handler.handleException(new ElementNotFoundException("msg"), null).getStatusCode());
    Assertions.assertEquals(HttpStatus.CONFLICT, handler.handleException(new ConflictException("msg"), null).getStatusCode());
    Assertions.assertEquals(HttpStatus.SERVICE_UNAVAILABLE, handler.handleException(new TemporaryException("msg"), null).getStatusCode());
  }

}
