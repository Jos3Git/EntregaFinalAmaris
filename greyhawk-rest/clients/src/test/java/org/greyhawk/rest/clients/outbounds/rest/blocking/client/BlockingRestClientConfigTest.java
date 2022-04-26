package org.greyhawk.rest.clients.outbounds.rest.blocking.client;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

class BlockingRestClientConfigTest {

  @Test
  void test() {
    Map<String, String> headers = Map.of("a", "1");
    Assertions.assertEquals("BlockingRestClientConfig(baseUrl=myurl/, defaultHeaders={a=1})",
        new BlockingRestClientConfig(new RestTemplate(), new ObjectMapper(), null, "myurl", headers).toString());
  }

}
