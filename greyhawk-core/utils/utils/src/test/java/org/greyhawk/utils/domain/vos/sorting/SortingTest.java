package org.greyhawk.utils.domain.vos.sorting;

import org.greyhawk.core.utils.domain.vos.sorting.Sorting;
import org.greyhawk.core.utils.domain.vos.sorting.SortingCriteria;
import org.greyhawk.core.utils.domain.vos.sorting.SortingDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortingTest {

  @Test
  void test_basic_usage() {
    // when
    Sorting sorting = new Sorting();
    sorting.getCriteria().add(new SortingCriteria("name", SortingDirection.ASC));
    sorting.getCriteria().add(new SortingCriteria("type", SortingDirection.DESC));
    // then
    Assertions.assertTrue(sorting.containsField("name"));
    Assertions.assertFalse(sorting.containsField("name2"));
    Assertions.assertEquals("Sorting([name ASC, type DESC])", sorting.toString());
  }

}
