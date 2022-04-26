package greyhawk.conventions;

import org.greyhawk.archunit.LayersCustomizations;
import org.greyhawk.archunit.LayersRules;
import org.greyhawk.archunit.layers.LayersAccessRules;
import org.greyhawk.archunit.layers.LayersComponentRules;
import org.greyhawk.archunit.layers.LayersModelRules;
import com.tngtech.archunit.lang.ArchRule;

public class LayersRulesTemplate {

  private final LayersCustomizations customizations = LayersCustomizations.builder().build();
  private final LayersRules layers = new LayersRules(customizations);

  private final LayersAccessRules access = layers.accessRules();
  public final ArchRule basicOnly = access.basicLayersOnly();
  public final ArchRule commons = access.commons();
  public final ArchRule inbounds = access.inbounds();
  public final ArchRule domainConnectors = access.domainConnectors();
  public final ArchRule domain = access.domain();
  public final ArchRule outboundConnectors = access.outboundConnectors();
  public final ArchRule outbounds = access.outbounds();

  private final LayersModelRules model = layers.modelRules();
  public final ArchRule dtosUbication = model.dtosUbication();
  public final ArchRule dtosUsage = model.dtosUsage();
  public final ArchRule entitiesUbication = model.entitiesUbication();
  public final ArchRule entitiesUsage = model.entitiesUsage();
  public final ArchRule vosUsage = model.vosUsage();

  private final LayersComponentRules components = layers.componentsRules();
  public final ArchRule controllers = components.controllersUbication();
  public final ArchRule services = components.servicesUbication();
  public final ArchRule repositories = components.repositoriesUbication();
  public final ArchRule mappers = components.mappersUbication();
  public final ArchRule autoconfig = components.autoconfigUbication();
  public final ArchRule application = components.applicationUbication();

}
