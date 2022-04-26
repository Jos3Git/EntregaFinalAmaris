package org.greyhawk.utils.domain.exceptions;

import org.greyhawk.core.utils.domain.exceptions.RequestError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RequestErrorTest {

  @Test
  void test() {
    Assertions.assertEquals("org.greyhawk.core.utils.domain.exceptions.RequestError$BadRequestException: 123",
        new RequestError.BadRequestException("123").toString());

    Assertions.assertEquals(
        "org.greyhawk.core.utils.domain.exceptions.RequestError$InvalidInputDataException: mymsg. Code=09-11. Field=myfield. Params=[1, 2]",
        new RequestError.InvalidInputDataException("mymsg", "09-11", "myfield", "1", "2").toString());
    Assertions.assertEquals(
        "org.greyhawk.core.utils.domain.exceptions.RequestError$InvalidInputDataException: mymsg. Code=09-11. Field=null. Params=[]",
        new RequestError.InvalidInputDataException("mymsg", "09-11", null).toString());

  }

}
