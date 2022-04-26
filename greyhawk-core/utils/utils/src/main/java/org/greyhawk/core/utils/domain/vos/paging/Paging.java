package org.greyhawk.core.utils.domain.vos.paging;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Paging {

  private int page;
  private int size;

  @Override
  public String toString() {
    return "Paging(p=" + page + ",s=" + size + ")";
  }

}
