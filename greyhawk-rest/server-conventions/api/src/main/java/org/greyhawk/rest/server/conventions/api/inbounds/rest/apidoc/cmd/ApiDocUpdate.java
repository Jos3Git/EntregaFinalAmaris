package org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.ApiDocCommons;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.greyhawk.rest.server.utils.commons.HttpStatusCodes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ApiDocUpdate {

  String PARAM_ID = "ID of the element to be updated";

  interface Response {
    interface Success {
      String SC = HttpStatusCodes.OK;
      String MSG = "Element has been updated";
    }

    interface InvalidInputData extends ApiDocCommons.Error.InvalidInputData {
    }

    interface Conflict extends ApiDocCommons.Error.Conflict {
    }

    interface NotFound extends ApiDocCommons.Error.NotFound {
    }
  }

  @Operation(summary = "Updates an element")
  @ApiResponses({ @ApiResponse(responseCode = Response.Success.SC, description = Response.Success.MSG),
      @ApiResponse(responseCode = Response.NotFound.SC, description = Response.NotFound.MSG) })
  @Retention(RetentionPolicy.RUNTIME)
  @interface Description {
  }

  interface Controller<Q, S> {
    @PutMapping(value = "/{id}", consumes = ApiDocCommons.MEDIATYPE_REQUEST)
    @Description
    ResponseEntity<SimpleResponseDto<S>> update(@Parameter(description = PARAM_ID) @PathVariable(required = true) String id,
        @Valid @RequestBody Q dto);
  }

  interface ControllerServletAccess<Q, S> {
    @PutMapping(value = "/{id}", consumes = ApiDocCommons.MEDIATYPE_REQUEST)
    @Description
    ResponseEntity<SimpleResponseDto<S>> update(@Parameter(description = PARAM_ID) @PathVariable(required = true) String id,
        @Valid @RequestBody Q dto, HttpServletRequest servletRequ, HttpServletResponse servletResp);
  }

}
