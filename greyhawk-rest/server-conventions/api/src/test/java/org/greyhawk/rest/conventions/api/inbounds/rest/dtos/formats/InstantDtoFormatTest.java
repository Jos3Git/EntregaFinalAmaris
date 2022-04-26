package org.greyhawk.rest.conventions.api.inbounds.rest.dtos.formats;

import java.time.Instant;

import org.greyhawk.core.testutils.commons.JacksonMapperTester;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.formats.InstantDtoFormat;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

class InstantDtoFormatTest {

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Dto {
    private Instant inst;
  }

  @Test
  void should_deser_dto() {
    new JacksonMapperTester(getMapper()).test(new Dto(Instant.now()), new TypeReference<Dto>() {
    });
  }

  public ObjectMapper getMapper() {
    final var bldr = Jackson2ObjectMapperBuilder.json();

    bldr.serializers(new InstantDtoFormat.Serializer());
    bldr.deserializers(new InstantDtoFormat.Deserializer());

    bldr.modules(new JavaTimeModule());
    bldr.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    return bldr.build();
  }

}
