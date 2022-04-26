package org.example.hexa.outbounds.mongo.entities;

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
//TODO mongo document etc
public class OrderEntity {

	// TODO mongo @Id
	private Long orderId;

	private Instant createdAt;

	private Instant updatedAt;

	private BigDecimal totaPrice;

	private ZonedDateTime orderDate;

}
