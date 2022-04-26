package org.greyhawk.rest.server.conventions.testutils.inbounds.rest.tests;

import java.util.Map;

import org.greyhawk.rest.server.conventions.api.domain_connectors.mappers.PagingRequestMapper;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.formats.SortingQueryParamFormat;
import org.greyhawk.rest.server.testutils.inbounds.rest.controllers.mockmvc.MockMvcBase;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.PagingResponseMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.MediaType;

import lombok.Getter;

public abstract class MockMvcTest extends MockMvcBase {

  @Getter
  private final PagingRequestMapper pagingRequestMapper = new PagingRequestMapper(new SortingQueryParamFormat.Deserializer());

  @Getter
  private final PagingResponseMapper pagingResponseMapper = Mappers.getMapper(PagingResponseMapper.class);

  @Override
  @SuppressWarnings("deprecation")
  protected Map<String, String> buildDefaultHeaders() {
    return Map.ofEntries(Map.entry("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE),
        Map.entry("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE));
  }

}