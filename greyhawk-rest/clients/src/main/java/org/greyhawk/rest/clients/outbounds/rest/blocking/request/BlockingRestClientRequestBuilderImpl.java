package org.greyhawk.rest.clients.outbounds.rest.blocking.request;

import java.net.URI;
import java.net.URISyntaxException;

import org.greyhawk.core.utils.commons.json.ClassTypeRef;
import org.greyhawk.rest.clients.outbounds.rest.blocking.BlockingRestClientRequestBuilder;
import org.greyhawk.rest.clients.outbounds.rest.blocking.BlockingRestClientResponse;
import org.greyhawk.rest.clients.outbounds.rest.blocking.client.BlockingRestClientConfig;
import org.greyhawk.rest.clients.outbounds.rest.blocking.executor.BlockingRestClientExecutor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BlockingRestClientRequestBuilderImpl<Q, S> implements BlockingRestClientRequestBuilder<Q, S> {

  private final BlockingRestClientConfig config;

  private String uri;
  private HttpMethod method;
  private MultiValueMap<String, String> headers = new HttpHeaders();
  private ObjectMapper requestMapper;
  private Q payload;
  private ObjectMapper responseMapper;
  private ClassTypeRef<S> responseType;

  @Override
  public BlockingRestClientRequestBuilderImpl<Q, S> method(final HttpMethod httpMethod) {
    this.method = httpMethod;
    return this;
  }

  @Override
  public BlockingRestClientRequestBuilderImpl<Q, S> uri(final String requUri) {
    this.uri = requUri;
    return this;
  }

  @Override
  public BlockingRestClientRequestBuilderImpl<Q, S> header(final String key, final String value) {
    this.headers.add(key, value);
    return this;
  }

  @Override
  public BlockingRestClientRequestBuilderImpl<Q, S> requestMapper(final ObjectMapper mapper) {
    this.requestMapper = mapper;
    return this;
  }

  @Override
  public BlockingRestClientRequestBuilderImpl<Q, S> payload(final Q requPayload) {
    this.payload = requPayload;
    return this;
  }

  @Override
  public BlockingRestClientRequestBuilderImpl<Q, S> responseType(final ClassTypeRef<S> typeRef) {
    this.responseType = typeRef;
    return this;
  }

  @Override
  public BlockingRestClientRequestBuilderImpl<Q, S> responseMapper(final ObjectMapper mapper) {
    this.responseMapper = mapper;
    return this;
  }

  @Override
  public BlockingRestClientResponse<S> execute() {
    final var request = buildRequest();
    return execute(request);
  }

  protected BlockingRestClientRequestData<Q, S> buildRequest() {
    return new BlockingRestClientRequestData<>(config.getTemplate(), buildUrl(), method, buildHeaders(), buildRequestMapper(), payload,
        responseType, buildResponseMapper());
  }

  protected MultiValueMap<String, String> buildHeaders() {
    final var headerMap = new HttpHeaders();
    if (null != config.getDefaultHeaders()) {
      config.getDefaultHeaders().forEach(headerMap::add);
    }
    if (null != headers) {
      headerMap.addAll(headers);
    }
    return headerMap;
  }

  protected URI buildUrl() {
    try {
      String cleanUri = StringUtils.hasLength(uri) ? uri : "";
      cleanUri = cleanUri.startsWith("/") ? cleanUri.substring(1) : cleanUri;
      return new URI(config.getBaseUrl() + cleanUri);
    } catch (

    URISyntaxException e) {
      throw new RuntimeException("Error building URL", e);
    }
  }

  protected ObjectMapper buildResponseMapper() {
    if (null == responseMapper) {
      return responseMapper;
    }
    return config.getDefaultResponseMapper();
  }

  protected ObjectMapper buildRequestMapper() {
    if (null == requestMapper) {
      return requestMapper;
    }
    return config.getDefaultRequestMapper();
  }

  protected BlockingRestClientResponse<S> execute(final BlockingRestClientRequestData<Q, S> request) {
    return new BlockingRestClientExecutor<>(request).execute();
  }

}
