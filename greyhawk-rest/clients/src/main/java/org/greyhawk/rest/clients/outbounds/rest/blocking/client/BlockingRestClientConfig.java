package org.greyhawk.rest.clients.outbounds.rest.blocking.client;

import java.util.Collections;
import java.util.Map;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.ToString;

@Data
public class BlockingRestClientConfig {

  @ToString.Exclude
  private final RestTemplate template;

  @ToString.Exclude
  private final ObjectMapper defaultRequestMapper;
  @ToString.Exclude
  private final ObjectMapper defaultResponseMapper;

  // application.yml
  // TODO ssl, timeouts, mas?
  private final String baseUrl;

  private final Map<String, String> defaultHeaders;

  public BlockingRestClientConfig(final RestTemplate restTemplate, final ObjectMapper requestMapper, final ObjectMapper responseMapper,
      final String url, final Map<String, String> headers) {
    Assert.notNull(restTemplate, "template null");
    this.template = restTemplate;
    this.defaultRequestMapper = requestMapper;
    this.defaultResponseMapper = responseMapper;
    Assert.hasLength(url, "url null");
    this.baseUrl = url.endsWith("/") ? url : url + "/";
    this.defaultHeaders = (CollectionUtils.isEmpty(headers)) ? null : Collections.unmodifiableMap(headers);
  }

}