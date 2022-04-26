package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto<M, D> {

  private M meta;
  private D data;

}
