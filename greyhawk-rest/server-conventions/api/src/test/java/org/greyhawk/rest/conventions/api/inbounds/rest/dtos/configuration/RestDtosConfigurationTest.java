package org.greyhawk.rest.conventions.api.inbounds.rest.dtos.configuration;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.configuration.RestDtosConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RestDtosConfigurationTest {

  RestDtosConfiguration config = new RestDtosConfiguration();

  @Test
  void should_build_beans() {
    Assertions.assertNotNull(config.restJsonMapper());
  }

}
