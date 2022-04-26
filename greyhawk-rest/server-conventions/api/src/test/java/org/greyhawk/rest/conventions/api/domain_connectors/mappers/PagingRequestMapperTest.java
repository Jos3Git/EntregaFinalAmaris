package org.greyhawk.rest.conventions.api.domain_connectors.mappers;

import java.util.Optional;

import org.greyhawk.rest.server.conventions.api.domain_connectors.mappers.PagingRequestMapper;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.formats.SortingQueryParamFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PagingRequestMapperTest {

  private PagingRequestMapper mapper = new PagingRequestMapper(new SortingQueryParamFormat.Deserializer());

  @Test
  void should_map_paging() {
    Assertions.assertEquals("Paging(p=1,s=3)", mapper.paging(Optional.of(1), 2, Optional.of(3), 5).toString());
    Assertions.assertEquals("Paging(p=2,s=5)", mapper.paging(Optional.empty(), 2, Optional.empty(), 5).toString());
  }

  @Test
  void should_map_sorting() {
    Assertions.assertEquals("Sorting([name ASC, price DESC])", mapper.sorting(Optional.of("name:a,price:d")).toString());
    Assertions.assertEquals("Sorting([])", mapper.sorting(Optional.empty()).toString());
    Assertions.assertEquals("Sorting([name ASC, price ASC])", mapper.sorting(Optional.empty(), "name,price").toString());
  }

}
