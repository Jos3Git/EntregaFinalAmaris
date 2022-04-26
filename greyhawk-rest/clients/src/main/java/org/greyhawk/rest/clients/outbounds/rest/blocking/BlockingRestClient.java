package org.greyhawk.rest.clients.outbounds.rest.blocking;

import org.greyhawk.core.utils.commons.json.ClassTypeRef;

public interface BlockingRestClient {

  ClassTypeRef<String> STRING_TYPE = new ClassTypeRef<>(String.class, null);

  String get(String uri);
  <S> S get(String uri, ClassTypeRef<S> responseType);

  void delete(String uri);

  String put(String uri);
  <Q> String put(String uri, Q request);
  <S> S put(String uri, ClassTypeRef<S> responseType);
  <Q, S> S put(String uri, Q request, ClassTypeRef<S> responseType);

  <Q> BlockingRestClientRequestBuilder<Q, String> custom();
  <Q, S> BlockingRestClientRequestBuilder<Q, S> custom(ClassTypeRef<S> responseType);

}