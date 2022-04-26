package greyhawk.conventions;

import org.greyhawk.archunit.GenericRules;
import com.tngtech.archunit.lang.ArchRule;

public class GenricRulesTemplate {

  public static final ArchRule JAVA_UTIL_LOGGING = GenericRules.NO_JAVA_UTIL_LOGGING;
  public static final ArchRule STANDARD_STREAMS = GenericRules.NO_STANDARD_STREAMS;
  public static final ArchRule JODATIME = GenericRules.NO_JODATIME;
  public static final ArchRule CYCLES = GenericRules.NO_CYCLES;

}