package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.configuration;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.formats.RestJsonMapperBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class RestDtosConfiguration {

  /**
   *
   * Jackson Mapper for request and response mappings in REST controllers.
   *
   */
  @Bean
  public MappingJackson2HttpMessageConverter restJsonMapper() {
    log.debug("Creating default REST JSON mapper bean");
    return new MappingJackson2HttpMessageConverter(new RestJsonMapperBuilder().getMapper());
  }

}