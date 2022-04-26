package org.example.hexa.inbounds.rest.orders.mappers;

import org.example.hexa.domain.orders.vos.Order;
import org.example.hexa.inbounds.rest.orders.dtos.OrderRequestDto;
import org.example.hexa.inbounds.rest.orders.dtos.OrderResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface OrderDtoMapper {

	Order toVo(OrderRequestDto dto);

	OrderResponseDto toDto(Order vo);

}
