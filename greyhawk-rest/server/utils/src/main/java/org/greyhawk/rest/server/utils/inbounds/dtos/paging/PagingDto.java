package org.greyhawk.rest.server.utils.inbounds.dtos.paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class PagingDto {

  private int page;
  private int size;

}
