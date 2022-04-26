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

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriceEntityToDTOMapperImplTest {
  PriceEntityToDTOMapperImpl mapper = new PriceEntityToDTOMapperImpl();

  @Test
  void mapResponse() {
    PriceDTO response = mapper.mapResponse(
        new PriceEntity("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 30D, "EUR", new BrandEntity(), new ProductEntity()));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(PriceDTO.class, response);
  }

  @Test
  void mapResponseNull() {
    PriceDTO response = mapper.mapResponse(null);

    Assertions.assertNull(response);
  }

  @Test
  void mapResponseList() {
    List<PriceDTO> response = mapper.mapResponseList(
        List.of(new PriceEntity("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 30D, "EUR", new BrandEntity(), new ProductEntity()),
            new PriceEntity("2", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 30D, "EUR", new BrandEntity(), new ProductEntity())));

    Assertions.assertNotNull(response);
    Assertions.assertEquals(2, response.size());
  }

  @Test
  void mapResponseListNull() {
    List<PriceDTO> response = mapper.mapResponseList(null);

    Assertions.assertNull(response);
  }

  @Test
  void mapRequest() {
    PriceEntity response = mapper
        .mapRequest(new PriceDTO("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 30D, "EUR", new BrandDTO(), new ProductDTO()));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(PriceEntity.class, response);
  }

  @Test
  void mapRequestNull() {
    PriceEntity response = mapper.mapRequest(null);

    Assertions.assertNull(response);
  }

  @Test
  void brandEntityToBrandDTO() {
    BrandDTO response = mapper.brandEntityToBrandDTO(new BrandEntity("1", "Zara", null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(BrandDTO.class, response);
  }

  @Test
  void brandEntityToBrandDTONull() {
    BrandDTO response = mapper.brandEntityToBrandDTO(null);

    Assertions.assertNull(response);
  }

  @Test
  void productEntityToProductDTO() {
    ProductDTO response = mapper
        .productEntityToProductDTO(new ProductEntity("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(ProductDTO.class, response);
  }

  @Test
  void productEntityToProductDTONull() {
    ProductDTO response = mapper.productEntityToProductDTO(null);

    Assertions.assertNull(response);
  }

  @Test
  void priceDTOListToPriceEntityList() {
    List<PriceEntity> response = mapper.priceDTOListToPriceEntityList(
        List.of(new PriceDTO("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 30D, "EUR", new BrandDTO(), new ProductDTO()),
            new PriceDTO("2", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 30D, "EUR", new BrandDTO(), new ProductDTO())));

    Assertions.assertNotNull(response);
    Assertions.assertEquals(2, response.size());
  }

  @Test
  void priceDTOListToPriceEntityListNull() {
    List<PriceEntity> response = mapper.priceDTOListToPriceEntityList(null);

    Assertions.assertNull(response);
  }

  @Test
  void brandDTOToBrandEntity() {
    BrandEntity response = mapper.brandDTOToBrandEntity(new BrandDTO("1", "Zara", null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(BrandEntity.class, response);
  }

  @Test
  void brandDTOToBrandEntityNull() {
    BrandEntity response = mapper.brandDTOToBrandEntity(null);

    Assertions.assertNull(response);
  }

  @Test
  void productDTOToProductEntity() {
    ProductEntity response = mapper
        .productDTOToProductEntity(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(ProductEntity.class, response);
  }

  @Test
  void productDTOToProductEntityNull() {
    ProductEntity response = mapper.productDTOToProductEntity(null);

    Assertions.assertNull(response);
  }
}