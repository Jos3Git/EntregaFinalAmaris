package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder
public class ResponseMetaDto {

  @ToString.Exclude
  @Builder.Default
  private Instant timestamp = Instant.now();
  private String status;
  private ResponseMetaErrorDto error;

}
