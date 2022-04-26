package com.example.commons.dtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class PriceDTOTest {

  PriceDTO priceDTO = new PriceDTO("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR",
      new BrandDTO(), new ProductDTO());

  @Test
  void noArgsConstructor() {
    PriceDTO priceDTO2 = new PriceDTO();
    Assertions.assertNotNull(priceDTO2);
    Assertions.assertInstanceOf(PriceDTO.class, priceDTO2);
  }

  @Test
  void getId() {
    Assertions.assertEquals("1", priceDTO.getId());
  }

  @Test
  void getStartdate() {
    Assertions.assertEquals(LocalDateTime.of(2022, 1, 1, 10, 10), priceDTO.getStartdate());
  }

  @Test
  void getEnddate() {
    Assertions.assertEquals(LocalDateTime.of(2022, 1, 1, 10, 10), priceDTO.getEnddate());
  }

  @Test
  void getPricelist() {
    Assertions.assertEquals(1, priceDTO.getPricelist());
  }

  @Test
  void getPriority() {
    Assertions.assertEquals(1, priceDTO.getPriority());
  }

  @Test
  void getPrice() {
    Assertions.assertEquals(10D, priceDTO.getPrice());
  }

  @Test
  void getCurr() {
    Assertions.assertEquals("EUR", priceDTO.getCurr());
  }

  @Test
  void getBrand() {
    Assertions.assertInstanceOf(BrandDTO.class, priceDTO.getBrand());
  }

  @Test
  void getProduct() {
    Assertions.assertInstanceOf(ProductDTO.class, priceDTO.getProduct());
  }

  @Test
  void setId() {
    priceDTO.setId("2");
    Assertions.assertEquals("2", priceDTO.getId());
  }

  @Test
  void setStartdate() {
    priceDTO.setStartdate(LocalDateTime.of(2022, 12, 12, 1, 1));
    Assertions.assertEquals(LocalDateTime.of(2022, 12, 12, 1, 1), priceDTO.getStartdate());
  }

  @Test
  void setEnddate() {
    priceDTO.setEnddate(LocalDateTime.of(2022, 12, 12, 1, 1));
    Assertions.assertEquals(LocalDateTime.of(2022, 12, 12, 1, 1), priceDTO.getEnddate());
  }

  @Test
  void setPricelist() {
    priceDTO.setPricelist(2);
    Assertions.assertEquals(2, priceDTO.getPricelist());
  }

  @Test
  void setPriority() {
    priceDTO.setPriority(2);
    Assertions.assertEquals(2, priceDTO.getPriority());
  }

  @Test
  void setPrice() {
    priceDTO.setPrice(100D);
    Assertions.assertEquals(100D, priceDTO.getPrice());
  }

  @Test
  void setCurr() {
    priceDTO.setCurr("AAA");
    Assertions.assertEquals("AAA", priceDTO.getCurr());
  }

  @Test
  void setBrand() {
    BrandDTO brandDTO = new BrandDTO("1", "Zara", null);
    priceDTO.setBrand(brandDTO);
    Assertions.assertEquals(brandDTO, priceDTO.getBrand());
  }

  @Test
  void setProduct() {
    ProductDTO productDTO = new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "aaaaa", 1L, LocalDateTime.now(), null);
    priceDTO.setProduct(productDTO);
    Assertions.assertEquals(productDTO, priceDTO.getProduct());
  }

  @Test
  void testEquals() {
    PriceDTO priceDTO2 = new PriceDTO("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR",
        new BrandDTO(), new ProductDTO());

    PriceDTO priceDTO3 = new PriceDTO("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR",
        new BrandDTO(), new ProductDTO());

    Assertions.assertTrue(priceDTO2.equals(priceDTO3));
  }

  @Test
  void testHashCode() {
    PriceDTO priceDTO2 = new PriceDTO("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR",
        new BrandDTO(), new ProductDTO());

    PriceDTO priceDTO3 = new PriceDTO("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR",
        new BrandDTO(), new ProductDTO());

    Assertions.assertTrue(priceDTO2.hashCode() == priceDTO3.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertNotNull(priceDTO.toString());
    Assertions.assertTrue(priceDTO.toString().length() > 0);
  }
}