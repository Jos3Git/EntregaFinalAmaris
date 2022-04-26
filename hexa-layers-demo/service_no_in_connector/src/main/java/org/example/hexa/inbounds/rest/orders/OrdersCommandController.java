package org.example.hexa.inbounds.rest.orders;

import org.example.hexa.domain.orders.services.OrderService;
import org.example.hexa.domain.orders.vos.Order;
import org.example.hexa.inbounds.rest.orders.dtos.OrderRequestDto;
import org.example.hexa.inbounds.rest.orders.dtos.OrderResponseDto;
import org.example.hexa.inbounds.rest.orders.mappers.OrderDtoMapper;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrdersCommandController implements OrdersCommandApi {

	private final OrderDtoMapper mapper;
	private final OrderService service;

	@Override
	public ResponseEntity<OrderResponseDto> insert(OrderRequestDto dto) {

		Order vo = mapper.toVo(dto);
		Order resp = service.insert(vo);
		OrderResponseDto respDto = mapper.toDto(resp);

		return ResponseEntity.ok(respDto);
	}

	@Override
	public ResponseEntity<OrderResponseDto> update(String id, OrderRequestDto dto) {

		Order vo = mapper.toVo(dto);
		Order resp = service.update(vo);
		// TODO handle 404
		OrderResponseDto respDto = mapper.toDto(resp);

		return ResponseEntity.ok(respDto);
	}

	@Override
	public ResponseEntity<Void> delete(String id) {
		// directamente service sin VO
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
