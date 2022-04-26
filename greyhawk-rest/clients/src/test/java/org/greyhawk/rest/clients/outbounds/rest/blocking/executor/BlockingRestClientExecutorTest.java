package org.greyhawk.rest.clients.outbounds.rest.blocking.executor;

import java.net.URI;
import java.net.URISyntaxException;

import org.greyhawk.core.testutils.commons.AssertUtils;
import org.greyhawk.core.utils.commons.json.ClassTypeRef;
import org.greyhawk.rest.clients.outbounds.rest.blocking.request.BlockingRestClientRequestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ExtendWith(MockitoExtension.class)
class BlockingRestClientExecutorTest {

  private static final ClassTypeRef<String> STRING_TYPE = new ClassTypeRef<>(String.class, null);
  private static final ClassTypeRef<Long> LONG_TYPE = new ClassTypeRef<>(Long.class, new TypeReference<Long>() {
  });

  private @Mock RestTemplate template;

  private final ObjectMapper mapper = new ObjectMapper();

  @SuppressWarnings("serial")
  private final HttpHeaders headers = new HttpHeaders() {
    {
      add("my-header", "998-ioioi");
    }
  };

  @RequiredArgsConstructor
  @ToString
  protected static class DtoResponse {
    public static final ClassTypeRef<DtoResponse> TYPEREF = new ClassTypeRef<>(DtoResponse.class, new TypeReference<DtoResponse>() {
    });
    private final Long id;
    private final String name;
  }

  @SuppressWarnings("unchecked")
  @Test
  void should_execute_without_response_mapping() throws URISyntaxException {
    // given
    Mockito.when(
        template.exchange(Mockito.any(URI.class), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class), Mockito.any(Class.class)))
        .thenReturn(ResponseEntity.ok("resp"));
    // when
    final var request = new BlockingRestClientRequestData<String, String>(template, new URI("http://localhost:89089/api/"), HttpMethod.GET,
        headers, mapper, "payload", STRING_TYPE, null);
    // then
    Assertions.assertEquals("BlockingRestClientResponse(body=resp, headers=[], status=200 OK)",
        new BlockingRestClientExecutor<>(request).execute().toString());
  }

  @Test
  @SuppressWarnings("unchecked")
  void should_execute_with_response_mapping() throws URISyntaxException {
    // given
    Mockito.when(
        template.exchange(Mockito.any(URI.class), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class), Mockito.any(Class.class)))
        .thenReturn(ResponseEntity.ok("{ \"id\":12, \"name\":\"uiui\" }"));
    // when
    final var request = new BlockingRestClientRequestData<String, DtoResponse>(template, new URI("http://localhost:89089/api/"),
        HttpMethod.GET, headers, mapper, "payload", DtoResponse.TYPEREF, mapper);
    // then
    Assertions.assertEquals(
        "BlockingRestClientResponse(body=BlockingRestClientExecutorTest.DtoResponse(id=12, name=uiui), headers=[], status=200 OK)",
        new BlockingRestClientExecutor<>(request).execute().toString());
  }

  @Test
  @SuppressWarnings("unchecked")
  void should_execute_with_request_mapping() throws URISyntaxException {
    // given
    Mockito.when(
        template.exchange(Mockito.any(URI.class), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class), Mockito.any(Class.class)))
        .thenReturn(ResponseEntity.ok("resp"));
    // when
    final var request = new BlockingRestClientRequestData<String, String>(template, new URI("http://localhost:89089/api/"), HttpMethod.GET,
        headers, mapper, "payload", STRING_TYPE, null);
    // then
    Assertions.assertEquals("BlockingRestClientResponse(body=resp, headers=[], status=200 OK)",
        new BlockingRestClientExecutor<>(request).execute().toString());
  }

  @Test
  @SuppressWarnings("unchecked")
  void should_execute_without_request_mapping() throws URISyntaxException {
    // given
    Mockito.when(
        template.exchange(Mockito.any(URI.class), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class), Mockito.any(Class.class)))
        .thenReturn(ResponseEntity.ok("resp"));
    // when
    final var request = new BlockingRestClientRequestData<String, String>(template, new URI("http://localhost:89089/api/"), HttpMethod.GET,
        headers, null, "payload", STRING_TYPE, null);
    // then
    Assertions.assertEquals("BlockingRestClientResponse(body=resp, headers=[], status=200 OK)",
        new BlockingRestClientExecutor<>(request).execute().toString());
  }

  @Test
  void should_catch_mapping_errors() throws URISyntaxException {
    AssertUtils.assertException(() -> new BlockingRestClientExecutor<>(null).mapRequest(null), RuntimeException.class,
        "Error mapping request");

    final var request = new BlockingRestClientRequestData<String, Long>(template, new URI("http://localhost:89089/api/"), HttpMethod.GET,
        headers, mapper, "payload", LONG_TYPE, null);
    AssertUtils.assertException(() -> new BlockingRestClientExecutor<String, Long>(request).mapResponse("{", LONG_TYPE.getTypeRef()),
        RuntimeException.class, "Error mapping response");
  }

}
