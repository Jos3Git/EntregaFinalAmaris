package com.example.inbounds.mappers;

import com.example.commons.dtos.BrandDTO;
import com.example.commons.dtos.PriceDTO;
import com.example.commons.dtos.ProductDTO;
import com.example.domain.vos.Brand;
import com.example.domain.vos.Price;
import com.example.domain.vos.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BrandDomainToDTOMapperImplTest {

  BrandDomainToDTOMapperImpl mapper = new BrandDomainToDTOMapperImpl();

  @Test
  void mapResponseList() {
    List<BrandDTO> response = mapper.mapResponseList(List.of(new Brand("1", "Zara", null), new Brand("2", "Zara2", null)));

    Assertions.assertNotNull(response);
    Assertions.assertEquals(2, response.size());
  }

  @Test
  void mapResponseNullList() {
    List<BrandDTO> response = mapper.mapResponseList(null);
    Assertions.assertNull(response);
  }

  @Test
  void mapRequest() {
    Brand response = mapper.mapRequest(new BrandDTO("1", "Zara", null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(Brand.class, response);
  }

  @Test
  void mapRequestNull() {
    Brand response = mapper.mapRequest(null);
    Assertions.assertNull(response);
  }

  @Test
  void mapResponse() {
    BrandDTO response = mapper.mapResponse(new Brand("1", "Zara", null));

    Assertions.assertNotNull(response);
    Assertions.assertInstanceOf(BrandDTO.class, response);
  }

  @Test
  void mapResponseNull() {
    BrandDTO response = mapper.mapResponse(null);

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