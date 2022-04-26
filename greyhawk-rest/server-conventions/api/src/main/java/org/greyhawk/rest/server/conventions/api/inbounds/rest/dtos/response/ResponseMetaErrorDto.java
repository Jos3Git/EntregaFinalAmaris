package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder
public class ResponseMetaErrorDto {

  private String message;
  private List<ResponseMetaErrorDetailsDto> details;

}
