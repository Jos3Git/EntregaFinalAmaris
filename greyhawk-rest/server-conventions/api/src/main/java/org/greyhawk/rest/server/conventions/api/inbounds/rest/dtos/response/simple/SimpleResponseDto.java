package org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple;

import java.util.List;

import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaErrorDetailsDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.ResponseMetaErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * Note: when returning 204, no body will be sent at all, i.e. the response parameter will be ignored
 *
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SimpleResponseDto<D> extends ResponseDto<ResponseMetaDto, D> {

  public SimpleResponseDto(final ResponseMetaDto meta, final @Nullable D response) {
    super(meta, response);
  }

  public static <S> ResponseEntity<SimpleResponseDto<S>> success(final String sc) {
    return success(sc, null);
  }

  public static <S> ResponseEntity<SimpleResponseDto<S>> success(final String sc, final @Nullable S response) {
    final var metaData = ResponseMetaDto.builder().status(sc).build();
    final SimpleResponseDto<S> body = new SimpleResponseDto<>(metaData, response);
    return ResponseEntity.status(Integer.parseInt(sc)).body(body);
  }

  public static <S> ResponseEntity<SimpleResponseDto<S>> error(final String sc, final String errorMessage) {
    return error(sc, null, errorMessage, null);
  }

  public static <S> ResponseEntity<SimpleResponseDto<S>> error(final String sc, final String errorMessage,
      final List<ResponseMetaErrorDetailsDto> errorDetails) {
    return error(sc, null, errorMessage, errorDetails);
  }

  public static <S> ResponseEntity<SimpleResponseDto<S>> error(final String sc, final @Nullable S response,
      final @Nullable String errorMessage, final @Nullable List<ResponseMetaErrorDetailsDto> errorDetails) {
    final var error = ResponseMetaErrorDto.builder().message(errorMessage).details(errorDetails).build();
    final var metaData = ResponseMetaDto.builder().status(sc).error(error).build();
    final SimpleResponseDto<S> body = new SimpleResponseDto<>(metaData, response);
    return ResponseEntity.status(Integer.parseInt(sc)).body(body);
  }

}
