package org.greyhawk.rest.server.conventions.api.domain_connectors.mappers;

import java.util.List;
import org.greyhawk.core.utils.domain.vos.pagedresponse.PagingResults;
import org.greyhawk.core.utils.domain.vos.paging.Paging;
import org.greyhawk.core.utils.domain.vos.sorting.Sorting;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.paged.PagedResponseDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.paged.PagedResponseMetaDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.paged.PagedResponseMetaPagingDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.paged.PagedResponseMetaRequestDto;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.PagingResponseMapper;
import org.greyhawk.rest.server.utils.inbounds.dtos.paging.PagingDto;
import org.greyhawk.rest.server.utils.inbounds.dtos.sorting.SortingDto;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PagedResponseMapper<S> {

  private final PagingResponseMapper pagingMapper;

  public PagedResponseDto<S> build(final Paging requPaging, final Sorting requSorting, final PagingResults pagingResults,
      final List<S> responseData) {

    PagingDto paging = pagingMapper.mapPaging(requPaging);
    SortingDto sorting = pagingMapper.mapSorting(requSorting);

    PagedResponseMetaRequestDto metaRequest = new PagedResponseMetaRequestDto(paging, sorting);

    PagedResponseMetaPagingDto metaPaging = new PagedResponseMetaPagingDto(pagingResults.getElements(), pagingResults.getTotalElements(),
        pagingResults.getPage(), pagingResults.getTotalPages());

    PagedResponseMetaDto metaData = new PagedResponseMetaDto(metaRequest, metaPaging);

    return new PagedResponseDto<S>(metaData, responseData);
  }

}
