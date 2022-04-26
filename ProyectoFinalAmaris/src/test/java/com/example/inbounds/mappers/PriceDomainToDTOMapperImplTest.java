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

class PriceDomainToDTOMapperImplTest {

  PriceDomainToDTOMapperImpl mapper = new PriceDomainToDTOMapperImpl();

  @Test
  void mapResponse() {
    PriceDTO response = mapper
        .mapResponse(new Price("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 30D, "EUR", new Brand(), new Product()));

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
    List<PriceDTO> response = mapper
        .mapResponseList(List.of(new Price("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 30D, "EUR", new Brand(), new Product()),
            new Price("2", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 30D, "EUR", new Brand(), new Product())));

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
    Price response = mapper
        .mapRequest(new PriceDTO("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 30D, "EUR", new BrandDTO(), new ProductDTO()));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(Price.class, response);
  }

  @Test
  void mapRequestNull() {
    Price response = mapper.mapRequest(null);

    Assertions.assertNull(response);
  }

  @Test
  void brandToBrandDTO() {
    BrandDTO response = mapper.brandToBrandDTO(new Brand("1", "Zara", null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(BrandDTO.class, response);
  }

  @Test
  void brandToBrandDTONull() {
    BrandDTO response = mapper.brandToBrandDTO(null);

    Assertions.assertNull(response);
  }

  @Test
  void productToProductDTO() {
    ProductDTO response = mapper
        .productToProductDTO(new Product("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(ProductDTO.class, response);
  }

  @Test
  void productToProductDTONull() {
    ProductDTO response = mapper.productToProductDTO(null);

    Assertions.assertNull(response);
  }

  @Test
  void priceDTOListToPriceList() {
    List<Price> response = mapper.priceDTOListToPriceList(
        List.of(new PriceDTO("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 30D, "EUR", new BrandDTO(), new ProductDTO()),
            new PriceDTO("2", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 30D, "EUR", new BrandDTO(), new ProductDTO())));

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
  void productDTOToProduct() {
    Product response = mapper.productDTOToProduct(new ProductDTO());

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(Product.class, response);
  }

  @Test
  void productDTOToProductNull() {

    Product response = mapper.productDTOToProduct(null);

    Assertions.assertNull(response);
  }
}