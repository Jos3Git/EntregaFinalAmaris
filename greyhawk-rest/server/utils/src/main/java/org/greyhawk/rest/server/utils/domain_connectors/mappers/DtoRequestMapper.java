package org.greyhawk.rest.server.utils.domain_connectors.mappers;

public interface DtoRequestMapper<Q, V> {

  V mapRequest(Q dto);

}
