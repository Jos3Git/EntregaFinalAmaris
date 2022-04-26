package org.example.hexa.inbounds.rest.orders.dtos;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDto {

	@NotNull
	private String orderId;

	@NotNull
	private BigDecimal totaPrice;

	@NotNull
	// TODO @jsonformat
	private ZonedDateTime orderDate;

}
