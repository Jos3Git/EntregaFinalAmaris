package org.greyhawk.rest.server.testutils.inbounds.rest.dtos;

import java.util.ArrayList;
import java.util.List;
import org.greyhawk.core.utils.domain.vos.pagedresponse.PagedResponse;
import org.greyhawk.core.utils.domain.vos.pagedresponse.PagingResults;

public class PagedResponseBuilder<S> {

  private final PagingResults results;
  private final List<S> data = new ArrayList<>();

  @SafeVarargs
  public PagedResponseBuilder(final long elements, final long totalElements, final int page, final int totalPages,
      final S... dataElements) {
    results = new PagingResults(elements, totalElements, page, totalPages);
    for (S el : dataElements) {
      data.add(el);
    }
  }

  public PagedResponse<S> build() {
    return new PagedResponse<>(results, data);
  }

}
