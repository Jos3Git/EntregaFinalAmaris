package org.greyhawk.rest.clients.outbounds.rest.blocking.client;

import org.greyhawk.core.utils.commons.json.ClassTypeRef;
import org.greyhawk.rest.clients.outbounds.rest.blocking.request.BlockingRestClientRequestBuilderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@ExtendWith(MockitoExtension.class)
class BlockingRestClientCompTest {

  private BlockingRestClientConfig config = new BlockingRestClientConfig(Mockito.mock(RestTemplate.class), null, null, "url", null);

  private BlockingRestClientImpl client = new BlockingRestClientImpl(config) {
    @Override
    protected <Q, S> S execute(final BlockingRestClientRequestBuilderImpl<Q, S> bldr) {
      return null;
    };
  };

  @Data
  @RequiredArgsConstructor
  protected static class DtoResponse {
    public static final ClassTypeRef<DtoResponse> TYPEREF = new ClassTypeRef<>(DtoResponse.class, new TypeReference<DtoResponse>() {
    });
    private final Long id;
    private final String name;
  }

  @Test
  void should_have_methods() {
    client.get("uri");
    client.get("uri", DtoResponse.TYPEREF);

    client.delete("uri");

    client.put("uri");
    client.put("uri", "requ");
    client.put("uri", DtoResponse.TYPEREF);
    client.put("uri", "requ", DtoResponse.TYPEREF);
  }

  @Test
  void should_build_customized() {
    Assertions.assertNotNull(client.custom());
    Assertions.assertNotNull(client.custom(DtoResponse.TYPEREF));
  }

}
