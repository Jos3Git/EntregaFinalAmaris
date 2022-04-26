package com.example.domain.vos;

import com.example.commons.dtos.BrandDTO;
import com.example.commons.dtos.PriceDTO;
import com.example.commons.dtos.ProductDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class PriceTest {

  Price price = new Price("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR", new Brand(),
      new Product());

  @Test
  void noArgsConstructor() {
    Price price2 = new Price();
    Assertions.assertNotNull(price2);
    Assertions.assertInstanceOf(Price.class, price2);
  }

  @Test
  void getId() {
    Assertions.assertEquals("1", price.getId());
  }

  @Test
  void getStartdate() {
    Assertions.assertEquals(LocalDateTime.of(2022, 1, 1, 10, 10), price.getStartdate());
  }

  @Test
  void getEnddate() {
    Assertions.assertEquals(LocalDateTime.of(2022, 1, 1, 10, 10), price.getEnddate());
  }

  @Test
  void getPricelist() {
    Assertions.assertEquals(1, price.getPricelist());
  }

  @Test
  void getPriority() {
    Assertions.assertEquals(1, price.getPriority());
  }

  @Test
  void getPrice() {
    Assertions.assertEquals(10D, price.getPrice());
  }

  @Test
  void getCurr() {
    Assertions.assertEquals("EUR", price.getCurr());
  }

  @Test
  void getBrand() {
    Assertions.assertInstanceOf(Brand.class, price.getBrand());
  }

  @Test
  void getProduct() {
    Assertions.assertInstanceOf(Product.class, price.getProduct());
  }

  @Test
  void setId() {
    price.setId("2");
    Assertions.assertEquals("2", price.getId());
  }

  @Test
  void setStartdate() {
    price.setStartdate(LocalDateTime.of(2022, 12, 12, 1, 1));
    Assertions.assertEquals(LocalDateTime.of(2022, 12, 12, 1, 1), price.getStartdate());
  }

  @Test
  void setEnddate() {
    price.setEnddate(LocalDateTime.of(2022, 12, 12, 1, 1));
    Assertions.assertEquals(LocalDateTime.of(2022, 12, 12, 1, 1), price.getEnddate());
  }

  @Test
  void setPricelist() {
    price.setPricelist(2);
    Assertions.assertEquals(2, price.getPricelist());
  }

  @Test
  void setPriority() {
    price.setPriority(2);
    Assertions.assertEquals(2, price.getPriority());
  }

  @Test
  void setPrice() {
    price.setPrice(100D);
    Assertions.assertEquals(100D, price.getPrice());
  }

  @Test
  void setCurr() {
    price.setCurr("AAA");
    Assertions.assertEquals("AAA", price.getCurr());
  }

  @Test
  void setBrand() {
    Brand brand = new Brand("1", "Zara", null);
    price.setBrand(brand);
    Assertions.assertEquals(brand, price.getBrand());
  }

  @Test
  void setProduct() {
    Product product = new Product("1", LocalDateTime.now(), LocalDateTime.now(), "aaaaa", 1L, LocalDateTime.now(), null);
    price.setProduct(product);
    Assertions.assertEquals(product, price.getProduct());
  }

  @Test
  void testEquals() {
    Price price2 = new Price("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR", new Brand(),
        new Product());

    Price price3 = new Price("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR", new Brand(),
        new Product());

    Assertions.assertTrue(price2.equals(price3));
  }

  @Test
  void testHashCode() {
    Price price2 = new Price("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR", new Brand(),
        new Product());

    Price price3 = new Price("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR", new Brand(),
        new Product());

    Assertions.assertTrue(price2.hashCode() == price3.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertNotNull(price.toString());
    Assertions.assertTrue(price.toString().length() > 0);
  }

}