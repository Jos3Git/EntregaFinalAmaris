package org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc;

import org.greyhawk.rest.server.utils.commons.HttpStatusCodes;
import org.springframework.http.MediaType;

//TODO controllers vo validation

//TODO @ApiModelProperty no debe estar disponible en OrderRequestDto

//TODO OrderRequestDto: definir otro LocalDateTime con otro formato

//TODO SalesOrdersApiDocCommons ApiInfo - leer version de maven props

public interface ApiDocCommons {

  String MEDIATYPE_REQUEST = MediaType.APPLICATION_JSON_VALUE;
  String MEDIATYPE_RESPONSE = MediaType.APPLICATION_JSON_VALUE;

  interface Error {

    // Note we never throw a BadRequest

    interface NotFound {
      String SC = HttpStatusCodes.NOT_FOUND;
      String MSG = "Element has not been found";
    }

    interface InvalidInputData {
      String SC = HttpStatusCodes.UNPROCESSABLE_ENTITY;
      String MSG = "The request contains semantic errors";
    }

    interface Conflict {
      String SC = HttpStatusCodes.CONFLICT;
      String MSG = "The request can not be processed due to unmet preconditions";
    }

  }
}
