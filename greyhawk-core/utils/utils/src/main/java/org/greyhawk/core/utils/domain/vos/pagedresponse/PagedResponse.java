package org.greyhawk.core.utils.domain.vos.pagedresponse;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class PagedResponse<T> {

  private final PagingResults pagingResults;

  @ToString.Exclude
  private final List<T> results;

}
