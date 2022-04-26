package org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd;

public interface ApiDocCrudController<Q, S>
    extends ApiDocInsert.Controller<Q, S>, ApiDocUpdate.Controller<Q, S>, ApiDocDelete.Controller<S> {

  interface ServletAccess<Q, S> extends ApiDocInsert.ControllerServletAccess<Q, S>, ApiDocUpdate.ControllerServletAccess<Q, S>,
      ApiDocDelete.ControllerServletAccess<S> {
  }

}
