package org.example.hexa.domain.orders.vos;

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
public class Order {

	private Instant createdAt;

	private Instant updatedAt;

	private String orderId;

	private BigDecimal totaPrice;

	private ZonedDateTime orderDate;

}
