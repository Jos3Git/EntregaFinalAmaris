package org.example.hexa.inbounds.rest.orders;

import org.example.hexa.domain.orders.services.OrderService;
import org.example.hexa.inbounds.rest.orders.dtos.OrderRequestDto;
import org.example.hexa.inbounds.rest.orders.dtos.OrderResponseDto;
import org.example.hexa.inboundsconnectors.rest.orders.adaptors.OrderServiceAdaptor;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrdersCommandController implements OrdersCommandApi {

	private final OrderServiceAdaptor serviceAdapter;
	private final OrderService service;

	@Override
	public ResponseEntity<OrderResponseDto> insert(OrderRequestDto dto) {
		OrderResponseDto resp = serviceAdapter.insert(dto);
		return ResponseEntity.ok(resp);
	}

	@Override
	public ResponseEntity<OrderResponseDto> update(String id, OrderRequestDto dto) {
		OrderResponseDto resp = serviceAdapter.update(dto);
		// TODO handle 404
		return ResponseEntity.ok(resp);
	}

	@Override
	public ResponseEntity<Void> delete(String id) {
		// directamente service sin VO
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
