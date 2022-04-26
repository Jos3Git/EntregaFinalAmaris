package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.formats;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class RestJsonMapperBuilder {

  public ObjectMapper getMapper() {
    final var bldr = Jackson2ObjectMapperBuilder.json();

    bldr.failOnUnknownProperties(true);

    bldr.serializers(new LocalDateTimeDtoFormat.Serializer());
    bldr.deserializers(new LocalDateTimeDtoFormat.Deserializer());

    bldr.serializers(new InstantDtoFormat.Serializer());
    bldr.deserializers(new InstantDtoFormat.Deserializer());

    bldr.modules(new JavaTimeModule());
    bldr.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    bldr.indentOutput(true);
    bldr.propertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);

    return bldr.build();
  }

}