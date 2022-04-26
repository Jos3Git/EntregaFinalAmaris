package com.example.inbounds.rest;

import com.example.commons.dtos.ProductDTO;
import com.example.domain.vos.Product;
import com.example.inbounds.mappers.ProductDomainToDTOMapperImpl;
import com.example.inbounds.ports.ProductInPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductRestControllerTest {

  @Mock
  private ProductInPort productInPort;

  @Mock
  private ProductDomainToDTOMapperImpl productDomainToDTOMapper;

  @InjectMocks
  private ProductRestController productRestController;

  @Test
  void findAll() {

    when(productInPort.findAll())
        .thenReturn(List.of(new Product("1", LocalDateTime.now(), LocalDateTime.now(), "nombre", 1L, LocalDateTime.now(), null),
            new Product("2", LocalDateTime.now(), LocalDateTime.now(), "nombre", 1L, LocalDateTime.now(), null)));

    when(productDomainToDTOMapper.mapResponse(Mockito.any()))
        .thenReturn(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "nombre", 1L, LocalDateTime.now(), null));

    List<ProductDTO> response = productRestController.findAll();

    Assertions.assertNotNull(response);
    Assertions.assertTrue(response.size() > 0);
    Assertions.assertEquals(2, response.size());
  }

  @Test
  void findById() {

    when(productInPort.findById(Mockito.any()))
        .thenReturn(new Product("1", LocalDateTime.now(), LocalDateTime.now(), "nombre", 1L, LocalDateTime.now(), null)

        );

    when(productDomainToDTOMapper.mapResponse(Mockito.any()))
        .thenReturn(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "nombre", 1L, LocalDateTime.now(), null));

    ResponseEntity<ProductDTO> response = productRestController.findById("1");

    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getBody());
    Assertions.assertInstanceOf(ProductDTO.class, response.getBody());
  }

  @Test
  void findByIdNull() {

    ResponseEntity<ProductDTO> response = productRestController.findById(null);

    Assertions.assertNotNull(response);
    Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  void create() {
    when(productInPort.create(Mockito.any()))
        .thenReturn(new Product("1", LocalDateTime.now(), LocalDateTime.now(), "nombre", 1L, LocalDateTime.now(), null)

        );

    when(productDomainToDTOMapper.mapResponse(Mockito.any()))
        .thenReturn(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "nombre", 1L, LocalDateTime.now(), null));

    ResponseEntity<ProductDTO> response = productRestController
        .create(new ProductDTO(null, LocalDateTime.now(), LocalDateTime.now(), "nombre", 1L, LocalDateTime.now(), null));

    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getBody());
    Assertions.assertInstanceOf(ProductDTO.class, response.getBody());
  }

  @Test
  void CreateNotNullId() {

    ResponseEntity<ProductDTO> response = productRestController
        .create(new ProductDTO("4", LocalDateTime.now(), LocalDateTime.now(), "nombre", 1L, LocalDateTime.now(), null));

    Assertions.assertNotNull(response);
    Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  void update() {
    when(productInPort.update(Mockito.any()))
        .thenReturn(new Product("1", LocalDateTime.now(), LocalDateTime.now(), "nombre", 1L, LocalDateTime.now(), null)

        );

    when(productDomainToDTOMapper.mapResponse(Mockito.any()))
        .thenReturn(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "nombre", 1L, LocalDateTime.now(), null));

    ResponseEntity<ProductDTO> response = productRestController
        .update(new ProductDTO("1", LocalDateTime.now(), LocalDateTime.now(), "nombre", 1L, LocalDateTime.now(), null));

    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getBody());
    Assertions.assertInstanceOf(ProductDTO.class, response.getBody());
  }

  @Test
  void updateNullId() {

    ResponseEntity<ProductDTO> response = productRestController
        .update(new ProductDTO(null, LocalDateTime.now(), LocalDateTime.now(), "nombre", 1L, LocalDateTime.now(), null));

    Assertions.assertNotNull(response);
    Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  void delete() {
    doNothing().when(productInPort).delete(Mockito.any());

    productRestController.delete("1");

    verify(productInPort).delete("1");
  }
}