package org.greyhawk.rest.server.conventions.api.inbounds.rest.errorhandler;

import java.util.HashMap;
import java.util.Map;
import org.greyhawk.core.utils.domain.exceptions.DomainError;
import org.greyhawk.core.utils.domain.exceptions.RequestError;
import org.greyhawk.core.utils.domain.exceptions.ServiceError;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.ApiDocCommons;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class DomainExceptionsHandler implements SimpleResponseExceptionHandler {

  private static final Map<Class<?>, HttpStatus> SCS_MAPPING = buildMapping();

  protected static Map<Class<?>, HttpStatus> buildMapping() {
    final Map<Class<?>, HttpStatus> mapping = new HashMap<>();

    mapping.put(RequestError.BadRequestException.class, HttpStatus.BAD_REQUEST);

    mapping.put(RequestError.InvalidInputDataException.class, parseSc(ApiDocCommons.Error.InvalidInputData.SC));

    mapping.put(DomainError.ElementNotFoundException.class, parseSc(ApiDocCommons.Error.NotFound.SC));

    mapping.put(DomainError.ConflictException.class, parseSc(ApiDocCommons.Error.Conflict.SC));

    mapping.put(ServiceError.TemporaryException.class, HttpStatus.SERVICE_UNAVAILABLE);

    return mapping;
  }

  private static HttpStatus parseSc(final String sc) {
    return HttpStatus.valueOf(Integer.parseInt(sc));
  }

  @ExceptionHandler({ RequestError.BadRequestException.class, RequestError.InvalidInputDataException.class,
      DomainError.ElementNotFoundException.class, DomainError.ConflictException.class, ServiceError.TemporaryException.class })
  public final ResponseEntity<SimpleResponseDto<Void>> handleException(final Exception ex, final WebRequest request) throws Exception {
    final HttpStatus status = SCS_MAPPING.entrySet().stream().filter(e -> ex.getClass().isAssignableFrom(e.getKey())).map(e -> e.getValue())
        .findFirst().orElse(getUndefinedStatus(ex));
    return buildResponse(status, ex.toString());
  }

  private HttpStatus getUndefinedStatus(final Exception ex) {
    // TODO revisar. a veces entra aqui
    log.debug("Exception not defined: {}", ex.toString());
    return HttpStatus.INTERNAL_SERVER_ERROR;
  }

}