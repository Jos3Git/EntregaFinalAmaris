package org.greyhawk.rest.conventions.api.inbounds.rest.dtos.response;

import java.util.Arrays;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaErrorDetailsDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaErrorDto;
import org.greyhawk.rest.server.testutils.inbounds.rest.dtos.RestDtoTester;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;

class ResponseMetaErrorDtoTest {

  @Test
  void test_dto() {
    final ResponseMetaErrorDto dto = new ResponseMetaErrorDto("msg",
        Arrays.asList(new ResponseMetaErrorDetailsDto("f", "code", "msg", new String[] { "p1", "p2" })));
    RestDtoTester.test(dto, new TypeReference<ResponseMetaErrorDto>() {
    });
  }

}
