package org.greyhawk.rest.clients.outbounds.rest.blocking.client;

import org.greyhawk.core.utils.commons.json.ClassTypeRef;
import org.greyhawk.rest.clients.outbounds.rest.blocking.BlockingRestClient;
import org.greyhawk.rest.clients.outbounds.rest.blocking.BlockingRestClientRequestBuilder;
import org.greyhawk.rest.clients.outbounds.rest.blocking.request.BlockingRestClientRequestBuilderImpl;
import org.springframework.http.HttpMethod;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BlockingRestClientImpl implements BlockingRestClient {

  private final BlockingRestClientConfig config;

  protected <Q, S> S execute(final BlockingRestClientRequestBuilderImpl<Q, S> bldr) {
    return bldr.execute().getBody();
  }

  // TODO PATCH, POST, etc

  @Override
  public String get(final String uri) {
    return execute(
        new BlockingRestClientRequestBuilderImpl<Void, String>(config).uri(uri).method(HttpMethod.GET).responseType(STRING_TYPE));
  }

  @Override
  public <S> S get(final String uri, final ClassTypeRef<S> responseType) {
    return execute(new BlockingRestClientRequestBuilderImpl<Void, S>(config).uri(uri).method(HttpMethod.GET).responseType(responseType));
  }

  @Override
  public void delete(final String uri) {
    execute(new BlockingRestClientRequestBuilderImpl<Void, String>(config).uri(uri).method(HttpMethod.DELETE).responseType(STRING_TYPE));
  }

  @Override
  public String put(final String uri) {
    return execute(
        new BlockingRestClientRequestBuilderImpl<Void, String>(config).uri(uri).method(HttpMethod.PUT).responseType(STRING_TYPE));
  }

  @Override
  public <Q> String put(final String uri, final Q request) {
    return execute(new BlockingRestClientRequestBuilderImpl<Q, String>(config).uri(uri).method(HttpMethod.PUT).responseType(STRING_TYPE)
        .payload(request));
  }

  @Override
  public <S> S put(final String uri, final ClassTypeRef<S> responseType) {
    return execute(new BlockingRestClientRequestBuilderImpl<Void, S>(config).uri(uri).method(HttpMethod.PUT).responseType(responseType));
  }

  @Override
  public <Q, S> S put(final String uri, final Q request, final ClassTypeRef<S> responseType) {
    return execute(
        new BlockingRestClientRequestBuilderImpl<Q, S>(config).uri(uri).method(HttpMethod.PUT).payload(request).responseType(responseType));
  }

  @Override
  public <Q> BlockingRestClientRequestBuilder<Q, String> custom() {
    return new BlockingRestClientRequestBuilderImpl<Q, String>(config);
  }

  @Override
  public <Q, S> BlockingRestClientRequestBuilder<Q, S> custom(final ClassTypeRef<S> responseType) {
    return new BlockingRestClientRequestBuilderImpl<Q, S>(config).responseType(responseType);
  }

}