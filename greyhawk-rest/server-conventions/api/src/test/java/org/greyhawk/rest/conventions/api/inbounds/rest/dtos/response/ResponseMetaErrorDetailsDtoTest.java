package org.greyhawk.rest.conventions.api.inbounds.rest.dtos.response;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaErrorDetailsDto;
import org.greyhawk.rest.server.testutils.inbounds.rest.dtos.RestDtoTester;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;

class ResponseMetaErrorDetailsDtoTest {

  @Test
  void test_dto() {
    final ResponseMetaErrorDetailsDto dto = new ResponseMetaErrorDetailsDto("f", "code", "msg", new String[] { "p1", "p2" });
    RestDtoTester.test(dto, new TypeReference<ResponseMetaErrorDetailsDto>() {
    });
  }

}
