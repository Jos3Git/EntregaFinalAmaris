package org.greyhawk.rest.conventions.api.inbounds.rest.dtos.formats;

import java.time.LocalDateTime;

import org.greyhawk.core.testutils.commons.JacksonMapperTester;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.formats.LocalDateTimeDtoFormat;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

class LocalDateTimeDtoFormatTest {

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Dto {
    private LocalDateTime ldt;
  }

  @Test
  void should_deser_dto() {
    final LocalDateTime ldt = LocalDateTime.now().withNano(0);
    new JacksonMapperTester(getMapper()).test(new Dto(ldt), new TypeReference<Dto>() {
    });
  }

  public ObjectMapper getMapper() {
    final var bldr = Jackson2ObjectMapperBuilder.json();

    bldr.serializers(new LocalDateTimeDtoFormat.Serializer());
    bldr.deserializers(new LocalDateTimeDtoFormat.Deserializer());

    bldr.modules(new JavaTimeModule());
    bldr.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    return bldr.build();
  }

}
