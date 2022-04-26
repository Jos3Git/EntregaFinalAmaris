package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder
public class ResponseMetaErrorDetailsDto {

  private final String field;
  private final String errorCode;
  private final String errorMsg;
  private final String[] errorParams;

}
