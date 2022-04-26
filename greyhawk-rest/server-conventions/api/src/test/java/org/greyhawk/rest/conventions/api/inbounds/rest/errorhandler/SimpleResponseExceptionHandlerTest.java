package org.greyhawk.rest.conventions.api.inbounds.rest.errorhandler;

import java.util.Arrays;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaErrorDetailsDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.errorhandler.SimpleResponseExceptionHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class SimpleResponseExceptionHandlerTest {

  private SimpleResponseExceptionHandler handler = new SimpleResponseExceptionHandler() {

  };

  @Test
  void should_build_response() {
    Assertions.assertEquals(
        "<417,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=417, "
            + "error=ResponseMetaErrorDto(message=my msg, details=null)), data=null)),[]>",
        handler.buildResponse(HttpStatus.EXPECTATION_FAILED, "my msg").toString());

    Assertions.assertEquals(
        "<411,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=411, " + "error=ResponseMetaErrorDto(message=msg2, "
            + "details=[ResponseMetaErrorDetailsDto(field=f1, errorCode=123, errorMsg=null, errorParams=null)])), data=null)),[]>",
        handler.buildResponse(HttpStatus.LENGTH_REQUIRED, "msg2",
            Arrays.asList(ResponseMetaErrorDetailsDto.builder().field("f1").errorCode("123").build())).toString());
  }

}
