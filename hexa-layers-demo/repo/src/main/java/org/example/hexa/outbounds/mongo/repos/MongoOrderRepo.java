package org.example.hexa.outbounds.mongo.repos;

import org.example.hexa.outbounds.mongo.entities.OrderEntity;

// TODO implementar mongo repository 
public interface MongoOrderRepo {

	OrderEntity insert(OrderEntity entity);

	OrderEntity update(OrderEntity entity);

	void delete(String id);

}
