package com.example.outbounds.model.entities;

import com.example.domain.vos.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

class ProductEntityTest {

  ProductEntity product = new ProductEntity("1", LocalDateTime.of(2022, 1, 1, 1, 1), LocalDateTime.of(2022, 1, 1, 1, 1), "nombre", 1L,
      LocalDateTime.of(2022, 1, 1, 1, 1), null);

  @Test
  void noArgsConstructor() {
    ProductEntity productDTO2 = new ProductEntity();
    Assertions.assertInstanceOf(ProductEntity.class, productDTO2);
  }

  @Test
  void getId() {
    Assertions.assertEquals("1", product.getId());
  }

  @Test
  void getCreateAt() {
    Assertions.assertEquals(LocalDateTime.of(2022, 1, 1, 1, 1), product.getCreateAt());
  }

  @Test
  void getUpdateAt() {
    Assertions.assertEquals(LocalDateTime.of(2022, 1, 1, 1, 1), product.getUpdateAt());
  }

  @Test
  void getName() {
    Assertions.assertEquals("nombre", product.getName());
  }

  @Test
  void getCategory() {
    Assertions.assertEquals(1L, product.getCategory());
  }

  @Test
  void getEndOfSalesDate() {
    Assertions.assertEquals(LocalDateTime.of(2022, 1, 1, 1, 1), product.getEndOfSalesDate());
  }

  @Test
  void getPrices() {
    Assertions.assertNull(product.getPrices());
  }

  @Test
  void setId() {
    product.setId("2");
    Assertions.assertEquals("2", product.getId());
  }

  @Test
  void setCreateAt() {
    product.setCreateAt(LocalDateTime.of(2022, 2, 2, 2, 2));
    Assertions.assertEquals(LocalDateTime.of(2022, 2, 2, 2, 2), product.getCreateAt());
  }

  @Test
  void setUpdateAt() {
    product.setUpdateAt(LocalDateTime.of(2022, 2, 2, 2, 2));
    Assertions.assertEquals(LocalDateTime.of(2022, 2, 2, 2, 2), product.getUpdateAt());
  }

  @Test
  void setName() {
    product.setName("name2");
    Assertions.assertEquals("name2", product.getName());
  }

  @Test
  void setCategory() {
    product.setCategory(2L);
    Assertions.assertEquals(2L, product.getCategory());
  }

  @Test
  void setEndOfSalesDate() {
    product.setEndOfSalesDate(LocalDateTime.of(2022, 2, 2, 2, 2));
    Assertions.assertEquals(LocalDateTime.of(2022, 2, 2, 2, 2), product.getEndOfSalesDate());
  }

  @Test
  void setPrices() {
    product.setPrices(List.of(new PriceEntity(), new PriceEntity()));
    Assertions.assertNotNull(product.getPrices());
    Assertions.assertEquals(2, product.getPrices().size());
  }

  @Test
  void testEquals() {
    ProductEntity product2 = new ProductEntity("1", LocalDateTime.of(2022, 1, 1, 1, 1), LocalDateTime.of(2022, 1, 1, 1, 1), "nombre", 1L,
        LocalDateTime.of(2022, 1, 1, 1, 1), null);
    ProductEntity product3 = new ProductEntity("1", LocalDateTime.of(2022, 1, 1, 1, 1), LocalDateTime.of(2022, 1, 1, 1, 1), "nombre", 1L,
        LocalDateTime.of(2022, 1, 1, 1, 1), null);

    Assertions.assertTrue(product2.equals(product3));
  }

  @Test
  void testHashCode() {
    ProductEntity product2 = new ProductEntity("1", LocalDateTime.of(2022, 1, 1, 1, 1), LocalDateTime.of(2022, 1, 1, 1, 1), "nombre", 1L,
        LocalDateTime.of(2022, 1, 1, 1, 1), null);
    ProductEntity product3 = new ProductEntity("1", LocalDateTime.of(2022, 1, 1, 1, 1), LocalDateTime.of(2022, 1, 1, 1, 1), "nombre", 1L,
        LocalDateTime.of(2022, 1, 1, 1, 1), null);

    Assertions.assertTrue(product2.hashCode() == product3.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertNotNull(product.toString());
    Assertions.assertTrue(product.toString().length() > 0);
  }

}