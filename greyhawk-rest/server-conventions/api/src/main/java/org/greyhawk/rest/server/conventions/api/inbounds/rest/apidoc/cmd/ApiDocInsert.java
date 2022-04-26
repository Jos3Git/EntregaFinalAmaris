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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ApiDocInsert {

  interface Response {
    interface Success {
      String SC = HttpStatusCodes.CREATED;
      String MSG = "Element has been inserted";
    }

    interface InvalidInputData extends ApiDocCommons.Error.InvalidInputData {
    }

    interface Conflict extends ApiDocCommons.Error.Conflict {
    }
  }

  @Operation(summary = "Inserts an element")
  @ApiResponses({ @ApiResponse(responseCode = Response.Success.SC, description = Response.Success.MSG) })
  @Retention(RetentionPolicy.RUNTIME)
  @interface Description {
  }

  interface Controller<Q, S> {
    @PostMapping(value = "/", consumes = ApiDocCommons.MEDIATYPE_REQUEST)
    @Description
    ResponseEntity<SimpleResponseDto<S>> insert(@Valid @RequestBody Q dto);
  }

  interface ControllerServletAccess<Q, S> {
    @PostMapping(value = "/", consumes = ApiDocCommons.MEDIATYPE_REQUEST)
    @Description
    ResponseEntity<SimpleResponseDto<S>> insert(@Valid @RequestBody Q dto, HttpServletRequest servletRequ, HttpServletResponse servletResp);
  }

}
