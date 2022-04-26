package org.greyhawk.utils.domain.exceptions;

import org.greyhawk.core.utils.domain.exceptions.DomainError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DomainErrorTest {

  @Test
  void test() {
    Assertions.assertEquals("org.greyhawk.core.utils.domain.exceptions.DomainError$ElementNotFoundException: test",
        new DomainError.ElementNotFoundException("test").toString());
    Assertions.assertEquals("org.greyhawk.core.utils.domain.exceptions.DomainError$ConflictException: ABC",
        new DomainError.ConflictException("ABC").toString());
  }

}
