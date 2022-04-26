package org.greyhawk.rest.server.utils.domain_connectors.mappers;

import java.util.List;

public interface DtoResponseMapper<V, S> {

  S mapResponse(V vo);

  List<S> mapResponseList(List<V> vos);

}
