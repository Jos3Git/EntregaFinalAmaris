package org.greyhawk.rest.conventions.api.inbounds.rest.dtos.response;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseDto;
import org.greyhawk.rest.server.testutils.inbounds.rest.dtos.RestDtoTester;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;

class ResponseDtoTest {

  @Test
  void test_dto() {
    final ResponseDto<String, Long> dto = new ResponseDto<>("abc", 223L);
    RestDtoTester.test(dto, new TypeReference<ResponseDto<String, Long>>() {
    });
  }

}
