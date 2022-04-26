package org.example.hexa.inboundsconnectors.rest.orders.adaptors;

import org.example.hexa.inbounds.rest.orders.dtos.OrderRequestDto;
import org.example.hexa.inbounds.rest.orders.dtos.OrderResponseDto;

public interface OrderServiceAdaptor {

	OrderResponseDto insert(OrderRequestDto dto);

	OrderResponseDto update(OrderRequestDto dto);

}
