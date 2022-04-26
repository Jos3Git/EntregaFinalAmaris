package org.example.hexa.outboundsconnectors.mongo.mappers;

import org.example.hexa.domain.orders.vos.Order;
import org.example.hexa.outbounds.mongo.entities.OrderEntity;
import org.mapstruct.Mapper;

@Mapper
public interface OrderEntityMapper {

	Order toVo(OrderEntity entity);

	OrderEntity toEntity(Order vo);

}
