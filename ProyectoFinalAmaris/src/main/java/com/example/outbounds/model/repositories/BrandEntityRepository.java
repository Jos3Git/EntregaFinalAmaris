package com.example.outbounds.model.repositories;

import com.example.outbounds.model.entities.BrandEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandEntityRepository extends MongoRepository<BrandEntity, String> {
}