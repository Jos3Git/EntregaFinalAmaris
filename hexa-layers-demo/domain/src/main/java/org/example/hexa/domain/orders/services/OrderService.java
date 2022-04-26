package org.example.hexa.domain.orders.services;

import org.example.hexa.domain.orders.vos.Order;

public interface OrderService {

	Order insert(Order vo);

	Order update(Order vo);

	void delete(String id);

}
