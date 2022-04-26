package org.greyhawk.archunit;

import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;

//TODO minimo un @Test debe existir

public class GenericRules {

  public static final ArchRule NO_JAVA_UTIL_LOGGING = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

  public static final ArchRule NO_STANDARD_STREAMS = GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

  public static final ArchRule NO_JODATIME = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME;

  public static final ArchRule NO_CYCLES = SlicesRuleDefinition.slices().matching("..").should().beFreeOfCycles();

}