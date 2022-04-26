package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.formats;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public final class InstantDtoFormat {

  public static final String PATTERN = "yyyyMMdd-HHmmss.SSSSSS";

  public static final String EXAMPLE = "20201010-134456.65432";

  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(PATTERN).withZone(ZoneOffset.UTC);

  private InstantDtoFormat() {
    // empty
  }

  public static final class Serializer extends StdSerializer<Instant> {

    private static final long serialVersionUID = -798024844273922660L;

    @Override
    public Class<Instant> handledType() {
      return Instant.class;
    }

    public Serializer() {
      this(null);
    }

    public Serializer(final Class<Instant> t) {
      super(t);
    }

    @Override
    public void serialize(final Instant value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
      gen.writeString(DATE_FORMATTER.format(value));
    }

  }

  public static final class Deserializer extends StdDeserializer<Instant> {

    private static final long serialVersionUID = -1368723440651938324L;

    public Deserializer() {
      this(null);
    }

    public Deserializer(final Class<Instant> t) {
      super(t);
    }

    @Override
    public Class<Instant> handledType() {
      return Instant.class;
    }

    @Override
    public Instant deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
      final String txt = p.getText();
      return Instant.from(DATE_FORMATTER.parse(txt));
    }

  }
}
