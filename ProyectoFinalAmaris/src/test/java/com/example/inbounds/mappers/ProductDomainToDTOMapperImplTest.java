package com.example.inbounds.mappers;

import com.example.commons.dtos.BrandDTO;
import com.example.commons.dtos.PriceDTO;
import com.example.commons.dtos.ProductDTO;
import com.example.domain.vos.Brand;
import com.example.domain.vos.Price;
import com.example.domain.vos.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDomainToDTOMapperImplTest {

  ProductDomainToDTOMapperImpl mapper = new ProductDomainToDTOMapperImpl();

  @Test
  void mapResponseList() {
    List<ProductDTO> response = mapper
        .mapResponseList(List.of(new Product("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null),
            new Product("2", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null)));

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
    Product response = mapper
        .mapRequest(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(Product.class, response);
  }

  @Test
  void mapRequestNull() {
    Product response = mapper.mapRequest(null);
    Assertions.assertNull(response);
  }

  @Test
  void mapResponse() {
    ProductDTO response = mapper
        .mapResponse(new Product("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(ProductDTO.class, response);
  }

  @Test
  void mapResponseNull() {
    ProductDTO response = mapper.mapResponse(null);

    Assertions.assertNull(response);
  }

  @Test
  void priceDTOListToPriceList() {
    List<Price> response = mapper.priceDTOListToPriceList(List.of(new PriceDTO(), new PriceDTO()));

    Assertions.assertNotNull(response);
    Assertions.assertEquals(2, response.size());
  }

  @Test
  void priceDTOListToPriceListNull() {
    List<Price> response = mapper.priceDTOListToPriceList(null);

    Assertions.assertNull(response);
  }

  @Test
  void brandDTOToBrand() {
    Brand response = mapper.brandDTOToBrand(new BrandDTO("1", "Zara", null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(Brand.class, response);
  }

  @Test
  void brandDTOToBrandNull() {
    Brand response = mapper.brandDTOToBrand(null);

    Assertions.assertNull(response);
  }

  @Test
  void priceDTOToPrice() {
    Price response = mapper.priceDTOToPrice(new PriceDTO());

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(Price.class, response);
  }

  @Test
  void priceDTOToPriceNull() {
    Price response = mapper.priceDTOToPrice(null);

    Assertions.assertNull(response);
  }
}