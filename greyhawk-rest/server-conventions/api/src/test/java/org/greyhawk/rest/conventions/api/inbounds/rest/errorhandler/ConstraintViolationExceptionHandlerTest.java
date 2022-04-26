package org.greyhawk.rest.conventions.api.inbounds.rest.errorhandler;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.errorhandler.ConstraintViolationExceptionHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

class ConstraintViolationExceptionHandlerTest {

  @Test
  void should_handle_correctly() {
    Assertions.assertEquals("<422,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=422, "
        + "error=ResponseMetaErrorDto(message=ConstraintViolationException, "
        + "details=[ResponseMetaErrorDetailsDto(field=myerror, errorCode=strange_message, errorMsg=error1, errorParams=null)])), data=null)),[]>",
        handleViolation("error1", "strange_message", "myerror").toString());

    Assertions.assertEquals("<422,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=422, "
        + "error=ResponseMetaErrorDto(message=ConstraintViolationException, "
        + "details=[ResponseMetaErrorDetailsDto(field=myerror, errorCode=myfield, errorMsg=error2, errorParams=null)])), data=null)),[]>",
        handleViolation("error2", "{javax.validation.constraints.myfield.message}", "myerror").toString());
  }

  @SuppressWarnings("unchecked")
  protected ResponseEntity<SimpleResponseDto<Void>> handleViolation(String msg, String template, String field) {
    // when
    final ConstraintViolation<String> violation = Mockito.mock(ConstraintViolation.class);
    Mockito.when(violation.getMessageTemplate()).thenReturn(template);
    final var path = Mockito.mock(Path.class);
    Mockito.when(path.toString()).thenReturn(field);
    Mockito.when(violation.getPropertyPath()).thenReturn(path);
    final var exc = new ConstraintViolationException(msg, Set.of(violation));
    return new ConstraintViolationExceptionHandler().handleConstraintViolationException(exc, Mockito.mock(WebRequest.class));
  }

}
