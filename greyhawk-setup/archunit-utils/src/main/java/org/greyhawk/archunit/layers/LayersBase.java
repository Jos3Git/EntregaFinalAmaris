package org.greyhawk.archunit.layers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.stream.Stream;
import org.greyhawk.archunit.LayersCustomizations;
import org.greyhawk.archunit.LayersCustomizations.Usage;
import org.greyhawk.archunit.utils.ClassLoaderUtils;
import org.springframework.util.Assert;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public abstract class LayersBase {

//TODO revisar onlyBeAccessed --> onlyHaveDependentClassesThat() ?
//TODO revisar dependOnClassesThat 

  @ToString.Exclude
  protected final Properties allMavenProps;

  protected final String rootPackage;

  protected final String commonUtils;
  protected final String inbounds;
  protected final String domainConnectors;
  protected final String domain;
  protected final String outboundConnectors;
  protected final String outbounds;

  protected final LayersCustomizations customizations;

  public LayersBase(final LayersCustomizations customizations) {
    try {

      Assert.notNull(customizations, "Customizations required");
      this.customizations = customizations;

      allMavenProps = loadProps("../greyhawk-project-setup-import/META-INF/greyhawk/maven.all.properties");

      rootPackage = getPackage("greyhawk.package.root");

      commonUtils = useCommonsPackage() ? rootPackage + "." + getPackage("greyhawk.package.common_utils") : null;
      inbounds = rootPackage + "." + getPackage("greyhawk.package.inbounds");
      domainConnectors = usesDomainConnectorsPackage() ? rootPackage + "." + getPackage("greyhawk.package.domain_connectors") : null;
      domain = rootPackage + "." + getPackage("greyhawk.package.domain");
      outboundConnectors = usesOutboundConnectorsPackage() ? rootPackage + "." + getPackage("greyhawk.package.outbound_connectors") : null;
      outbounds = rootPackage + "." + getPackage("greyhawk.package.outbounds");

      log.debug("Layers: {}", this);

    } catch (Exception e) {
      log.error("Error initializing", e);
      throw e;
    }
  }

  private String getPackage(String prop) {
    final var pck = getMavenProperty(prop);
    if (pck.startsWith(".")) {
      throw new IllegalArgumentException("Leading dots in package: " + pck);
    }
    if (pck.endsWith(".")) {
      throw new IllegalArgumentException("Trailing dots in package: " + pck);
    }
    return pck;
  }

  private Properties loadProps(String fname) {
    final var classesFolder = ClassLoaderUtils.getClassesFolder();
    final var path = new File(classesFolder + fname);
    log.debug("Loading maven.properties: {}", path);
    final Properties props = new Properties();
    try {
      final var fis = new FileInputStream(path);
      props.load(fis);
    } catch (IOException e) {
      throw new IllegalArgumentException("Error loading properties " + path, e);
    }
    return props;
  }

  protected String getMavenProperty(String key) {
    String val = (String) allMavenProps.get(key);
    if ((null == val) || (val.trim().length() < 1)) {
      throw new IllegalArgumentException("Missing value for: " + key);
    }
    return val;
  }

  protected String noPackage() {
    return "NOT_EXISTING_" + Math.random();
  }

  protected String subPkg(String pck) {
    return pck + "..";
  }

  protected String[] subPkg(String... pckgs) {
    return Stream.of(pckgs).filter(p -> (null != p)).map(p -> p + "..").toArray(String[]::new);
  }

  protected boolean useCommonsPackage() {
    return !customizations.getUseCommonsPackage().equals(Usage.NO);
  }

  protected boolean usesOutboundConnectorsPackage() {
    return !customizations.getUseOutboundConnectorsPackage().equals(Usage.NO);
  }

  protected boolean usesDomainConnectorsPackage() {
    return !customizations.getUseDomainConnectorsPackage().equals(Usage.NO);
  }

}