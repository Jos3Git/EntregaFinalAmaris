package org.greyhawk.archunit.predicates;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.properties.HasName;

public class NameIgnoreCaseEndingWith extends DescribedPredicate<HasName> {

  private final String caseInsensitiveSuffix;

  public NameIgnoreCaseEndingWith(String suffix) {
    super(String.format("name case insensitive ending with '%s'", suffix));
    this.caseInsensitiveSuffix = suffix.toLowerCase();
  }

  @Override
  public boolean apply(HasName input) {
    return input.getName().toLowerCase().endsWith(caseInsensitiveSuffix);
  }

}
