package org.greyhawk.core.utils.commons.functions;

@FunctionalInterface
public interface ThrowingRunnable {
  void run() throws Exception;
}