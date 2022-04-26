package org.greyhawk.archunit.layers;

import org.greyhawk.archunit.LayersCustomizations;
import org.greyhawk.archunit.predicates.NameIgnoreCaseEndingWith;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import lombok.Builder;
import lombok.Getter;

//TODO if useDomainConnectors

//TODO if useOutboundConnectors

@Getter
public class LayersModelRules extends LayersBase {

  private final String dtosPkg;
  private final String dtosNames;
  private final String vosPkg;
  private final String vosNames;
  private final String entitiesPkg;
  private final String entitiesNames;

  @Builder
  public LayersModelRules(LayersCustomizations customization, String dtosPkg, String dtosNames, String vosPkg, String vosNames,
      String entitiesPkg, String entitiesNames) {
    super(customization);
    this.dtosPkg = dtosPkg;
    this.dtosNames = dtosNames;
    this.vosPkg = vosPkg;
    this.vosNames = vosNames;
    this.entitiesPkg = entitiesPkg;
    this.entitiesNames = entitiesNames;
  }

  public LayersModelRules(LayersCustomizations customization) {
    this(customization, "..dtos..", "Dto", "..vos..", null, "..entities..", "Entity");
  }

  public ArchRule dtosUbication() {
    // TODO dtosUbication - OrderResponseDtoList
    return ArchRuleDefinition.classes().that(new NameIgnoreCaseEndingWith(getDtosNames())).should().resideInAnyPackage(getDtosPkg());
  }

  // TODO añadir en dtosUbication
  public ArchRule dtosUsage() {
    return ArchRuleDefinition.classes().that().resideInAPackage(getDtosPkg()).should().onlyBeAccessed()
        .byAnyPackage(subPkg(inbounds, domainConnectors));
  }

  // TODO vosUbication .. como?

  public ArchRule vosUsage() {
    if (usesDomainConnectorsPackage() && usesOutboundConnectorsPackage())
      return ArchRuleDefinition.classes().that().resideInAPackage(getVosPkg()).should().onlyBeAccessed()
          .byAnyPackage(subPkg(domainConnectors, domain, outboundConnectors));

    if (!usesDomainConnectorsPackage() && usesOutboundConnectorsPackage())
      return ArchRuleDefinition.classes().that().resideInAPackage(getVosPkg()).should().onlyBeAccessed()
          .byAnyPackage(subPkg(inbounds, domain, outboundConnectors));

    if (usesDomainConnectorsPackage() && !usesOutboundConnectorsPackage())
      return ArchRuleDefinition.classes().that().resideInAPackage(getVosPkg()).should().onlyBeAccessed()
          .byAnyPackage(subPkg(domainConnectors, domain, outbounds));

    // !usesDomainConnectors && !usesOutboundConnectors
    return ArchRuleDefinition.classes().that().resideInAPackage(getVosPkg()).should().onlyBeAccessed()
        .byAnyPackage(subPkg(inbounds, domain, outbounds));
  }

  public ArchRule entitiesUbication() {
    return ArchRuleDefinition.classes().that(new NameIgnoreCaseEndingWith(getEntitiesNames())).should()
        .resideInAnyPackage(getEntitiesPkg());
  }

  public ArchRule entitiesUsage() {
    if (usesOutboundConnectorsPackage())
      return ArchRuleDefinition.classes().that().resideInAPackage(getEntitiesPkg()).should().onlyBeAccessed()
          .byAnyPackage(subPkg(outbounds, outboundConnectors));
    else
      return ArchRuleDefinition.classes().that().resideInAPackage(getEntitiesPkg()).should().onlyBeAccessed()
          .byAnyPackage(subPkg(domain, outbounds, outboundConnectors));
  }

}
