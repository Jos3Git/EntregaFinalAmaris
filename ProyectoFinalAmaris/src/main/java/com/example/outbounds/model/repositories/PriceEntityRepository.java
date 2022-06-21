package com.example.outbounds.model.repositories;

import com.example.outbounds.model.entities.PriceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceEntityRepository extends MongoRepository<PriceEntity, String> {

  @Query("""
          {'product._id': '?0',
          'brand._id': '?1',
          startdate:{$lte:ISODate('?2')},
          enddatedate:{$gte:ISODate('?3')}}
          """)
  List<PriceEntity> findAllByProductIdAndBrandIdAndEnddateBeforeAndStartdateAfter(String idProduct, String idBrand,
      LocalDateTime dateAplication, LocalDateTime dateAplication2);

  List<PriceEntity> findAllByProductIdAndBrandId(String idProduct, String idBrand);

  PriceEntity findByProductIdAndPricelist(String idProduct, Integer pricelist);
}