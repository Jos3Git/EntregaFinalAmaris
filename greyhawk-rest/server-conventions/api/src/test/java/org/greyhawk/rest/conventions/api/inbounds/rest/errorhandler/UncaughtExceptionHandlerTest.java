package org.greyhawk.rest.conventions.api.inbounds.rest.errorhandler;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.errorhandler.UncaughtErrorExceptionHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UncaughtExceptionHandlerTest {

  private UncaughtErrorExceptionHandler handler = new UncaughtErrorExceptionHandler();

  @Test
  void should_handle_known_exception() throws Exception {
    Assertions.assertEquals(
        "<500,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=500, "
            + "error=ResponseMetaErrorDto(message=java.lang.Exception: what?, details=null)), data=null)),[]>",
        handler.handleException(new Exception("what?"), null).toString());
  }
}
