package org.greyhawk.core.testutils.commons;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Assertions;

public abstract class AssertUtils {

  @FunctionalInterface
  public interface Runnable {
    void run() throws Exception;
  }

  public static <T> void assertException(final Runnable runnable, final Class<T> expectedException, final String expectedMsg) {
    try {
      runnable.run();
      fail("No exception thrown");
    } catch (Exception e) {
      if (e.getClass().isAssignableFrom(expectedException)) {
        Assertions.assertEquals(expectedMsg, e.getMessage());
      } else {
        fail("Unexpected exception thrown", e);
      }
    }
  }

}