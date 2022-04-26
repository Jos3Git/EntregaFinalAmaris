package org.greyhawk.rest.clients.outbounds.rest.blocking.request;

import java.net.URI;

import org.greyhawk.core.utils.commons.json.ClassTypeRef;
import org.greyhawk.rest.clients.outbounds.rest.blocking.BlockingRestClient;
import org.greyhawk.rest.clients.outbounds.rest.blocking.client.BlockingRestClientConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class BlockingRestClientRequestBuilderImplTest {

  private @Mock RestTemplate template;

  @Test
  void should_build() {
    final var config = new BlockingRestClientConfig(template, null, null, "url", null);
    final BlockingRestClientRequestBuilderImpl<String, Long> bldr = new BlockingRestClientRequestBuilderImpl<String, Long>(config)
        .method(HttpMethod.HEAD).uri("uri").header("a", "1").requestMapper(new ObjectMapper()).responseMapper(null).payload("abc")
        .responseType(new ClassTypeRef<>(null, null));
    Assertions.assertNotNull(bldr.buildRequest());
  }

  @Test
  @SuppressWarnings("unchecked")
  void should_execute() {
    // given
    Mockito.when(
        template.exchange(Mockito.any(URI.class), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class), Mockito.any(Class.class)))
        .thenReturn(ResponseEntity.ok("resp"));
    // when
    final var config = new BlockingRestClientConfig(template, null, null, "url", null);
    final var bldr = new BlockingRestClientRequestBuilderImpl<String, String>(config).method(HttpMethod.GET).uri("uri")
        .responseType(BlockingRestClient.STRING_TYPE);
    // then
    Assertions.assertNotNull(bldr.execute());
  }

}
