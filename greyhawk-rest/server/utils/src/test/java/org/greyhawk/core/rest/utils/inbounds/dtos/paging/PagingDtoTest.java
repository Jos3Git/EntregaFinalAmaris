package org.greyhawk.core.rest.utils.inbounds.dtos.paging;

import org.greyhawk.rest.server.testutils.inbounds.rest.dtos.RestDtoTester;
import org.greyhawk.rest.server.utils.inbounds.dtos.paging.PagingDto;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;

class PagingDtoTest {

  @Test
  void test() {
    RestDtoTester.test(new PagingDto(2, 3), new TypeReference<PagingDto>() {
    });
  }

}
