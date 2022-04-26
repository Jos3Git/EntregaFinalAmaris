package com.example.outbounds.pricedao;

import com.example.commons.dtos.BrandDTO;
import com.example.commons.dtos.PriceDTO;
import com.example.commons.dtos.ProductDTO;
import com.example.outbounds.mappers.PriceEntityToDTOMapper;
import com.example.outbounds.model.entities.BrandEntity;
import com.example.outbounds.model.entities.PriceEntity;
import com.example.outbounds.model.entities.ProductEntity;
import com.example.outbounds.model.repositories.PriceEntityRepository;
import org.junit.jupiter.api.Assertions;
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
class PriceDAOTest {

  @Mock
  private PriceEntityRepository priceEntityRepository;

  @Mock
  private PriceEntityToDTOMapper priceEntityToDTOMapper;

  @InjectMocks
  PriceDAO priceDAO;

  @Test
  void findAll() {
    when(priceEntityToDTOMapper.mapResponse(Mockito.any()))
        .thenReturn(new PriceDTO("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "aaa", new BrandDTO(), new ProductDTO()));

    when(priceEntityRepository.findAll()).thenReturn(
        List.of(new PriceEntity("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "aaa", new BrandEntity(), new ProductEntity()),
            new PriceEntity("2", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "aaa", new BrandEntity(), new ProductEntity())));

    List<PriceDTO> response = priceDAO.findAll();

    Assertions.assertNotNull(response);
    verify(priceEntityRepository).findAll();
    verify(priceEntityToDTOMapper, times(2)).mapResponse(Mockito.any());
  }

  @Test
  void findAllByProductIdAndBrandIdAndDateAplication() {

    when(priceEntityRepository.findAllByProductIdAndBrandId(Mockito.any(), Mockito.any())).thenReturn(
        List.of(new PriceEntity("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "aaa", new BrandEntity(), new ProductEntity()),
            new PriceEntity("2", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "aaa", new BrandEntity(), new ProductEntity())));

    List<PriceDTO> response = priceDAO.findAllByProductIdAndBrandIdAndDateAplication("1", "1", LocalDateTime.now());

    Assertions.assertNotNull(response);
    verify(priceEntityRepository).findAllByProductIdAndBrandId(Mockito.any(), Mockito.any());
  }

  @Test
  void findByProductIdAndPricelist() {
    when(priceEntityRepository.findByProductIdAndPricelist(Mockito.any(), Mockito.any())).thenReturn(
        new PriceEntity("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "aaa", new BrandEntity(), new ProductEntity()));

    when(priceEntityToDTOMapper.mapResponse(Mockito.any()))
        .thenReturn(new PriceDTO("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "aaa", new BrandDTO(), new ProductDTO()));

    PriceDTO response = priceDAO.findByProductIdAndPricelist(Mockito.any(), Mockito.any());

    Assertions.assertNotNull(response);
    verify(priceEntityRepository).findByProductIdAndPricelist(Mockito.any(), Mockito.any());
  }

  @Test
  void update() {
    when(priceEntityToDTOMapper.mapRequest(Mockito.any())).thenReturn(
        new PriceEntity("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "aaa", new BrandEntity(), new ProductEntity()));

    when(priceEntityToDTOMapper.mapResponse(Mockito.any()))
        .thenReturn(new PriceDTO("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "aaa", new BrandDTO(), new ProductDTO()));

    when(priceEntityRepository.save(Mockito.any())).thenReturn(
        new PriceEntity("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "aaa", new BrandEntity(), new ProductEntity()));

    PriceDTO response = priceDAO.update(Mockito.any());

    Assertions.assertNotNull(response);
    verify(priceEntityRepository).save(Mockito.any());
    verify(priceEntityToDTOMapper).mapResponse(Mockito.any());
    verify(priceEntityToDTOMapper).mapRequest(Mockito.any());
  }
}