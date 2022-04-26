package org.greyhawk.rest.server.testutils.inbounds.rest.dtos;

import org.greyhawk.core.testutils.commons.BeanTester;
import org.greyhawk.core.testutils.commons.JacksonMapperTester;
import com.fasterxml.jackson.core.type.TypeReference;

public abstract class RestDtoTester {

  public static <T> void test(final T dto, final TypeReference<T> type) {
    BeanTester.test(dto);
    new JacksonMapperTester().test(dto, type);
  }

}
