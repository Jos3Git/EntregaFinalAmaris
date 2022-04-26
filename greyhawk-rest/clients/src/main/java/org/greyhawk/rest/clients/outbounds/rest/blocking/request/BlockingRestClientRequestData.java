package org.greyhawk.rest.clients.outbounds.rest.blocking.request;

import java.net.URI;
import java.util.Optional;

import org.greyhawk.core.utils.commons.json.ClassTypeRef;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.ToString;

@Data
public class BlockingRestClientRequestData<Q, S> {

  @ToString.Exclude
  private final RestTemplate template;
  private final URI url;
  private final HttpMethod method;
  private final MultiValueMap<String, String> headers;
  @ToString.Exclude
  private final Optional<ObjectMapper> requestMapper;
  @ToString.Exclude
  private final Q payload;
  @ToString.Exclude
  private final Optional<ObjectMapper> responseMapper;
  private final ClassTypeRef<S> responseType;

  // TODO toString. payload size, hasmapper si/no

  @SuppressWarnings("checkstyle:ParameterNumber")
  public BlockingRestClientRequestData(final RestTemplate restTemplate, final URI fullUrl, final HttpMethod httpMethod,
      final @Nullable MultiValueMap<String, String> requHeaders, final @Nullable ObjectMapper requMapper, final @Nullable Q requPayload,
      final ClassTypeRef<S> respType, final @Nullable ObjectMapper respMapper) {

    Assert.notNull(restTemplate, "Template missing");
    this.template = restTemplate;

    Assert.notNull(fullUrl, "fullUrl missing");
    this.url = fullUrl;

    Assert.notNull(httpMethod, "HttpMethod missing");
    this.method = httpMethod;

    this.headers = (CollectionUtils.isEmpty(requHeaders)) ? null : CollectionUtils.unmodifiableMultiValueMap(requHeaders);

    this.requestMapper = Optional.ofNullable(requMapper);
    this.payload = requPayload;

    Assert.notNull(respType, "RespType missing");
    this.responseType = respType;
    this.responseMapper = Optional.ofNullable(respMapper);
  }

}