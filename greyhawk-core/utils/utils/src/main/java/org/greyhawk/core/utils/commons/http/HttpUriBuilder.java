package org.greyhawk.core.utils.commons.http;

import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HttpUriBuilder {

  private String uri = "";
  private boolean hasUriParam = false;

  public HttpUriBuilder(final String uriPattern) {
    this.uri = uriPattern;
  }

  public HttpUriBuilder(final String uriPattern, final Object... params) {
    this.uri = uriPattern;
    uri = uri.replaceAll("\\{\\}", "%s");
    final String[] stringParams = Stream.of(params).map(p -> p.toString()).toArray(String[]::new);
    uri = String.format(uri, (Object[]) stringParams);
  }

  public HttpUriBuilder query(final String key) {
    return addQuery(key, null);
  }

  public HttpUriBuilder query(final String key, final Object val) {
    return addQuery(key, val);
  }

  protected HttpUriBuilder addQuery(final String key, final Object val) {
    final var paramValue = (null == val) ? "" : "=" + val.toString();
    addParam(key + paramValue);
    return this;
  }

  protected void addParam(final String uriParam) {
    uri += hasUriParam ? "&" : "?";
    uri += uriParam;
    hasUriParam = true;
  }

  public String build() {
    while (uri.contains("//")) {
      uri = uri.replaceAll("//", "/");
    }
    return uri;
  }

}