package org.greyhawk.rest.conventions.api.inbounds.rest.dtos.formats;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.greyhawk.core.utils.commons.functions.ThrowingRunnable;
import org.greyhawk.core.utils.domain.exceptions.RequestError.InvalidInputDataException;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.formats.SortingQueryParamFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortingQueryParamFormatTest {

  private SortingQueryParamFormat.Deserializer deser = new SortingQueryParamFormat.Deserializer();

  @Test
  void should_deserialze_correctly() {
    assertDeserOpt(null, "Sorting([])");
    assertDeserOpt(Optional.empty(), "Sorting([])");

    assertDeser("name", "Sorting([name ASC])");
    assertDeser("name:", "Sorting([name ASC])");
    assertDeser("name:a", "Sorting([name ASC])");
    assertDeser("name:d", "Sorting([name DESC])");
    assertDeser(" name:a", "Sorting([name ASC])");
    assertDeser("name:a ", "Sorting([name ASC])");

    assertDeser("NAme:A", "Sorting([name ASC])");

    assertError(" name :a", "Parameter contains spaces", "[ name :a]");
    assertError("name :a", "Parameter contains spaces", "[name :a]");
    assertError("na me:a", "Parameter contains spaces", "[na me:a]");
    assertError("name: a", "Parameter contains spaces", "[name: a]");
    assertError("name:a a", "Parameter contains spaces", "[name:a a]");

    assertError("name:x", "Invalid direction", "[x]");
    assertError("name:aa ", "Invalid direction", "[aa]");

    assertError("name:a, type:d", "Parameter contains spaces", "[name:a, type:d]");
    assertError("name:a,type :d", "Parameter contains spaces", "[name:a,type :d]");
    assertError("name: a,type :d", "Parameter contains spaces", "[name: a,type :d]");
    assertError("name:a, type : d", "Parameter contains spaces", "[name:a, type : d]");

    assertDeser("name:a,type:d", "Sorting([name ASC, type DESC])");
    assertDeser("name,type:d", "Sorting([name ASC, type DESC])");
    assertDeser("name:,type:d", "Sorting([name ASC, type DESC])");
    assertDeser("name:d,type:d", "Sorting([name DESC, type DESC])");

    assertDeser("name:a,type", "Sorting([name ASC, type ASC])");
    assertDeser("name:a,type:", "Sorting([name ASC, type ASC])");
    assertDeser("name:a,type:d", "Sorting([name ASC, type DESC])");

    assertDeser("name,type,date", "Sorting([name ASC, type ASC, date ASC])");

    assertError("name:a,name:d", "Duplicated parameter", "[name]");
  }

  private void assertDeser(final String sort, final String expected) {
    assertDeserOpt(Optional.of(sort), expected);
  }

  private void assertDeserOpt(final Optional<String> sort, final String expected) {
    final var resp = deser.deserialize(sort);
    Assertions.assertEquals(expected, resp.toString());
  }

  private void assertError(final String sort, final String error, final String params) {
    assertInvalidSortException(() -> deser.deserialize(Optional.of(sort)), String.format(
        "org.greyhawk.core.utils.domain.exceptions.RequestError$InvalidInputDataException: Sort parameter. Code=%s. Field=null. Params=%s",
        error, params));
  }

  private void assertInvalidSortException(final ThrowingRunnable runnable, final String expectedMsg) {
    try {
      runnable.run();
      fail("No exception thrown");
    } catch (InvalidInputDataException e) {
      Assertions.assertEquals(expectedMsg, e.toString());
    } catch (Exception e) {
      fail("Unexpected exception thrown");
    }
  }

}
