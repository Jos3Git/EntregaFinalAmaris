package org.example.hexa.outboundsconnectors.mongo.adaptors;

import org.example.hexa.domain.orders.vos.Order;
import org.example.hexa.outbounds.mongo.entities.OrderEntity;
import org.example.hexa.outbounds.mongo.repos.MongoOrderRepo;
import org.example.hexa.outboundsconnectors.mongo.mappers.OrderEntityMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MongoOrderRepoConnectorComp implements MongoOrderRepoConnector {

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

}
