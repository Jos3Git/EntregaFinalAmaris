package org.greyhawk.utils.commons.http;

import org.greyhawk.core.utils.commons.http.HttpUriBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HttpUriBuilderTest {

  @Test
  void test() {
    Assertions.assertEquals("", new HttpUriBuilder("").build());
    Assertions.assertEquals("/", new HttpUriBuilder("/").build());

    Assertions.assertEquals("/123", new HttpUriBuilder("/{}", "123").build());
    Assertions.assertEquals("/55", new HttpUriBuilder("/{}", 55L).build());

    Assertions.assertEquals("/aa/123/customer/24/", new HttpUriBuilder("/aa/{}/customer/{}/", "123", "24").build());

    Assertions.assertEquals("/api?aa&bb=1&cc=14", new HttpUriBuilder("/api").query("aa").query("bb", "1").query("cc", 14L).build());

    Assertions.assertEquals("abc.com/orders/123", new HttpUriBuilder("abc.com///orders////123").build());
    Assertions.assertEquals("abc.com/orders/?page=17", new HttpUriBuilder("abc.com///orders///?page=17").build());
    Assertions.assertEquals("abc.com/orders?page=17", new HttpUriBuilder("abc.com///orders?page=17").build());

    Assertions.assertEquals("/abc.com/orders", new HttpUriBuilder("/abc.com///orders").build());
    Assertions.assertEquals("abc.com/orders?ggg", new HttpUriBuilder("abc.com/orders").query("ggg").build());

  }

}
