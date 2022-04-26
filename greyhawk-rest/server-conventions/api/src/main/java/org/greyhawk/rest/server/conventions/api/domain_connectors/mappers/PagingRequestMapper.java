package org.greyhawk.rest.server.conventions.api.domain_connectors.mappers;

import java.util.Optional;
import org.greyhawk.core.utils.domain.vos.paging.Paging;
import org.greyhawk.core.utils.domain.vos.sorting.Sorting;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PagingRequestMapper {

  private final SortingQueryParamDeserializer sortingDeser;

  public Paging paging(final Optional<Integer> pageNumber, final int pageDefault, final Optional<Integer> pageSize, final int sizeDefault) {
    final var paging = new Paging(pageNumber.orElse(pageDefault).intValue(), pageSize.orElse(sizeDefault).intValue());
    log.trace("Got paging. P={}. PD={}. PS={}. SD={}. Paging={}", pageNumber, pageDefault, pageSize, sizeDefault, paging);
    return paging;
  }

  public Sorting sorting(final Optional<String> sortParam) {
    return sorting(sortParam, null);
  }

  public Sorting sorting(final Optional<String> sortParam, final String sortingDefault) {
    final Optional<String> sort = sortParam.isEmpty() ? Optional.ofNullable(sortingDefault) : sortParam;
    final var sorting = sortingDeser.deserialize(sort);
    log.trace("Got sorting. Param={}. Default={}. Sorting={}", sortParam, sortingDefault, sorting);
    return sorting;
  }

}
