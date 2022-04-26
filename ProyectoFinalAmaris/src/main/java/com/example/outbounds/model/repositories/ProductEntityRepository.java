package com.example.outbounds.model.repositories;

import com.example.outbounds.model.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepository extends MongoRepository<ProductEntity, String> {
}