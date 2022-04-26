package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.paged;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class PagedResponseMetaDto extends ResponseMetaDto {

  private PagedResponseMetaRequestDto request;
  private PagedResponseMetaPagingDto paging;

}
