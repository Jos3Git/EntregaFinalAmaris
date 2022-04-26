package com.example.commons.dtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDTOTest {

  ProductDTO productDTO = new ProductDTO("1", LocalDateTime.of(2022, 1, 1, 1, 1), LocalDateTime.of(2022, 1, 1, 1, 1), "nombre", 1L,
      LocalDateTime.of(2022, 1, 1, 1, 1), null);

  @Test
  void noArgsConstructor() {
    ProductDTO productDTO2 = new ProductDTO();
    Assertions.assertInstanceOf(ProductDTO.class, productDTO2);
  }

  @Test
  void getId() {
    Assertions.assertEquals("1", productDTO.getId());
  }

  @Test
  void getCreateAt() {
    Assertions.assertEquals(LocalDateTime.of(2022, 1, 1, 1, 1), productDTO.getCreateAt());
  }

  @Test
  void getUpdateAt() {
    Assertions.assertEquals(LocalDateTime.of(2022, 1, 1, 1, 1), productDTO.getUpdateAt());
  }

  @Test
  void getName() {
    Assertions.assertEquals("nombre", productDTO.getName());
  }

  @Test
  void getCategory() {
    Assertions.assertEquals(1L, productDTO.getCategory());
  }

  @Test
  void getEndOfSalesDate() {
    Assertions.assertEquals(LocalDateTime.of(2022, 1, 1, 1, 1), productDTO.getEndOfSalesDate());
  }

  @Test
  void getPrices() {
    Assertions.assertNull(productDTO.getPrices());
  }

  @Test
  void setId() {
    productDTO.setId("2");
    Assertions.assertEquals("2", productDTO.getId());
  }

  @Test
  void setCreateAt() {
    productDTO.setCreateAt(LocalDateTime.of(2022, 2, 2, 2, 2));
    Assertions.assertEquals(LocalDateTime.of(2022, 2, 2, 2, 2), productDTO.getCreateAt());
  }

  @Test
  void setUpdateAt() {
    productDTO.setUpdateAt(LocalDateTime.of(2022, 2, 2, 2, 2));
    Assertions.assertEquals(LocalDateTime.of(2022, 2, 2, 2, 2), productDTO.getUpdateAt());
  }

  @Test
  void setName() {
    productDTO.setName("name2");
    Assertions.assertEquals("name2", productDTO.getName());
  }

  @Test
  void setCategory() {
    productDTO.setCategory(2L);
    Assertions.assertEquals(2L, productDTO.getCategory());
  }

  @Test
  void setEndOfSalesDate() {
    productDTO.setEndOfSalesDate(LocalDateTime.of(2022, 2, 2, 2, 2));
    Assertions.assertEquals(LocalDateTime.of(2022, 2, 2, 2, 2), productDTO.getEndOfSalesDate());
  }

  @Test
  void setPrices() {
    productDTO.setPrices(List.of(new PriceDTO(), new PriceDTO()));
    Assertions.assertNotNull(productDTO.getPrices());
    Assertions.assertEquals(2, productDTO.getPrices().size());
  }

  @Test
  void testEquals() {
    ProductDTO productDTO2 = new ProductDTO("1", LocalDateTime.of(2022, 1, 1, 1, 1), LocalDateTime.of(2022, 1, 1, 1, 1), "nombre", 1L,
        LocalDateTime.of(2022, 1, 1, 1, 1), null);
    ProductDTO productDTO3 = new ProductDTO("1", LocalDateTime.of(2022, 1, 1, 1, 1), LocalDateTime.of(2022, 1, 1, 1, 1), "nombre", 1L,
        LocalDateTime.of(2022, 1, 1, 1, 1), null);

    Assertions.assertTrue(productDTO2.equals(productDTO3));
  }

  @Test
  void testHashCode() {
    ProductDTO productDTO2 = new ProductDTO("1", LocalDateTime.of(2022, 1, 1, 1, 1), LocalDateTime.of(2022, 1, 1, 1, 1), "nombre", 1L,
        LocalDateTime.of(2022, 1, 1, 1, 1), null);
    ProductDTO productDTO3 = new ProductDTO("1", LocalDateTime.of(2022, 1, 1, 1, 1), LocalDateTime.of(2022, 1, 1, 1, 1), "nombre", 1L,
        LocalDateTime.of(2022, 1, 1, 1, 1), null);

    Assertions.assertTrue(productDTO2.hashCode() == productDTO3.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertNotNull(productDTO.toString());
    Assertions.assertTrue(productDTO.toString().length() > 0);
  }
}