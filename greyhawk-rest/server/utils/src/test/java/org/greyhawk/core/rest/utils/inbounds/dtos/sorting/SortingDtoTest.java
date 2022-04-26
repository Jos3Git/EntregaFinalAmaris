package org.greyhawk.core.rest.utils.inbounds.dtos.sorting;

import java.util.Arrays;

import org.greyhawk.rest.server.testutils.inbounds.rest.dtos.RestDtoTester;
import org.greyhawk.rest.server.utils.inbounds.dtos.sorting.SortingDto;
import org.greyhawk.rest.server.utils.inbounds.dtos.sorting.SortingDtoCriteria;
import org.greyhawk.rest.server.utils.inbounds.dtos.sorting.SortingDtoDirection;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;

class SortingDtoTest {

  @Test
  void test() {
    RestDtoTester.test(new SortingDto(Arrays.asList(new SortingDtoCriteria("f", SortingDtoDirection.ASC))),
        new TypeReference<SortingDto>() {
        });
  }
}
