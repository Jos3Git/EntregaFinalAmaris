package org.greyhawk.rest.server.utils.inbounds.dtos.sorting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class SortingDtoCriteria {

  private String field;
  private SortingDtoDirection direction;

}
