package org.greyhawk.core.utils.domain.vos.sorting;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public final class Sorting {

  private List<SortingCriteria> criteria = new ArrayList<>();

  @Override
  public String toString() {
    return "Sorting(" + criteria.toString() + ")";
  }

  public boolean containsField(final String field) {
    return criteria.stream().filter(c -> c.getField().equals(field)).findAny().isPresent();
  }

}
