package org.greyhawk.archunit.layers;

import org.greyhawk.archunit.LayersCustomizations;
import org.greyhawk.archunit.predicates.NameIgnoreCaseEndingWith;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import lombok.Builder;

public class LayersComponentRules extends LayersBase {

  @Builder
  public LayersComponentRules(LayersCustomizations customization) {
    super(customization);
  }

  public ArchRule controllersUbication() {
    return ArchRuleDefinition.classes().that().areAnnotatedWith(Controller.class).or().areAnnotatedWith(RestController.class).should()
        .resideInAnyPackage(subPkg(inbounds));
  }

  public ArchRule servicesUbication() {
    return ArchRuleDefinition.classes().that().areAnnotatedWith(Service.class).should().resideInAnyPackage(subPkg(domain));
  }

  // TODO hexa: domain interfaces in connector

  public ArchRule repositoriesUbication() {
    return ArchRuleDefinition.classes().that().areAnnotatedWith(Repository.class).should().resideInAnyPackage(subPkg(outbounds));
  }

  public ArchRule mappersUbication() {
    // TODO if usesDomainConnectors & usesOutboundConnectors
    if (usesDomainConnectorsPackage() && usesOutboundConnectorsPackage())
      return ArchRuleDefinition.classes().that().areAnnotatedWith(Mapper.class).should()
          .resideInAnyPackage(subPkg(domainConnectors, outboundConnectors));

    if (!usesDomainConnectorsPackage() && usesOutboundConnectorsPackage())
      return ArchRuleDefinition.classes().that().areAnnotatedWith(Mapper.class).should()
          .resideInAnyPackage(subPkg(inbounds, outboundConnectors));

    if (usesDomainConnectorsPackage() && !usesOutboundConnectorsPackage())
      return ArchRuleDefinition.classes().that().areAnnotatedWith(Mapper.class).should()
          .resideInAnyPackage(subPkg(domainConnectors, outbounds));

    // !usesDomainConnectors && !usesOutboundConnectors
    return ArchRuleDefinition.classes().that().areAnnotatedWith(Mapper.class).should().resideInAnyPackage(subPkg(inbounds, outbounds));
  }

  public ArchRule autoconfigUbication() {
    return ArchRuleDefinition.classes().that(new NameIgnoreCaseEndingWith("AutoConfiguration")).should().resideInAnyPackage(rootPackage);
  }

  public ArchRule applicationUbication() {
    return ArchRuleDefinition.classes().that(new NameIgnoreCaseEndingWith("Application")).should().resideInAnyPackage(rootPackage);
  }

}
