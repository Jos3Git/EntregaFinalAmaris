package org.greyhawk.archunit;

import org.greyhawk.archunit.predicates.NameIgnoreCaseEndingWith;
import org.greyhawk.archunit.predicates.NameIgnoreCaseNotEndingWith;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.properties.CanBeAnnotated;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.GeneralCodingRules;

//TODO checkstyle variables en metodos final

//TODO @EntityScan solo en Configuration

public class SpringRules {

  public static final ArchRule NO_FIELD_INJECTION = GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

  // @Autowired

  public static final ArchRule NO_AUTOWIRED_IN_FIELDS = ArchRuleDefinition.fields().should().notBeAnnotatedWith(Autowired.class);
  public static final ArchRule NO_AUTOWIRED_IN_CONSTRUCTORS = ArchRuleDefinition.constructors().should()
      .notBeAnnotatedWith(Autowired.class);
  public static final ArchRule NO_AUTOWIRED_IN_METHODS = ArchRuleDefinition.methods().should().notBeAnnotatedWith(Autowired.class);
  // TODO and NO_AUTOWIRED_IN_METHODS
  // TODO NO_AUTOWIRED_IN_PARAMS no funciona
  public static final ArchRule NO_AUTOWIRED_IN_PARAMS = ArchRuleDefinition.methods().should()
      .notHaveRawParameterTypes(DescribedPredicate.anyElementThat(CanBeAnnotated.Predicates.annotatedWith(Autowired.class)));

  // @Value

  // TODO NO_VALUE_IN_METHODS no funciona
  public static final ArchRule NO_VALUE_IN_METHODS = ArchRuleDefinition.methods().should()
      .notHaveRawParameterTypes(DescribedPredicate.anyElementThat(CanBeAnnotated.Predicates.annotatedWith(Value.class)));
  // TODO NO_VALUE_IN_CONSTRUCTORS no funciona
  public static final ArchRule NO_VALUE_IN_CONSTRUCTORS = ArchRuleDefinition.constructors().should()
      .notHaveRawParameterTypes(DescribedPredicate.anyElementThat(CanBeAnnotated.Predicates.annotatedWith(Value.class)));

  public static final ArchRule VALUE_IN_PROPS = ArchRuleDefinition.fields().that().areAnnotatedWith(Value.class).should()
      .beDeclaredInClassesThat().haveSimpleNameEndingWith("Properties");

  // Properties

  private static String configPkg() {
    return "..configuration..";
  }

  public static final ArchRule PROPERTIES_UBICATION = ArchRuleDefinition.classes().that(new NameIgnoreCaseEndingWith("Properties")).should()
      .resideInAnyPackage(configPkg());

  // Configuration

  public static final ArchRule CONFIG_UBICATION = ArchRuleDefinition.classes().that(new NameIgnoreCaseEndingWith("Configuration"))
      .and(new NameIgnoreCaseNotEndingWith("AutoConfiguration")).should().resideInAnyPackage(configPkg());

  public static final ArchRule CONFIGURATION_IN_CONFIG = ArchRuleDefinition.classes().that().areAnnotatedWith(Configuration.class).or()
      .areAnnotatedWith(ConfigurationProperties.class).should().haveSimpleNameEndingWith("Configuration").orShould()
      .haveSimpleNameEndingWith("AutoConfiguration");

  public static final ArchRule BEANS_IN_CONFIG = ArchRuleDefinition.methods().that().areAnnotatedWith(Bean.class).should()
      .beDeclaredInClassesThat().haveSimpleNameEndingWith("Configuration");

  public static final ArchRule BEANS_WITH_CONFIGURATION = ArchRuleDefinition.methods().that().areAnnotatedWith(Bean.class).should()
      .beDeclaredInClassesThat().areAnnotatedWith(Configuration.class);

  // Application

  public static final ArchRule APPLICATION_IN_APPL = ArchRuleDefinition.classes().that().areAnnotatedWith(SpringBootApplication.class)
      .should().haveSimpleNameEndingWith("Application");

  // Mappers

  private static String mappersPkg() {
    return "..mappers..";
  }

  public static final ArchRule MAPPERS_UBICATION = ArchRuleDefinition.classes().that(new NameIgnoreCaseEndingWith("Mapper")).should()
      .resideInAnyPackage(mappersPkg());

  public static final ArchRule MAPPERS_IN_MAPPERS = ArchRuleDefinition.classes().that().areAnnotatedWith(Mapper.class).should()
      .haveSimpleNameEndingWith("Mapper");

}
