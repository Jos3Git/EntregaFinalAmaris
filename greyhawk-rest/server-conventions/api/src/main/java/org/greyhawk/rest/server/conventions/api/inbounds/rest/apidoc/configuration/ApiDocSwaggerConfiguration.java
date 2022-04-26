package org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Slf4j
public class ApiDocSwaggerConfiguration {

  @Bean
  @ConditionalOnMissingBean(Docket.class)
  public Docket docket(final ApiInfo apiInfo) {
    log.debug("Creating default Swagger docket bean");
    final var docket = new Docket(DocumentationType.SWAGGER_2);
    docket.apiInfo(apiInfo);
    docket.select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any()).build();
    return docket;
  }

  @Bean
  @ConditionalOnMissingBean(ApiInfo.class)
  public ApiInfo apiInfo() {
    log.debug("Creating default Swagger ApiInfo bean");
    return ApiInfo.DEFAULT;
  }

}
