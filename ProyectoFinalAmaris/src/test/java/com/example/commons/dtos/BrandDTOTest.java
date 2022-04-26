package com.example.commons.dtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BrandDTOTest {

  BrandDTO brandDTO = new BrandDTO("1", "Zara", null);

  @Test
  void noArgsConstructor() {
    BrandDTO brandDTO2 = new BrandDTO();
    Assertions.assertInstanceOf(BrandDTO.class, brandDTO2);
  }

  @Test
  void getId() {
    Assertions.assertEquals("1", brandDTO.getId());
  }

  @Test
  void getName() {
    Assertions.assertEquals("Zara", brandDTO.getName());
  }

  @Test
  void getPrices() {
    Assertions.assertNull(brandDTO.getPrices());
  }

  @Test
  void setId() {
    brandDTO.setId("2");
    Assertions.assertEquals("2", brandDTO.getId());
  }

  @Test
  void setName() {
    brandDTO.setName("Pull&Bear");
    Assertions.assertEquals("Pull&Bear", brandDTO.getName());
  }

  @Test
  void setPrices() {
    brandDTO.setPrices(List.of(new PriceDTO(), new PriceDTO()));
    Assertions.assertNotNull(brandDTO.getPrices());
    Assertions.assertEquals(2, brandDTO.getPrices().size());
  }

  @Test
  void testEquals() {
    BrandDTO brandDTO2 = new BrandDTO("1", "Zara", null);
    BrandDTO brandDTO3 = new BrandDTO("1", "Zara", null);

    Assertions.assertTrue(brandDTO2.equals(brandDTO3));
  }

  @Test
  void testHashCode() {
    BrandDTO brandDTO2 = new BrandDTO("1", "Zara", null);
    BrandDTO brandDTO3 = new BrandDTO("1", "Zara", null);

    Assertions.assertTrue(brandDTO2.hashCode() == brandDTO3.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertNotNull(brandDTO.toString());
    Assertions.assertTrue(brandDTO.toString().length() > 0);
  }
}