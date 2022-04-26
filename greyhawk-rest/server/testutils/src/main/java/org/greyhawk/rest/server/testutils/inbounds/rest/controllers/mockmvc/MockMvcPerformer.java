package org.greyhawk.rest.server.testutils.inbounds.rest.controllers.mockmvc;

import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class MockMvcPerformer {

  private final MockMvc mvc;
  private final String uriRoot;
  private final Map<String, String> defaultHeaders;

  public ResultActions get(final String uri) {
    final var url = getUrl(uri);
    log.debug("Executing GET. URL={}", url);
    final var action = MockMvcRequestBuilders.get(url);
    return perform(action);
  }

  public ResultActions post(final String uri, final String payload) {
    final var url = getUrl(uri);
    log.debug("Executing POST. URL={}. Payload={}.", url, payload);
    final var action = MockMvcRequestBuilders.post(url).content(payload);
    return perform(action);
  }

  public ResultActions put(final String uri, final String payload) {
    final var url = getUrl(uri);
    log.debug("Executing PUT. URL={}. Payload={}.", url, payload);
    final var action = MockMvcRequestBuilders.put(url).content(payload);
    return perform(action);
  }

  public ResultActions patch(final String uri, final @Nullable String payload) {
    final var url = getUrl(uri);
    log.debug("Executing PATCH. URL={}. Payload={}.", url, payload);
    MockHttpServletRequestBuilder action = MockMvcRequestBuilders.patch(url);
    if (null != payload) {
      action.content(payload);
    }
    return perform(action);
  }

  public ResultActions delete(final String uri) {
    final var url = getUrl(uri);
    log.debug("Executing DELETE. URL={}", url);
    final var action = MockMvcRequestBuilders.delete(url);
    return perform(action);
  }

  protected String getUrl(final String uri) {
    return uriRoot + uri;
  }

  protected ResultActions perform(final MockHttpServletRequestBuilder action) {
    var headers = new HttpHeaders();
    if (null != defaultHeaders) {
      defaultHeaders.forEach((k, v) -> headers.add(k, v));
    }
    action.headers(headers);
    log.debug("Performing. Headers={}", headers);
    try {
      ResultActions result = mvc.perform(action);
      final var content = result.andReturn().getResponse().getContentAsString();
      log.debug("Received content: {}", content);
      return result;
    } catch (Exception e) {
      throw new MockMvcPerformerException(e);
    }
  }

}
