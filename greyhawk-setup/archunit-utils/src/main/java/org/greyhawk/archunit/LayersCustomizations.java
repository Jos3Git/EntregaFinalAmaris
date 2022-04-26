package org.greyhawk.archunit;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class LayersCustomizations {

  public static enum Usage {
    YES, NO, OPTL;
  }

  protected @Builder.Default final Usage useDomainConnectorsPackage = Usage.YES;
  protected @Builder.Default final Usage useDomainConnectors = Usage.OPTL;

  protected @Builder.Default final Usage useOutboundConnectorsPackage = Usage.YES;
  protected @Builder.Default final Usage useOutboundConnectors = Usage.YES;

  protected @Builder.Default final Usage useCommonsPackage = Usage.OPTL;

}