package org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.query;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.ApiDocCommons;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.greyhawk.rest.server.utils.commons.HttpStatusCodes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ApiDocFindById {

  String PARAM_ID = "ID of the element to search for";

  interface Response {
    interface Success {
      String SC = HttpStatusCodes.OK;
      String MSG = "Element has been returned";
    }

    interface NotFound extends ApiDocCommons.Error.NotFound {
    }
  }

  @Operation(summary = "Finds an element by its ID")
  @ApiResponses({ @ApiResponse(responseCode = ApiDocFindById.Response.Success.SC, description = ApiDocFindById.Response.Success.MSG),
      @ApiResponse(responseCode = ApiDocFindById.Response.NotFound.SC, description = ApiDocFindById.Response.NotFound.MSG) })
  @Retention(RetentionPolicy.RUNTIME)
  @interface Description {
  }

  interface Controller<S> {
    @GetMapping(value = "/{id}")
    @Description
    ResponseEntity<SimpleResponseDto<S>> findById(@Parameter(description = PARAM_ID) @PathVariable(required = true) String id);
  }

  interface ControllerServletAccess<S> {
    @GetMapping(value = "/{id}")
    @Description
    ResponseEntity<SimpleResponseDto<S>> findById(@Parameter(description = PARAM_ID) @PathVariable(required = true) String id,
        HttpServletRequest servletRequ, HttpServletResponse servletResp);
  }

}
