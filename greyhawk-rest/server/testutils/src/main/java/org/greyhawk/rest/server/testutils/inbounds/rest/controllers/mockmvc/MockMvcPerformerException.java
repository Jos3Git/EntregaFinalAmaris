package org.greyhawk.rest.server.testutils.inbounds.rest.controllers.mockmvc;

@SuppressWarnings("serial")
public class MockMvcPerformerException extends RuntimeException {

  public MockMvcPerformerException(final Exception e) {
    super(e);
  }

}
