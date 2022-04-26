package com.example.domain.services;

import com.example.commons.constans.Constants;
import com.example.commons.dtos.ProductDTO;
import com.example.domain.vos.Product;
import com.example.inbounds.mappers.ProductDomainToDTOMapper;
import com.example.outbounds.ports.ProductCrudProducerOutPort;
import com.example.outbounds.ports.ProductDAOOutPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductUserCaseTest {

  @Mock
  private ProductDAOOutPort productDAOOutPort;
  @Mock
  private ProductCrudProducerOutPort productCrudProducerOutPort;
  @Mock
  private ProductDomainToDTOMapper productDomainToDTOMapper;
  @InjectMocks
  ProductUserCase productUserCase;

  @Test
  void findAll() {
    when(productDAOOutPort.findAll())
        .thenReturn(List.of(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null),
            new ProductDTO("2", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null)));

    when(productDomainToDTOMapper.mapRequest(Mockito.any()))
        .thenReturn(new Product("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    doNothing().when(productCrudProducerOutPort).generateTiles(Mockito.any());

    List<Product> response = productUserCase.findAll();

    verify(productCrudProducerOutPort).generateTiles(Mockito.any());
    verify(productDAOOutPort).findAll();
    Assertions.assertNotNull(response);
  }

  @Test
  void findById() {
    when(productDAOOutPort.findById(Mockito.any()))
        .thenReturn(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    when(productDomainToDTOMapper.mapRequest(Mockito.any()))
        .thenReturn(new Product("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    doNothing().when(productCrudProducerOutPort).generateTiles(Mockito.any());

    Product response = productUserCase.findById("1");

    verify(productCrudProducerOutPort).generateTiles(Mockito.any());
    verify(productDAOOutPort).findById(Mockito.any());
    Assertions.assertNotNull(response);
  }

  @Test
  void create() {
    when(productDomainToDTOMapper.mapRequest(Mockito.any()))
        .thenReturn(new Product(null, LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    when(productDomainToDTOMapper.mapResponse(Mockito.any()))
        .thenReturn(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    when(productDAOOutPort.save(Mockito.any()))
        .thenReturn(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    doNothing().when(productCrudProducerOutPort).generateTiles(Mockito.any());

    Product response = productUserCase
        .create(new ProductDTO(null, LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    verify(productCrudProducerOutPort).generateTiles(Mockito.any());
    verify(productDAOOutPort).save(Mockito.any());
    Assertions.assertNotNull(response);
  }

  @Test
  void createNotNullId() {

    Product response = productUserCase
        .create(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    Assertions.assertNull(response);
  }

  @Test
  void update() {
    when(productDomainToDTOMapper.mapRequest(Mockito.any()))
        .thenReturn(new Product("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    when(productDomainToDTOMapper.mapResponse(Mockito.any()))
        .thenReturn(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    when(productDAOOutPort.update(Mockito.any()))
        .thenReturn(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    doNothing().when(productCrudProducerOutPort).generateTiles(Mockito.any());

    Product response = productUserCase
        .update(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    verify(productCrudProducerOutPort).generateTiles(Mockito.any());
    verify(productDAOOutPort).update(Mockito.any());
    Assertions.assertNotNull(response);
  }

  @Test
  void updateNullId() {

    Product response = productUserCase
        .update(new ProductDTO(null, LocalDateTime.now(), LocalDateTime.now(), "aaa", 1l, LocalDateTime.now(), null));

    Assertions.assertNull(response);
  }

  @Test
  void delete() {
    doNothing().when(productDAOOutPort).deleteById(Mockito.any());

    doNothing().when(productCrudProducerOutPort).generateTiles(Mockito.any());

    productUserCase.delete(Mockito.any());

    verify(productCrudProducerOutPort).generateTiles(Mockito.any());
    verify(productDAOOutPort).deleteById(Mockito.any());

  }
}