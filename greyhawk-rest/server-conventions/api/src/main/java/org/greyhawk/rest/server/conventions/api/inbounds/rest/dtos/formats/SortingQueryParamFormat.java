package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.formats;

import java.util.Optional;

import org.greyhawk.core.utils.domain.exceptions.RequestError.InvalidInputDataException;
import org.greyhawk.core.utils.domain.vos.sorting.Sorting;
import org.greyhawk.core.utils.domain.vos.sorting.SortingCriteria;
import org.greyhawk.core.utils.domain.vos.sorting.SortingDirection;
import org.greyhawk.rest.server.conventions.api.domain_connectors.mappers.SortingQueryParamDeserializer;
import org.springframework.stereotype.Component;

public final class SortingQueryParamFormat {

  public static final String CRITERIA_SEPARATOR_REGEXPR = ",";

  public static final String DIR_ASC = "a";
  public static final String DIR_DESC = "d";
  public static final String DIR_SEPARATOR = ":";
  public static final String DIR_SEPARATOR_REGEXPR = DIR_SEPARATOR;

  private SortingQueryParamFormat() {
    // empty
  }

  @Component
  public static final class Deserializer implements SortingQueryParamDeserializer {

    private static final String ERROR_DESCR = "Sort parameter";

    @Override
    public Sorting deserialize(final Optional<String> queryParam) {
      final Sorting sorting = new Sorting();
      if (null != queryParam) {
        queryParam.filter(p -> (null != p)).ifPresent(p -> parse(sorting, p));
      }
      return sorting;
    }

    private void parse(final Sorting sorting, final String queryParam) {
      final String[] tokens = tokenize(queryParam);
      for (String token : tokens) {
        final SortingCriteria crit = parseCriteria(token);
        if (sorting.containsField(crit.getField())) {
          throw new InvalidInputDataException(ERROR_DESCR, "Duplicated parameter", null, crit.getField());
        }
        sorting.getCriteria().add(crit);
      }
    }

    private String[] tokenize(final String sort) {
      final var trimmmed = sort.trim();
      if (trimmmed.contains(" ")) {
        throw new InvalidInputDataException(ERROR_DESCR, "Parameter contains spaces", null, sort);
      }
      return trimmmed.split(CRITERIA_SEPARATOR_REGEXPR);
    }

    private SortingCriteria parseCriteria(final String token) {
      if (token.startsWith(DIR_SEPARATOR)) {
        throw new InvalidInputDataException(ERROR_DESCR, "Field starts with separator", null, DIR_SEPARATOR);
      }
      String dir = DIR_ASC;
      String name = null;
      final var crit = token.split(DIR_SEPARATOR_REGEXPR);

      switch (crit.length) {
      case 0:
        // field
        break;
      case 1:
        // field.
        break;
      case 2:
        // field.asc
        dir = crit[1].toLowerCase();
        break;
      default:
        // p.ej. b..c
        throw new InvalidInputDataException(ERROR_DESCR, "Field contains separator", null, DIR_SEPARATOR);
      }

      name = crit[0].toLowerCase();

      SortingDirection sortDir;
      switch (dir) {
      case DIR_ASC:
        sortDir = SortingDirection.ASC;
        break;
      case DIR_DESC:
        sortDir = SortingDirection.DESC;
        break;
      default:
        throw new InvalidInputDataException(ERROR_DESCR, "Invalid direction", null, dir);
      }
      return new SortingCriteria(name, sortDir);
    }

  }

}