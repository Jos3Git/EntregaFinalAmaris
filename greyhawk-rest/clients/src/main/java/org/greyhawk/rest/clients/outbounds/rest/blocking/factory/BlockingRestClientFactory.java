package org.greyhawk.rest.clients.outbounds.rest.blocking.factory;

public interface BlockingRestClientFactory {

  BlockingRestClientBuilder builder();

  BlockingRestClientBuilder builderFromConfig(String configEntry);

}
