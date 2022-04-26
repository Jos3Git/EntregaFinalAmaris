package org.greyhawk.rest.server.testutils.inbounds.rest.controllers.mockmvc;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public abstract class MockMvcBase {

  private MockMvc mvc;

  private MockMvcPerformer performer;

  private final ObjectMapper jsonMapper = buildJsonObjectMapper();

  protected abstract String getUriRoot();

  protected abstract Object buildController();

  protected abstract Map<String, String> buildDefaultHeaders();

  protected String dtoToJson(final Object dto) {
    try {
      return jsonMapper.writeValueAsString(dto);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Error converting DTO to String", e);
    }
  }

  protected ObjectMapper buildJsonObjectMapper() {
    final var bldr = Jackson2ObjectMapperBuilder.json();
    bldr.modules(new JavaTimeModule());
    bldr.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    return bldr.build();
  }

  public MockMvcPerformer performer() {
    return performer;
  }

  public MockMvcAsserter buildAsserter(final ResultActions results) {
    return new MockMvcAsserter(results);
  }

  @BeforeEach
  public void setup() {
    this.setupMvc(buildController());
    performer = new MockMvcPerformer(mvc, getUriRoot(), buildDefaultHeaders());
  }

  public void setupMvc(final Object controller) {
    mvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

}
