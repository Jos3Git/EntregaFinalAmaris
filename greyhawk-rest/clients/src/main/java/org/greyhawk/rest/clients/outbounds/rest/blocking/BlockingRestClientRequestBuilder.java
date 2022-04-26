package org.greyhawk.rest.clients.outbounds.rest.blocking;

import org.greyhawk.core.utils.commons.json.ClassTypeRef;
import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface BlockingRestClientRequestBuilder<Q, S> {

  BlockingRestClientRequestBuilder<Q, S> method(HttpMethod methos);

  BlockingRestClientRequestBuilder<Q, S> uri(String uri);

  BlockingRestClientRequestBuilder<Q, S> header(String key, String value);

  BlockingRestClientRequestBuilder<Q, S> payload(Q payload);

  BlockingRestClientRequestBuilder<Q, S> requestMapper(ObjectMapper mapper);

  BlockingRestClientRequestBuilder<Q, S> responseType(ClassTypeRef<S> type);

  BlockingRestClientRequestBuilder<Q, S> responseMapper(ObjectMapper mapper);

  BlockingRestClientResponse<S> execute();

}
