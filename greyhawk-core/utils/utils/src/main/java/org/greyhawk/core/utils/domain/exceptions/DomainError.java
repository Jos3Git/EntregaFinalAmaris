package org.greyhawk.core.utils.domain.exceptions;

@SuppressWarnings("serial")
public interface DomainError {

  /**
   * 
   * The requested resource could not be found.<br>
   * The same requested may work fine in the future.
   * 
   */
  class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(final String msg) {
      super(msg);
    }
  }

  /**
   * 
   * The request is valid, but it can't be processed due to unmet conditions.<br>
   * This is related with the current state of data, and not a system error<br>
   * The same requested may work fine in the future.
   * 
   * Example:<br>
   * - we try to insert an object, but a required related object does not (yet) exist<br>
   * 
   */
  class ConflictException extends RuntimeException {
    public ConflictException(final String msg) {
      super(msg);
    }
  }

}