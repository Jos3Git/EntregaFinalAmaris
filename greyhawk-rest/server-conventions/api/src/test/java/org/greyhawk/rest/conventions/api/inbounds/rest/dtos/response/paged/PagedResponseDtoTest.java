package org.greyhawk.rest.conventions.api.inbounds.rest.dtos.response.paged;

import java.util.Arrays;
import java.util.List;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.paged.PagedResponseDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.paged.PagedResponseMetaDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.paged.PagedResponseMetaPagingDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.paged.PagedResponseMetaRequestDto;
import org.greyhawk.rest.server.testutils.inbounds.rest.dtos.RestDtoTester;
import org.greyhawk.rest.server.utils.inbounds.dtos.paging.PagingDto;
import org.greyhawk.rest.server.utils.inbounds.dtos.sorting.SortingDto;
import org.greyhawk.rest.server.utils.inbounds.dtos.sorting.SortingDtoCriteria;
import org.greyhawk.rest.server.utils.inbounds.dtos.sorting.SortingDtoDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;

class PagedResponseDtoTest {

  @Test
  void test_dto() {
    PagedResponseMetaRequestDto requ = new PagedResponseMetaRequestDto(new PagingDto(2, 33),
        new SortingDto(Arrays.asList(new SortingDtoCriteria("name", SortingDtoDirection.DESC))));
    PagedResponseMetaPagingDto pagedResponse = new PagedResponseMetaPagingDto(1, 22, 3, 4);
    PagedResponseMetaDto meta = new PagedResponseMetaDto(requ, pagedResponse);
    List<String> resp = Arrays.asList("a", "b", "c");
    final var dto = new PagedResponseDto<String>(meta, resp);

    RestDtoTester.test(dto, new TypeReference<PagedResponseDto<String>>() {
    });
  }

  @Test
  void should_build_success() {
    PagedResponseMetaRequestDto requ = new PagedResponseMetaRequestDto(new PagingDto(2, 33),
        new SortingDto(Arrays.asList(new SortingDtoCriteria("name", SortingDtoDirection.DESC))));
    PagedResponseMetaPagingDto pagedResponse = new PagedResponseMetaPagingDto(1, 22, 3, 4);
    PagedResponseMetaDto meta = new PagedResponseMetaDto(requ, pagedResponse);
    List<String> resp = Arrays.asList("a", "b", "c");
    final var dto = new PagedResponseDto<String>(meta, resp);

    Assertions.assertEquals(
        "<201,PagedResponseDto(super=ResponseDto(meta=PagedResponseMetaDto(super=ResponseMetaDto(status=201, error=null), "
            + "request=PagedResponseMetaRequestDto(paging=PagingDto(page=2, size=33), "
            + "sorting=SortingDto(criteria=[SortingDtoCriteria(field=name, direction=DESC)])), "
            + "paging=PagedResponseMetaPagingDto(elements=1, totalElements=22, page=3, totalPages=4)), data=[a, b, c])),[]>",
        PagedResponseDto.success("201", dto).toString());
  }

}
