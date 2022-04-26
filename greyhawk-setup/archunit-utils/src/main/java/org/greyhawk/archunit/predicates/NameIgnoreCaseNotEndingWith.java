package org.greyhawk.archunit.predicates;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.properties.HasName;

public class NameIgnoreCaseNotEndingWith extends DescribedPredicate<HasName> {

  private final String caseInsensitiveSuffix;

  public NameIgnoreCaseNotEndingWith(String suffix) {
    super(String.format("name case insensitive not ending with '%s'", suffix));
    this.caseInsensitiveSuffix = suffix.toLowerCase();
  }

  @Override
  public boolean apply(HasName input) {
    return !input.getName().toLowerCase().endsWith(caseInsensitiveSuffix);
  }

}
