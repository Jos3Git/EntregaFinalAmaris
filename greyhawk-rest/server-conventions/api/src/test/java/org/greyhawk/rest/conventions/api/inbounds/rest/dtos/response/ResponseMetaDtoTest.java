package org.greyhawk.rest.conventions.api.inbounds.rest.dtos.response;

import java.time.Instant;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaDto;
import org.greyhawk.rest.server.testutils.inbounds.rest.dtos.RestDtoTester;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;

class ResponseMetaDtoTest {

  @Test
  void test_dto() {
    final ResponseMetaDto dto = new ResponseMetaDto(Instant.now(), "200", null);
    RestDtoTester.test(dto, new TypeReference<ResponseMetaDto>() {
    });
  }

}
