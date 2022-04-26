package org.greyhawk.rest.server.conventions.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan
@Slf4j
public class RestApiAutoConfiguration {

  public RestApiAutoConfiguration() {
    log.debug("Loading RestApi");
  }

}
