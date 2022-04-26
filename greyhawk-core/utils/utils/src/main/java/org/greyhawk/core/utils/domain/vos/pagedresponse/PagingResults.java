package org.greyhawk.core.utils.domain.vos.pagedresponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PagingResults {

  private final long elements;
  private final long totalElements;
  private final int page;
  private final int totalPages;

}