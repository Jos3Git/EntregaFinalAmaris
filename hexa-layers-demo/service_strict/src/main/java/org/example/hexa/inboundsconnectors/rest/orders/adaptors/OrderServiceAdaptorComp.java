package org.example.hexa.inboundsconnectors.rest.orders.adaptors;

import org.example.hexa.domain.orders.services.OrderService;
import org.example.hexa.domain.orders.vos.Order;
import org.example.hexa.inbounds.rest.orders.dtos.OrderRequestDto;
import org.example.hexa.inbounds.rest.orders.dtos.OrderResponseDto;
import org.example.hexa.inboundsconnectors.rest.orders.mappers.OrderDtoMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderServiceAdaptorComp implements OrderServiceAdaptor {

	private final OrderDtoMapper mapper;
	private final OrderService service;

	@Override
	public OrderResponseDto insert(OrderRequestDto dto) {
		Order vo = mapper.toVo(dto);
		// aqui puede haber mas logica de mapeo
		Order resp = service.insert(vo);
		return mapper.toDto(resp);
	}

	@Override
	public OrderResponseDto update(OrderRequestDto dto) {
		Order vo = mapper.toVo(dto);
		// aqui puede haber mas logica de mapeo
		Order resp = service.update(vo);
		return mapper.toDto(resp);
	}

}
