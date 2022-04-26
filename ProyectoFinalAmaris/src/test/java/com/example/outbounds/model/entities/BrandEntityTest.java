package com.example.outbounds.model.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BrandEntityTest {

  BrandEntity brand = new BrandEntity("1", "Zara", null);

  @Test
  void noArgsConstructor() {
    BrandEntity brand2 = new BrandEntity();
    Assertions.assertInstanceOf(BrandEntity.class, brand2);
  }

  @Test
  void getId() {
    Assertions.assertEquals("1", brand.getId());
  }

  @Test
  void getName() {
    Assertions.assertEquals("Zara", brand.getName());
  }

  @Test
  void getPrices() {
    Assertions.assertNull(brand.getPrices());
  }

  @Test
  void setId() {
    brand.setId("2");
    Assertions.assertEquals("2", brand.getId());
  }

  @Test
  void setName() {
    brand.setName("Pull&Bear");
    Assertions.assertEquals("Pull&Bear", brand.getName());
  }

  @Test
  void setPrices() {
    brand.setPrices(List.of(new PriceEntity(), new PriceEntity()));
    Assertions.assertNotNull(brand.getPrices());
    Assertions.assertEquals(2, brand.getPrices().size());
  }

  @Test
  void testEquals() {
    BrandEntity brand2 = new BrandEntity("1", "Zara", null);
    BrandEntity brand3 = new BrandEntity("1", "Zara", null);

    Assertions.assertTrue(brand2.equals(brand3));
  }

  @Test
  void testHashCode() {
    BrandEntity brand2 = new BrandEntity("1", "Zara", null);
    BrandEntity brand3 = new BrandEntity("1", "Zara", null);

    Assertions.assertTrue(brand2.hashCode() == brand3.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertNotNull(brand.toString());
    Assertions.assertTrue(brand.toString().length() > 0);
  }
}