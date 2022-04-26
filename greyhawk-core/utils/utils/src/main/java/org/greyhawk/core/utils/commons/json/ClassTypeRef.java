package org.greyhawk.core.utils.commons.json;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ClassTypeRef<S> {
  private final Class<S> typeClass;
  private final TypeReference<S> typeRef;
}
