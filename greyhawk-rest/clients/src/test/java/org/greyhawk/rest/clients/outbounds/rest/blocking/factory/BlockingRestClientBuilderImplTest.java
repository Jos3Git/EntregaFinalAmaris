package org.greyhawk.rest.clients.outbounds.rest.blocking.factory;

import org.greyhawk.rest.clients.outbounds.rest.blocking.BlockingRestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

class BlockingRestClientBuilderImplTest {

  @Test
  void should_build() {
    BlockingRestClient client = new BlockingRestClientBuilderImpl(new RestTemplate()).url("myuri").template(new RestTemplate())
        .requestMapper(new ObjectMapper()).responseMapper(new ObjectMapper()).header("a", "1").header("b", "2").build();
    Assertions.assertNotNull(client);
  }

  @Test
  void should_build_from_config() {
    BlockingRestClient client = new BlockingRestClientBuilderImpl(new RestTemplate(), "myconfig").url("myuri").template(new RestTemplate())
        .requestMapper(new ObjectMapper()).responseMapper(new ObjectMapper()).header("a", "1").header("b", "2").build();
    Assertions.assertNotNull(client);
  }

}
