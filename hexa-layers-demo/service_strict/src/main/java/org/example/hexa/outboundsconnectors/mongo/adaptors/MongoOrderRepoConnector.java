package org.example.hexa.outboundsconnectors.mongo.adaptors;

import org.example.hexa.domain.orders.vos.Order;

public interface MongoOrderRepoConnector {

	Order insert(Order vo);

	Order update(Order vo);

}
