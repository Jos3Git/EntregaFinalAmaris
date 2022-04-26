package com.example.outbounds.productdao;

import com.example.commons.dtos.ProductDTO;
import com.example.outbounds.mappers.ProductEntityToDTOMapper;
import com.example.outbounds.model.entities.ProductEntity;
import com.example.outbounds.model.repositories.ProductEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductDAOTest {

  @Mock
  private ProductEntityRepository productEntityRepository;
  @Mock
  private ProductEntityToDTOMapper productEntityToDTOMapper;
  @InjectMocks
  ProductDAO productDAO;

  @Test
  void findAll() {
    when(productEntityToDTOMapper.mapResponse(Mockito.any())).thenReturn(new ProductDTO());

    when(productEntityRepository.findAll()).thenReturn(List.of(new ProductEntity(), new ProductEntity()));

    List<ProductDTO> response = productDAO.findAll();

    Assertions.assertNotNull(response);
    verify(productEntityRepository).findAll();
    verify(productEntityToDTOMapper, times(2)).mapResponse(Mockito.any());

  }

  @Test
  void findById() {
    when(productEntityToDTOMapper.mapResponse(Mockito.any())).thenReturn(new ProductDTO());

    when(productEntityRepository.findById(Mockito.any())).thenReturn(Optional.of(new ProductEntity()));

    ProductDTO response = productDAO.findById(Mockito.any());

    Assertions.assertNotNull(response);
    verify(productEntityRepository).findById(Mockito.any());
    verify(productEntityToDTOMapper).mapResponse(Mockito.any());
  }

  @Test
  void save() {
    when(productEntityToDTOMapper.mapRequest(Mockito.any())).thenReturn(new ProductEntity());

    when(productEntityToDTOMapper.mapResponse(Mockito.any())).thenReturn(new ProductDTO());

    when(productEntityRepository.save(Mockito.any())).thenReturn(new ProductEntity());

    ProductDTO response = productDAO.save(Mockito.any());

    Assertions.assertNotNull(response);
    verify(productEntityRepository).save(Mockito.any());
    verify(productEntityToDTOMapper).mapResponse(Mockito.any());
    verify(productEntityToDTOMapper).mapRequest(Mockito.any());
  }

  @Test
  void update() {
    when(productEntityToDTOMapper.mapRequest(Mockito.any())).thenReturn(new ProductEntity());

    when(productEntityToDTOMapper.mapResponse(Mockito.any())).thenReturn(new ProductDTO());

    when(productEntityRepository.save(Mockito.any())).thenReturn(new ProductEntity());

    ProductDTO response = productDAO.update(Mockito.any());

    Assertions.assertNotNull(response);
    verify(productEntityRepository).save(Mockito.any());
    verify(productEntityToDTOMapper).mapResponse(Mockito.any());
    verify(productEntityToDTOMapper).mapRequest(Mockito.any());
  }

  @Test
  void deleteById() {
    doNothing().when(productEntityRepository).deleteById(Mockito.any());
    productDAO.deleteById(Mockito.any());

    verify(productEntityRepository).deleteById(Mockito.any());
  }
}