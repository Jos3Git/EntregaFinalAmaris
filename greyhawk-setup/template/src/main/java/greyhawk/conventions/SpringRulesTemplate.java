package greyhawk.conventions;

import org.greyhawk.archunit.SpringRules;
import com.tngtech.archunit.lang.ArchRule;

public class SpringRulesTemplate {

  public static final ArchRule AUTOWIRED_FIELDS = SpringRules.NO_AUTOWIRED_IN_FIELDS;
  public static final ArchRule AUTOWIRED_METHODS = SpringRules.NO_AUTOWIRED_IN_METHODS;
  public static final ArchRule AUTOWIRED_CONSTRUCTORS = SpringRules.NO_AUTOWIRED_IN_CONSTRUCTORS;
  public static final ArchRule AUTOWIRED_PARAMS = SpringRules.NO_AUTOWIRED_IN_PARAMS;

  public static final ArchRule VALUE_METHODS = SpringRules.NO_VALUE_IN_METHODS;
  public static final ArchRule VALUE_CONSTRUCTORS = SpringRules.NO_VALUE_IN_CONSTRUCTORS;
  public static final ArchRule VALUE_PROPS = SpringRules.VALUE_IN_PROPS;

  public static final ArchRule PROPERTIES_UBICATION = SpringRules.PROPERTIES_UBICATION;

  public static final ArchRule CONFIG_UBICATION = SpringRules.CONFIG_UBICATION;
  public static final ArchRule CONFIGURATION_IN_CONFIG = SpringRules.CONFIGURATION_IN_CONFIG;

  public static final ArchRule BEANS_IN_CONFIG = SpringRules.BEANS_IN_CONFIG;
  public static final ArchRule BEANS_WITH_CONFIGURATION = SpringRules.BEANS_WITH_CONFIGURATION;

  public static final ArchRule APPLICATION_IN_APPL = SpringRules.APPLICATION_IN_APPL;

  public static final ArchRule MAPPERS_UBICATION = SpringRules.MAPPERS_UBICATION;
  public static final ArchRule MAPPERS_IN_MAPPERS = SpringRules.MAPPERS_IN_MAPPERS;

}