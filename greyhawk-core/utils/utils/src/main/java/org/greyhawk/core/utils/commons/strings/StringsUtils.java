package org.greyhawk.core.utils.commons.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringsUtils {

  /**
   *
   * Extension of Strings.split(), applying a trim() on each found splitted element.
   *
   */
  public List<String> splitTrimming(final String s, final String regex) {
    return Arrays.stream(s.split(regex)).map(String::trim).collect(Collectors.toList());
  }

}
