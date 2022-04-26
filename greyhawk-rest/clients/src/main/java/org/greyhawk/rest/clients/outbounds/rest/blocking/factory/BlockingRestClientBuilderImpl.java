package org.greyhawk.rest.clients.outbounds.rest.blocking.factory;

import java.util.HashMap;
import java.util.Map;

import org.greyhawk.rest.clients.outbounds.rest.blocking.BlockingRestClient;
import org.greyhawk.rest.clients.outbounds.rest.blocking.client.BlockingRestClientConfig;
import org.greyhawk.rest.clients.outbounds.rest.blocking.client.BlockingRestClientImpl;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BlockingRestClientBuilderImpl implements BlockingRestClientBuilder {

  private ObjectMapper requestMapper;
  private ObjectMapper responseMapper;
  private String baseUrl;
  private Map<String, String> headers = new HashMap<>();

  private RestTemplate template;

  public BlockingRestClientBuilderImpl(final RestTemplate defaultTemplate) {
    template(defaultTemplate);
  }

  public BlockingRestClientBuilderImpl(final RestTemplate defaultTemplate, final String configEntry) {
    this(defaultTemplate);
    loadConfig(configEntry);
  }

  protected void loadConfig(final String configEntry) {
    Assert.notNull(configEntry, "Config Entry name missing");
    // TODO load config: url, headers, mas
  }

  @Override
  public BlockingRestClientBuilder template(final RestTemplate restTemplate) {
    this.template = restTemplate;
    return this;
  }

  @Override
  public BlockingRestClientBuilder url(final String url) {
    this.baseUrl = url;
    return this;
  }

  @Override
  public BlockingRestClientBuilder header(final String key, final String vale) {
    this.headers.put(key, vale);
    return this;
  }

  @Override
  public BlockingRestClientBuilder requestMapper(final ObjectMapper mapper) {
    this.requestMapper = mapper;
    return this;
  }

  @Override
  public BlockingRestClientBuilder responseMapper(final ObjectMapper mapper) {
    this.responseMapper = mapper;
    return this;
  }

  @Override
  public BlockingRestClient build() {
    final BlockingRestClientConfig config = new BlockingRestClientConfig(template, requestMapper, responseMapper, baseUrl, headers);
    return new BlockingRestClientImpl(config);
  }

}
