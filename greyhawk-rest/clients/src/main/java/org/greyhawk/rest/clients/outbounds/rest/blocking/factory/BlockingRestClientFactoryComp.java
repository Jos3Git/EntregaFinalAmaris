package org.greyhawk.rest.clients.outbounds.rest.blocking.factory;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BlockingRestClientFactoryComp implements BlockingRestClientFactory {

  private static final RestTemplate DEFAULT_TEMPLATE = new RestTemplate();

  @Override
  public BlockingRestClientBuilder builder() {
    return new BlockingRestClientBuilderImpl(DEFAULT_TEMPLATE);
  }

  @Override
  public BlockingRestClientBuilder builderFromConfig(final String configEntry) {
    return new BlockingRestClientBuilderImpl(DEFAULT_TEMPLATE, configEntry);
  }

}
