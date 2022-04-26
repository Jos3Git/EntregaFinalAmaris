package org.greyhawk.utils.commons.json;

import org.greyhawk.core.testutils.commons.JacksonMapperTester;
import org.greyhawk.core.utils.commons.json.ClassTypeRef;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Data;
import lombok.RequiredArgsConstructor;

class ClassTypeRefTest {

  @Data
  @RequiredArgsConstructor
  public static class TestDto {
    public static ClassTypeRef<TestDto> TYPEREF = new ClassTypeRef<>(TestDto.class, new TypeReference<TestDto>() {
    });

    private final Long id;
    private final String name;
  }

  @Test
  void test() {
    new JacksonMapperTester().test(new TestDto(22L, "uuu"), TestDto.TYPEREF.getTypeRef());
  }

}
