package org.greyhawk.rest.conventions.api.domain_connectors.mappers;

import java.util.Arrays;
import java.util.List;

import org.greyhawk.core.utils.domain.vos.pagedresponse.PagingResults;
import org.greyhawk.core.utils.domain.vos.paging.Paging;
import org.greyhawk.core.utils.domain.vos.sorting.Sorting;
import org.greyhawk.core.utils.domain.vos.sorting.SortingCriteria;
import org.greyhawk.core.utils.domain.vos.sorting.SortingDirection;
import org.greyhawk.rest.server.conventions.api.domain_connectors.mappers.PagedResponseMapper;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.PagingResponseMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class PagedResponseMapperTest {

  private PagingResponseMapper pagingMapper = Mappers.getMapper(PagingResponseMapper.class);

  @Test
  void should_build() {
    Paging paging = new Paging(3, 44);
    Sorting sorting = new Sorting();
    sorting.getCriteria().add(new SortingCriteria("name", SortingDirection.DESC));
    PagingResults response = new PagingResults(1, 10, 3, 12);
    List<Long> responseData = Arrays.asList(1L, 22L, 333L);

    Assertions.assertEquals(
        "PagedResponseDto(super=ResponseDto(meta=PagedResponseMetaDto(super=ResponseMetaDto(status=null, error=null), "
            + "request=PagedResponseMetaRequestDto(paging=PagingDto(page=3, size=44), "
            + "sorting=SortingDto(criteria=[SortingDtoCriteria(field=name, direction=DESC)])), "
            + "paging=PagedResponseMetaPagingDto(elements=1, totalElements=10, page=3, totalPages=12)), " + "data=[1, 22, 333]))",
        new PagedResponseMapper<Long>(pagingMapper).build(paging, sorting, response, responseData).toString());

  }

}
