package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.formats;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * 
 * Without nanoseconds
 *
 */
public final class LocalDateTimeDtoFormat {

  public static final String PATTERN = "yyyyMMdd-HHmmss";

  public static final String EXAMPLE = "20201010-134456";

  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

  private LocalDateTimeDtoFormat() {
    // empty
  }

  public static final class Serializer extends StdSerializer<LocalDateTime> {

    private static final long serialVersionUID = -8227008837682530745L;

    @Override
    public Class<LocalDateTime> handledType() {
      return LocalDateTime.class;
    }

    public Serializer() {
      this(null);
    }

    public Serializer(final Class<LocalDateTime> t) {
      super(t);
    }

    @Override
    public void serialize(final LocalDateTime value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
      gen.writeString(DATE_FORMATTER.format(value));
    }

  }

  public static final class Deserializer extends StdDeserializer<LocalDateTime> {

    private static final long serialVersionUID = 5589663636077481912L;

    public Deserializer() {
      this(null);
    }

    public Deserializer(final Class<LocalDateTime> t) {
      super(t);
    }

    @Override
    public Class<LocalDateTime> handledType() {
      return LocalDateTime.class;
    }

    @Override
    public LocalDateTime deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
      final String txt = p.getText();
      return LocalDateTime.parse(txt, DATE_FORMATTER);
    }

  }
}
