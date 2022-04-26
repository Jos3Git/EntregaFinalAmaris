package org.greyhawk.rest.clients.outbounds.rest.blocking;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BlockingRestClientResponse<S> {

  private final S body;
  private final HttpHeaders headers;
  private final HttpStatus status;

}
