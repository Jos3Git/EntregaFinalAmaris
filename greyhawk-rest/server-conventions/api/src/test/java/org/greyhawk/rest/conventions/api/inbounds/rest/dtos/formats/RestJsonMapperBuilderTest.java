package org.greyhawk.rest.conventions.api.inbounds.rest.dtos.formats;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.formats.RestJsonMapperBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RestJsonMapperBuilderTest {

  @Test
  void should_build() {
    Assertions.assertNotNull(new RestJsonMapperBuilder().getMapper());
  }

}
