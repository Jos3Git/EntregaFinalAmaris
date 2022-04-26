package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.paged;

import org.greyhawk.rest.server.utils.inbounds.dtos.paging.PagingDto;
import org.greyhawk.rest.server.utils.inbounds.dtos.sorting.SortingDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagedResponseMetaRequestDto {

  private PagingDto paging;
  private SortingDto sorting;

}
