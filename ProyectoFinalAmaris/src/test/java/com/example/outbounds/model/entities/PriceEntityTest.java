package com.example.outbounds.model.entities;

import com.example.domain.vos.Brand;
import com.example.domain.vos.Price;
import com.example.domain.vos.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PriceEntityTest {

  PriceEntity price = new PriceEntity("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR",
      new BrandEntity(), new ProductEntity());

  @Test
  void noArgsConstructor() {
    PriceEntity price2 = new PriceEntity();
    Assertions.assertNotNull(price2);
    Assertions.assertInstanceOf(PriceEntity.class, price2);
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
    Assertions.assertInstanceOf(BrandEntity.class, price.getBrand());
  }

  @Test
  void getProduct() {
    Assertions.assertInstanceOf(ProductEntity.class, price.getProduct());
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
    BrandEntity brand = new BrandEntity("1", "Zara", null);
    price.setBrand(brand);
    Assertions.assertEquals(brand, price.getBrand());
  }

  @Test
  void setProduct() {
    ProductEntity product = new ProductEntity("1", LocalDateTime.now(), LocalDateTime.now(), "aaaaa", 1L, LocalDateTime.now(), null);
    price.setProduct(product);
    Assertions.assertEquals(product, price.getProduct());
  }

  @Test
  void testEquals() {
    PriceEntity price2 = new PriceEntity("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR",
        new BrandEntity(), new ProductEntity());

    PriceEntity price3 = new PriceEntity("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR",
        new BrandEntity(), new ProductEntity());

    Assertions.assertTrue(price2.equals(price3));
  }

  @Test
  void testHashCode() {
    PriceEntity price2 = new PriceEntity("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR",
        new BrandEntity(), new ProductEntity());

    PriceEntity price3 = new PriceEntity("1", LocalDateTime.of(2022, 1, 1, 10, 10), LocalDateTime.of(2022, 1, 1, 10, 10), 1, 1, 10D, "EUR",
        new BrandEntity(), new ProductEntity());

    Assertions.assertTrue(price2.hashCode() == price3.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertNotNull(price.toString());
    Assertions.assertTrue(price.toString().length() > 0);
  }

}