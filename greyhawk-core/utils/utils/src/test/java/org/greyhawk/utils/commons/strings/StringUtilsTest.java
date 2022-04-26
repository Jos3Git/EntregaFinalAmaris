package org.greyhawk.utils.commons.strings;

import org.greyhawk.core.utils.commons.strings.StringsUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

  @Test
  void should_split() {
    Assertions.assertEquals("[a, b, c]", new StringsUtils().splitTrimming(" a , b , c", ",").toString());
    Assertions.assertEquals("[a]", new StringsUtils().splitTrimming("a", ",").toString());
  }

}
