package org.example.hexa.domain.orders.services;

import org.example.hexa.domain.orders.vos.Order;
import org.example.hexa.outbounds.mongo.entities.OrderEntity;
import org.example.hexa.outbounds.mongo.mappers.OrderEntityMapper;
import org.example.hexa.outbounds.mongo.repos.MongoOrderRepo;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceComp implements OrderService {

	private final OrderEntityMapper mapper;
	private final MongoOrderRepo repo;

	@Override
	public Order insert(Order vo) {
		OrderEntity entity = mapper.toEntity(vo);
		OrderEntity resp = repo.insert(entity);
		return mapper.toVo(resp);
	}

	@Override
	public Order update(Order vo) {
		OrderEntity entity = mapper.toEntity(vo);
		OrderEntity resp = repo.update(entity);
		return mapper.toVo(resp);
	}

	@Override
	public void delete(String id) {
		repo.delete(id);
	}

}
