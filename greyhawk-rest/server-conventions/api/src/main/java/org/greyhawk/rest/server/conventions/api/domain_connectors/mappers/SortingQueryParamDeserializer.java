package org.greyhawk.rest.server.conventions.api.domain_connectors.mappers;

import java.util.Optional;
import org.greyhawk.core.utils.domain.vos.sorting.Sorting;

public interface SortingQueryParamDeserializer {

  Sorting deserialize(Optional<String> sort);

}
