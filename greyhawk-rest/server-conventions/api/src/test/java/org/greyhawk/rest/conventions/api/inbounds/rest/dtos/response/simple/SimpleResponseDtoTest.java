package org.greyhawk.rest.conventions.api.inbounds.rest.dtos.response.simple;

import java.util.Arrays;
import java.util.List;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaErrorDetailsDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaErrorDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.greyhawk.rest.server.testutils.inbounds.rest.dtos.RestDtoTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;

class SimpleResponseDtoTest {

  @Test
  void test_dto() {
    List<ResponseMetaErrorDetailsDto> details = Arrays.asList(new ResponseMetaErrorDetailsDto("name", "007", "null", null));
    final var error = ResponseMetaErrorDto.builder().message("msg").details(details).build();
    final var metaData = ResponseMetaDto.builder().status("205").error(error).build();
    final SimpleResponseDto<Void> dto = new SimpleResponseDto<>(metaData, null);
    RestDtoTester.test(dto, new TypeReference<SimpleResponseDto<Void>>() {
    });
  }

  @Test
  void should_build_entity() {
    Assertions.assertEquals("<204,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=204, error=null), data=null)),[]>",
        SimpleResponseDto.success("204").toString());

    Assertions.assertEquals("<204,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=204, error=null), data=null)),[]>",
        SimpleResponseDto.success("204", null).toString());

    Assertions.assertEquals("<218,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=218, error=null), data=mydata)),[]>",
        SimpleResponseDto.success("218", "mydata").toString());

    Assertions.assertEquals(
        "<416,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=416, "
            + "error=ResponseMetaErrorDto(message=msg, details=null)), data=mydata)),[]>",
        SimpleResponseDto.error("416", "mydata", "msg", null).toString());

    Assertions.assertEquals(
        "<408,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=408, "
            + "error=ResponseMetaErrorDto(message=null, details=null)), data=null)),[]>",
        SimpleResponseDto.error("408", null, null, null).toString());

    Assertions.assertEquals(
        "<408,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=408, "
            + "error=ResponseMetaErrorDto(message=mybody, details=null)), data=null)),[]>",
        SimpleResponseDto.error("408", "mybody").toString());

    final List<ResponseMetaErrorDetailsDto> details = Arrays
        .asList(ResponseMetaErrorDetailsDto.builder().field("name").errorCode("A334").errorMsg("name null").build());
    Assertions.assertEquals(
        "<408,SimpleResponseDto(super=ResponseDto(meta=ResponseMetaDto(status=408, "
            + "error=ResponseMetaErrorDto(message=validation errors, "
            + "details=[ResponseMetaErrorDetailsDto(field=name, errorCode=A334, errorMsg=name null, errorParams=null)])), data=null)),[]>",
        SimpleResponseDto.error("408", "validation errors", details).toString());

  }

}
