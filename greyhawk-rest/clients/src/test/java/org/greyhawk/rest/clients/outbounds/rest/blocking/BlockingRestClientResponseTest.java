package org.greyhawk.rest.clients.outbounds.rest.blocking;

import org.greyhawk.core.testutils.commons.BeanTester;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

class BlockingRestClientResponseTest {

  @Test
  void test() {
    final HttpHeaders headers = new HttpHeaders();
    BeanTester.test(new BlockingRestClientResponse<>("body", headers, HttpStatus.EXPECTATION_FAILED));
  }

}
