package org.greyhawk.core.testutils.commons;

import org.junit.jupiter.api.Assertions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonMapperTester {

  private final ObjectMapper mapper;

  public JacksonMapperTester() {
    this(new JacksonMapperBuilder().getMapper());
  }

  public JacksonMapperTester(final ObjectMapper objMapper) {
    this.mapper = objMapper;
  }

  public <D, T> void test(final D dto, final TypeReference<T> type) {
    // when
    String mapped = testWrite(dto);
    // and when
    final T mappedBack = testRead(mapped, type);
    // then
    Assertions.assertEquals(dto, mappedBack);
  }

  public <D> String testWrite(final D dto) {
    try {
      return mapper.writeValueAsString(dto);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Error writing: " + dto.toString(), e);
    }
  }

  public <T> T testRead(final String dto, final TypeReference<T> type) {
    try {
      return mapper.readValue(dto, type);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Error reading: " + dto, e);
    }
  }

}
