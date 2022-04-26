package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.paged;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagedResponseMetaPagingDto {

  private long elements;
  private long totalElements;
  private int page;
  private int totalPages;

}
