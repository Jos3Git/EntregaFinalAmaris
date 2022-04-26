package org.greyhawk.rest.clients.outbounds.rest.blocking.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BlockingRestClientFactoryCompTest {

  private BlockingRestClientFactoryComp factory = new BlockingRestClientFactoryComp();

  @Test
  void should_build() {
    Assertions.assertNotNull(factory.builder());
  }

  @Test
  void should_build_from_config() {
    Assertions.assertNotNull(factory.builderFromConfig("my-rest-service"));
  }

}
