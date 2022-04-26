package org.greyhawk.utils.domain.exceptions;

import org.greyhawk.core.utils.domain.exceptions.ServiceError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ServiceErrorTest {

  @Test
  void test() {
    Assertions.assertEquals("org.greyhawk.core.utils.domain.exceptions.ServiceError$TemporaryException: test",
        new ServiceError.TemporaryException("test").toString());
  }
}
