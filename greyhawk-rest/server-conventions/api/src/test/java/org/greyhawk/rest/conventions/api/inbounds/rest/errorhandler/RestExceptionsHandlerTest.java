package org.greyhawk.rest.conventions.api.inbounds.rest.errorhandler;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.errorhandler.RestExceptionsHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MissingServletRequestParameterException;

class RestExceptionsHandlerTest {

  private RestExceptionsHandler handler = new RestExceptionsHandler();

  @Test
  void should_handle_known_exception() throws Exception {
    Assertions.assertEquals("<400 BAD_REQUEST Bad Request,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=400 BAD_REQUEST, "
        + "error=ResponseMetaErrorDto(message=org.springframework.web.bind.MissingServletRequestParameterException: Required request parameter 'p' for method parameter type t is not present, details=null)), "
        + "data=null)),[]>", handler.handleException(new MissingServletRequestParameterException("p", "t"), null).toString());

    Assertions.assertEquals(
        "<406 NOT_ACCEPTABLE Not Acceptable,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=406 NOT_ACCEPTABLE, "
            + "error=ResponseMetaErrorDto(message=null, details=null)), data=null)),[]>",
        handler.handleException(new HttpMediaTypeNotAcceptableException("m"), null).toString());
  }

}
