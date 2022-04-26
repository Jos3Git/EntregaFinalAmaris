package org.greyhawk.utils.domain.vos.paging;

import org.greyhawk.core.utils.domain.vos.paging.Paging;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PagingTest {

  @Test
  void test_basic_usage() {
    // when
    Paging paging = new Paging(2, 22);
    // then
    Assertions.assertEquals("Paging(p=2,s=22)", paging.toString());
  }

}
