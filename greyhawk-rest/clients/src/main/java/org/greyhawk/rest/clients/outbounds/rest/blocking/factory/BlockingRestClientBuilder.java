package org.greyhawk.rest.clients.outbounds.rest.blocking.factory;

import org.greyhawk.rest.clients.outbounds.rest.blocking.BlockingRestClient;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface BlockingRestClientBuilder {

  BlockingRestClientBuilder url(String baseUrl);

  BlockingRestClientBuilder requestMapper(ObjectMapper mapper);

  BlockingRestClientBuilder responseMapper(ObjectMapper mapper);

  BlockingRestClientBuilder header(String key, String vale);

  BlockingRestClientBuilder template(RestTemplate template);

  BlockingRestClient build();

}
