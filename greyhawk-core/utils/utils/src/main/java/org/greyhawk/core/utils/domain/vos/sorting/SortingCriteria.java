package org.greyhawk.core.utils.domain.vos.sorting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class SortingCriteria {

  private String field;
  private SortingDirection direction;

  @Override
  public String toString() {
    return field + " " + direction;
  }

}
