package org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.ApiDocCommons;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.greyhawk.rest.server.utils.commons.HttpStatusCodes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ApiDocDelete {

  String PARAM_ID = "ID of the element to be deleted";

  interface Response {
    interface Success {
      String SC = HttpStatusCodes.OK;
      String MSG = "Element has been deleted";
    }

    // Note we never return 404

    interface InvalidInputData extends ApiDocCommons.Error.InvalidInputData {
    }

    interface Conflict extends ApiDocCommons.Error.Conflict {
    }
  }

  @Operation(summary = "Deletes an element")
  @ApiResponses({ @ApiResponse(responseCode = Response.Success.SC, description = Response.Success.MSG) })
  @Retention(RetentionPolicy.RUNTIME)
  @interface Description {
  }

  interface Controller<S> {
    @DeleteMapping(value = "/{id}")
    @Description
    ResponseEntity<SimpleResponseDto<Void>> delete(@Parameter(description = PARAM_ID) @PathVariable(required = true) String id);
  }

  interface ControllerServletAccess<S> {
    @DeleteMapping(value = "/{id}")
    @Description
    ResponseEntity<SimpleResponseDto<Void>> delete(@Parameter(description = PARAM_ID) @PathVariable(required = true) String id,
        HttpServletRequest servletRequ, HttpServletResponse servletResp);
  }

}
