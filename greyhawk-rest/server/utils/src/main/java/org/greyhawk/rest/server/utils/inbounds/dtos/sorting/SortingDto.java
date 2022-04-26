package org.greyhawk.rest.server.utils.inbounds.dtos.sorting;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SortingDto {

  private List<SortingDtoCriteria> criteria;

}
