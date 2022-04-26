package org.greyhawk.core.utils.domain.exceptions;

import java.util.Arrays;
import lombok.Getter;

@SuppressWarnings("serial")
public interface RequestError {

  /**
   * 
   * The server can't process the request due to an apparent client error<br>
   * 
   * Examples:<br>
   * - malformed request syntax<br>
   * - size too large<br>
   * - call to a unexisting endpoint<br>
   *
   **/
  class BadRequestException extends RuntimeException {
    public BadRequestException(final String msg) {
      super(msg);
    }
  }

  /**
   * 
   * The request was well-formed but was unable to be followed due to semantic errors, i.e. it did not pass data validation
   * 
   * Examples:<br>
   * - a mandatory field is null<br>
   * - an email field has an invalid format
   *
   **/
  @Getter
  class InvalidInputDataException extends RuntimeException {
    private final String field;
    private final String code;
    private final String[] params;

    public InvalidInputDataException(final String msg, final String errorCode, final String errorField, final String... errorParams) {
      super(msg);
      this.field = errorField;
      this.code = errorCode;
      this.params = errorParams;
    }

    @Override
    public String getMessage() {
      return String.format("%s. Code=%s. Field=%s. Params=%s", super.getMessage(), code, field, Arrays.toString(params));
    }
  }

}