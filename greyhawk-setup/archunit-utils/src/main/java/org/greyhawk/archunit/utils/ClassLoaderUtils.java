package org.greyhawk.archunit.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassLoaderUtils {

  public static String getClassesFolder() {

    final Enumeration<URL> resources;
    try {
      final var cl = Thread.currentThread().getContextClassLoader();
      resources = cl.getResources(".");
    } catch (IOException e) {
      throw new RuntimeException("Error reading resources", e);
    }

    String found = null;
    while (resources.hasMoreElements()) {
      final var f = resources.nextElement().getFile();
      log.debug("Trying classpath resource: {}", f);
      if (f.endsWith("/target/classes/")) {
        found = f;
      }
    }
    if (null == found) {
      throw new RuntimeException("Classes folder not found");
    }
    log.debug("Classes folder found: {}", found);

    return found;
  }

}
