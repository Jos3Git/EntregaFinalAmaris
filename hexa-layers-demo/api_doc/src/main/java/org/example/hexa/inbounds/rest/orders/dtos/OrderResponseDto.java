package org.example.hexa.inbounds.rest.orders.dtos;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDto {

	private Instant createdAt;

	private Instant updatedAt;

	private String orderId;

	private BigDecimal totaPrice;

	// TODO @jsonformat
	private ZonedDateTime orderDate;

}
