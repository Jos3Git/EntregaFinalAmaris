package org.greyhawk.archunit.layers;

import org.greyhawk.archunit.LayersCustomizations;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import lombok.Builder;

//TODO nested. no [domain, in, out...] in ningun otro 

//TODO check imports. p.ej. no *.vos.* in inbounds

public class LayersAccessRules extends LayersBase {

  @Builder
  public LayersAccessRules(LayersCustomizations customization) {
    super(customization);
  }

  public ArchRule basicLayersOnly() {
    return ArchRuleDefinition.classes().that().areNotAnnotatedWith(SpringBootApplication.class).and()
        .haveSimpleNameNotEndingWith("AutoConfiguration").and()
        .resideOutsideOfPackages(subPkg(commonUtils, inbounds, domainConnectors, domain, outboundConnectors, outbounds)).should()
        .bePrivate();
  }

  public ArchRule commons() {
    if (!useCommonsPackage())
      return ArchRuleDefinition.classes().that().resideInAPackage(subPkg(commonUtils)).should().bePrivate();
    else
      return ArchRuleDefinition.classes().that().resideInAPackage(subPkg(commonUtils)).should().onlyBeAccessed()
          .byAnyPackage(subPkg(commonUtils, inbounds, domainConnectors, domain, outboundConnectors, outbounds));
  }

  public ArchRule inbounds() {
    return ArchRuleDefinition.classes().that().resideInAPackage(subPkg(inbounds)).should().onlyBeAccessed()
        .byAnyPackage(subPkg(inbounds, domainConnectors));
  }

  public ArchRule domainConnectors() {
    if (!usesDomainConnectorsPackage())
      return ArchRuleDefinition.classes().that().resideInAPackage(subPkg(domainConnectors)).should().bePrivate();
    else
      return ArchRuleDefinition.classes().that().resideInAPackage(subPkg(domainConnectors)).should().onlyBeAccessed()
          .byAnyPackage(subPkg(domainConnectors, inbounds));
  }

  public ArchRule domain() {
    // TODO BUG falta out !!
    return ArchRuleDefinition.classes().that().resideInAPackage(subPkg(domain)).should().onlyBeAccessed()
        .byAnyPackage(subPkg(domain, domainConnectors, inbounds));
  }

  // TODO revisar: use outconnectors --> no permitir entities en domain

  public ArchRule outboundConnectors() {
    if (!usesOutboundConnectorsPackage())
      return ArchRuleDefinition.classes().that().resideInAPackage(subPkg(outboundConnectors)).should().bePrivate();
    else
      return ArchRuleDefinition.classes().that().resideInAPackage(subPkg(outboundConnectors)).should().onlyBeAccessed()
          .byAnyPackage(subPkg(outboundConnectors, domain));
  }

  public ArchRule outbounds() {
    return ArchRuleDefinition.classes().that().resideInAPackage(subPkg(outbounds)).should().onlyBeAccessed()
        .byAnyPackage(subPkg(outbounds, outboundConnectors, domain));
  }

}
