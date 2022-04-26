package org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.query;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.ApiDocCommons;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.paged.PagedResponseDto;
import org.greyhawk.rest.server.utils.commons.HttpStatusCodes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ApiDocList {

  String PARAM_PAGE = "Page";
  String PARAM_PAGE_SIZE = "Page size";
  String PARAM_SORT = "Sort";
  String PAGE_DEFAULT = "1";
  int PAGE_DEFAULT_VAL = 1;
  String PAGE_SIZE_DEFAULT = "20";
  int PAGE_SIZE_DEFAULT_VAL = 20;

  interface Response {
    interface Success {
      String SC = HttpStatusCodes.OK;
      String MSG = "Element has been returned";
    }

    interface InvalidInputData extends ApiDocCommons.Error.InvalidInputData {
    }
  }

  @Operation(summary = "Lists all elements")
  @ApiResponses({ @ApiResponse(responseCode = ApiDocList.Response.Success.SC, description = ApiDocList.Response.Success.MSG) })
  @Retention(RetentionPolicy.RUNTIME)
  @interface Description {
  }

  interface Controller<S> {
    @GetMapping(value = "/")
    @Description
    ResponseEntity<PagedResponseDto<S>> listAll(
        @Parameter(description = PARAM_PAGE, schema = @Schema(defaultValue = PAGE_DEFAULT)) Optional<Integer> page,
        @Parameter(description = PARAM_PAGE_SIZE, schema = @Schema(defaultValue = PAGE_SIZE_DEFAULT)) Optional<Integer> size,
        @Parameter(description = PARAM_SORT) Optional<String> sort);
  }

  interface ControllerServletAccess<S> {
    @GetMapping(value = "/")
    @Description
    ResponseEntity<PagedResponseDto<S>> listAll(
        @Parameter(description = PARAM_PAGE, schema = @Schema(defaultValue = PAGE_DEFAULT)) Optional<Integer> page,
        @Parameter(description = PARAM_PAGE_SIZE, schema = @Schema(defaultValue = PAGE_SIZE_DEFAULT)) Optional<Integer> size,
        @Parameter(description = PARAM_SORT) Optional<String> sort, HttpServletRequest servletRequ, HttpServletResponse servletResp);
  }

}
