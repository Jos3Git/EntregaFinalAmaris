package org.example.hexa.inbounds.rest.orders;

import org.example.hexa.inbounds.rest.orders.dtos.OrderRequestDto;
import org.example.hexa.inbounds.rest.orders.dtos.OrderResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface OrdersCommandApi {

	@PostMapping(value = "/")
	ResponseEntity<OrderResponseDto> insert(@RequestBody OrderRequestDto dto);

	@PutMapping(value = "/{id}")
	ResponseEntity<OrderResponseDto> update(@PathVariable String id, @RequestBody OrderRequestDto dto);

	@DeleteMapping(value = "/{id}")
	ResponseEntity<Void> delete(@PathVariable String id);

}
