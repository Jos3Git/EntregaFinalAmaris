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

class ProductEntityToDTOMapperImplTest {

  ProductEntityToDTOMapperImpl mapper = new ProductEntityToDTOMapperImpl();

  @Test
  void mapResponseList() {
    List<ProductDTO> response = mapper
        .mapResponseList(List.of(new ProductEntity("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null),
            new ProductEntity("2", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null)));

    Assertions.assertNotNull(response);
    Assertions.assertEquals(2, response.size());
  }

  @Test
  void mapResponseNullList() {
    List<ProductDTO> response = mapper.mapResponseList(null);
    Assertions.assertNull(response);
  }

  @Test
  void mapRequest() {
    ProductEntity response = mapper
        .mapRequest(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(ProductEntity.class, response);
  }

  @Test
  void mapRequestNull() {
    ProductEntity response = mapper.mapRequest(null);
    Assertions.assertNull(response);
  }

  @Test
  void mapResponse() {
    ProductDTO response = mapper
        .mapResponse(new ProductEntity("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(ProductDTO.class, response);
  }

  @Test
  void mapResponseNull() {
    ProductDTO response = mapper.mapResponse(null);

    Assertions.assertNull(response);
  }

  @Test
  void priceDTOListToPriceEntityList() {
    List<PriceEntity> response = mapper.priceDTOListToPriceEntityList(List.of(new PriceDTO(), new PriceDTO()));

    Assertions.assertNotNull(response);
    Assertions.assertEquals(2, response.size());
  }

  @Test
  void priceDTOListToPriceListNull() {
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