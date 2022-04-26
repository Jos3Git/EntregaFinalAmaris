package org.greyhawk.rest.server.utils.commons;

public final class HttpStatusCodes {

  private HttpStatusCodes() {
    // empty
  }

  public static final String OK = "200";
  public static final String CREATED = "201";
  public static final String ACCEPTED = "202";
  public static final String NON_AUTHORITATIVE_INFORMATION = "203";
  public static final String NO_CONTENT = "204";
  public static final String RESET_CONTENT = "205";
  public static final String PARTIAL_CONTENT = "206";
  public static final String MULTI_STATUS = "207";

  public static final String BAD_REQUEST = "400";
  public static final String UNAUTHORIZED = "401";
  public static final String PAYMENT_REQUIRED = "402";
  public static final String FORBIDDEN = "403";
  public static final String NOT_FOUND = "404";
  public static final String METHOD_NOT_ALLOWED = "405";
  public static final String NOT_ACCEPTABLE = "406";
  public static final String PROXY_AUTHENTICATION_REQUIRED = "407";
  public static final String REQUEST_TIMEOUT = "408";
  public static final String CONFLICT = "409";
  public static final String GONE = "410";
  public static final String LENGTH_REQUIRED = "411";
  public static final String PRECONDITION_FAILED = "412";
  public static final String REQUEST_TOO_LONG = "413";
  public static final String REQUEST_URI_TOO_LONG = "414";
  public static final String UNSUPPORTED_MEDIA_TYPE = "415";
  public static final String REQUESTED_RANGE_NOT_SATISFIABLE = "416";
  public static final String EXPECTATION_FAILED = "417";
  public static final String MISDIRECTED_REQUEST = "421";
  public static final String UNPROCESSABLE_ENTITY = "422";
  public static final String LOCKED = "423";
  public static final String FAILED_DEPENDENCY = "424";
  public static final String TOO_EARLY = "425";
  public static final String UPGRADE_REQUIRED = "426";
  public static final String PRECONDITION_REQUIRED = "428";
  public static final String TOO_MANY_REQUESTS = "429";
  public static final String REQUEST_HEADER_FIELDS_TOO_LARGE = "431";
  public static final String UNAVAILABLE_FOR_LEGAL_REASONS = "451";

}
