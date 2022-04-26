package org.greyhawk.rest.clients;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

//TODO git repo propio "core-extensions" 

//TODO @EnableBlockingRestClient

@Configuration
@ComponentScan
@Slf4j
public class BlockingRestClientAutoConfiguration {

  public BlockingRestClientAutoConfiguration() {
    log.debug("Loading BlockingRestClient");
  }

}
