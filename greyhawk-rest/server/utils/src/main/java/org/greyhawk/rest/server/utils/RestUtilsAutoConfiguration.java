package org.greyhawk.rest.server.utils;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan
@Slf4j
public class RestUtilsAutoConfiguration {

  public RestUtilsAutoConfiguration() {
    log.debug("Loading RestUtils");
  }

}
