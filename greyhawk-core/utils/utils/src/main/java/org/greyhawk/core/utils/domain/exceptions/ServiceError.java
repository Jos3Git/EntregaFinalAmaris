package org.greyhawk.core.utils.domain.exceptions;

@SuppressWarnings("serial")
public interface ServiceError {

  /**
   * 
   * Represents an error caused by a temporary technical problem<br>
   * The same requested may and should work fine in the future.
   * 
   * Example: a database connection timeout
   *
   **/
  class TemporaryException extends RuntimeException {
    public TemporaryException(final String msg) {
      super(msg);
    }
  }

}