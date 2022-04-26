package org.greyhawk.rest.clients.outbounds.rest.blocking.executor;

import java.net.URI;

import org.greyhawk.rest.clients.outbounds.rest.blocking.BlockingRestClientResponse;
import org.greyhawk.rest.clients.outbounds.rest.blocking.request.BlockingRestClientRequestData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class BlockingRestClientExecutor<Q, S> {

  private final BlockingRestClientRequestData<Q, S> request;

  public BlockingRestClientResponse<S> execute() {
    // TODO logging
    log.debug("Executing. Request={}", request);
    final var entity = makeEntity(request.getPayload());

    if (request.getResponseMapper().isPresent()) {
      Assert.notNull(request.getResponseType(), "ResponseType missing");
      final var response = exchangeForString(request.getUrl(), request.getMethod(), entity);
      final S body = mapResponse(response.getBody(), request.getResponseType().getTypeRef());
      return new BlockingRestClientResponse<S>(body, response.getHeaders(), response.getStatusCode());
    } else {
      final ResponseEntity<S> response = exchange(request.getUrl(), request.getMethod(), entity, request.getResponseType().getTypeClass());
      return new BlockingRestClientResponse<S>(response.getBody(), response.getHeaders(), response.getStatusCode());
    }

  }

  protected ResponseEntity<String> exchangeForString(final URI url, final HttpMethod method, final HttpEntity<?> entity) {
//    try {
    return request.getTemplate().exchange(url, method, entity, String.class);
    // TODO log results
//    } catch (RestClientException e) {
//      log.error("Rest error", e);
//      // TODO throw BlockingRestException
//      throw e;
//    }
  }

  protected ResponseEntity<S> exchange(final URI url, final HttpMethod method, final HttpEntity<?> entity, final Class<S> clz) {
    return request.getTemplate().exchange(url, method, entity, clz);
    // TODO log results
  }

  protected HttpEntity<?> makeEntity(final Q payload) {
    final Object mapped = (request.getRequestMapper().isPresent()) ? mapRequest(payload) : payload;
    return new HttpEntity<>(mapped, request.getHeaders());
  }

  protected String mapRequest(final Q payload) {
    try {
      return request.getRequestMapper().get().writeValueAsString(payload);
    } catch (NullPointerException | JsonProcessingException e) {
      throw new RuntimeException("Error mapping request", e);
    }
  }

  protected S mapResponse(final String body, final TypeReference<S> typeRef) {
    try {
      return request.getRequestMapper().get().readValue(body, typeRef);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Error mapping response", e);
    }
  }

}