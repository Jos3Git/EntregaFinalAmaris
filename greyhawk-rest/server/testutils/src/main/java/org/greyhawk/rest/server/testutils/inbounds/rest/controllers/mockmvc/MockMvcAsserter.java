package org.greyhawk.rest.server.testutils.inbounds.rest.controllers.mockmvc;

import org.junit.jupiter.api.function.ThrowingConsumer;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MockMvcAsserter {

  private final ResultActions results;

  public void statusBodyJson(final HttpStatus expectedStatus, final String expectedJsonLenient) {
    status(expectedStatus);
    bodyJson(expectedJsonLenient);
  }

  public void status(final HttpStatus expectedStatus) {
    try {
      results.andExpect(MockMvcResultMatchers.status().is(expectedStatus.value()));
    } catch (Exception e) {
      throw new AssertionError(e);
    }
  }

  public void bodyJson(final String expectedJsonLenient) {
    body(content -> JSONAssert.assertEquals(expectedJsonLenient, content, JSONCompareMode.LENIENT));
  }

  public void body(final ThrowingConsumer<String> cons) {
    try {
      final var content = results.andReturn().getResponse().getContentAsString();
      cons.accept(content);
    } catch (Throwable e) {
      throw new AssertionError(e);
    }
  }

  public void header(final String header, final String expectedValue) {
    try {
      results.andExpect(MockMvcResultMatchers.header().exists(header));
      results.andExpect(MockMvcResultMatchers.header().string(header, expectedValue));
    } catch (Exception e) {
      throw new AssertionError(e);
    }
  }

}
