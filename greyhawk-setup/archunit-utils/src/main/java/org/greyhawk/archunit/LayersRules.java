package org.greyhawk.archunit;

import org.greyhawk.archunit.layers.LayersAccessRules;
import org.greyhawk.archunit.layers.LayersComponentRules;
import org.greyhawk.archunit.layers.LayersModelRules;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class LayersRules {

  private final LayersCustomizations customizations;

  public LayersAccessRules accessRules() {
    return new LayersAccessRules(customizations);
  }

  public LayersModelRules modelRules() {
    return new LayersModelRules(customizations);
  }

  public LayersComponentRules componentsRules() {
    return new LayersComponentRules(customizations);
  }

}