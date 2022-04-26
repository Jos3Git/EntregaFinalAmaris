package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.paged;

import java.util.List;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseDto;
import org.springframework.http.ResponseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PagedResponseDto<D> extends ResponseDto<PagedResponseMetaDto, List<D>> {

  public PagedResponseDto(final PagedResponseMetaDto meta, final List<D> response) {
    super(meta, response);
  }

  public static <D> ResponseEntity<PagedResponseDto<D>> success(final String sc, final PagedResponseDto<D> pagedResponse) {
    pagedResponse.getMeta().setStatus(sc);
    return ResponseEntity.status(Integer.parseInt(sc)).body(pagedResponse);
  }

}
