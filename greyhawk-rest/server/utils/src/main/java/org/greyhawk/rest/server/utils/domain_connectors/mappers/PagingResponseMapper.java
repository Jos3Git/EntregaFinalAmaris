package org.greyhawk.rest.server.utils.domain_connectors.mappers;

import org.greyhawk.core.utils.domain.vos.paging.Paging;
import org.greyhawk.core.utils.domain.vos.sorting.Sorting;
import org.greyhawk.rest.server.utils.inbounds.dtos.paging.PagingDto;
import org.greyhawk.rest.server.utils.inbounds.dtos.sorting.SortingDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PagingResponseMapper {

  SortingDto mapSorting(Sorting requSorting);

  PagingDto mapPaging(Paging requPaging);

}
