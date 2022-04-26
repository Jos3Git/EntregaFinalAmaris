package org.greyhawk.rest.conventions.api.inbounds.rest.apidoc.configuration;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.configuration.ApiDocSwaggerConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApiDocSwaggerConfigurationTest {

  private ApiDocSwaggerConfiguration config = new ApiDocSwaggerConfiguration();

  @Test
  void should_build_beans() {
    Assertions.assertNotNull(config.apiInfo());
    Assertions.assertNotNull(config.docket(config.apiInfo()));
  }

}
