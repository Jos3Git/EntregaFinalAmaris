package org.example.hexa.domain.orders.services;

import org.example.hexa.domain.orders.vos.Order;
import org.example.hexa.outbounds.mongo.repos.MongoOrderRepo;
import org.example.hexa.outboundsconnectors.mongo.adaptors.MongoOrderRepoConnector;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceComp implements OrderService {

	private final MongoOrderRepoConnector repoConnector;
	private final MongoOrderRepo repo;

	@Override
	public Order insert(Order vo) {
		return repoConnector.insert(vo);
	}

	@Override
	public Order update(Order vo) {
		return repoConnector.update(vo);
	}

	@Override
	public void delete(String id) {
		// sin connector
		repo.delete(id);
	}

}
