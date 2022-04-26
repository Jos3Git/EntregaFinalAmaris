package com.example.outbounds.mappers;

import com.example.commons.dtos.BrandDTO;
import com.example.commons.dtos.PriceDTO;
import com.example.commons.dtos.ProductDTO;
import com.example.domain.vos.Brand;
import com.example.domain.vos.Price;
import com.example.domain.vos.Product;
import com.example.outbounds.model.entities.BrandEntity;
import com.example.outbounds.model.entities.PriceEntity;
import com.example.outbounds.model.entities.ProductEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BrandEntityToDTOMapperImplTest {

  BrandEntityToDTOMapperImpl mapper = new BrandEntityToDTOMapperImpl();

  @Test
  void mapResponseList() {
    List<BrandDTO> response = mapper.mapResponseList(List.of(new BrandEntity("1", "Zara", null), new BrandEntity("2", "Zara2", null)));

    Assertions.assertNotNull(response);
    Assertions.assertEquals(2, response.size());
  }

  @Test
  void mapResponseListNull() {
    List<BrandDTO> response = mapper.mapResponseList(null);

    Assertions.assertNull(response);
  }

  @Test
  void mapRequest() {
    BrandEntity response = mapper.mapRequest(new BrandDTO("1", "Zara", null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(BrandEntity.class, response);
  }

  @Test
  void mapRequestNull() {
    BrandEntity response = mapper.mapRequest(null);

    Assertions.assertNull(response);
  }

  @Test
  void mapResponse() {
    BrandDTO response = mapper.mapResponse(new BrandEntity("1", "Zara", null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(BrandDTO.class, response);
  }

  @Test
  void mapResponseNull() {
    BrandDTO response = mapper.mapResponse(null);

    Assertions.assertNull(response);
  }

  @Test
  void priceDTOListToPriceEntityList() {
    List<PriceEntity> response = mapper.priceDTOListToPriceEntityList(List.of(new PriceDTO(), new PriceDTO()));

    Assertions.assertNotNull(response);
    Assertions.assertEquals(2, response.size());
  }

  @Test
  void priceDTOListToPriceEntityListNull() {
    List<PriceEntity> response = mapper.priceDTOListToPriceEntityList(null);

    Assertions.assertNull(response);
  }

  @Test
  void productDTOToProductEntity() {
    ProductEntity response = mapper.productDTOToProductEntity(new ProductDTO());

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(ProductEntity.class, response);
  }

  @Test
  void productDTOToProductEntityNull() {
    ProductEntity response = mapper.productDTOToProductEntity(null);

    Assertions.assertNull(response);
  }

  @Test
  void priceDTOToPriceEntity() {
    PriceEntity response = mapper.priceDTOToPriceEntity(new PriceDTO());

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(PriceEntity.class, response);
  }

  @Test
  void priceDTOToPriceEntityNull() {
    PriceEntity response = mapper.priceDTOToPriceEntity(null);

    Assertions.assertNull(response);
  }
}