package org.greyhawk.core.testutils.commons;

import org.junit.jupiter.api.Assertions;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public abstract class BeanTester {

  public static <T> void test(final T obj) {
    testToString(obj);
    testAccessors(obj);
    testEquals(obj);
  }

  public static <T> void testToString(final T obj) {
    Assertions.assertNotNull(obj.toString());
  }

  public static <T> void testAccessors(final T obj) {
    ValidatorBuilder.create().with(new GetterTester()).with(new SetterTester()).build()
        .validate(PojoClassFactory.getPojoClass(obj.getClass()));
  }

  public static <T> void testEquals(final T obj) {
    EqualsVerifier.forClass(obj.getClass()).suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS, Warning.BIGDECIMAL_EQUALITY)
        .verify();
  }

}
