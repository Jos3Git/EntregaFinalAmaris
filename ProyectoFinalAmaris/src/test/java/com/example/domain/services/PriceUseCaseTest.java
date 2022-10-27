package com.example.domain.services;

import com.example.commons.dtos.BrandDTO;
import com.example.commons.dtos.PriceDTO;
import com.example.commons.dtos.ProductDTO;
import com.example.domain.vos.Brand;
import com.example.domain.vos.Price;
import com.example.domain.vos.Product;
import com.example.inbounds.mappers.PriceDomainToDTOMapper;
import com.example.outbounds.ports.PriceDAOOutPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceUseCaseTest {

  @Mock
  private PriceDAOOutPort priceDAOOutPort;
  @Mock
  private PriceDomainToDTOMapper priceDomainToDTOMapper;

  @InjectMocks
  PriceUseCase priceUseCase;

  @Test
  void findAll() {
    when(priceDAOOutPort.findAll())
        .thenReturn(List.of(new PriceDTO("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "EUR", new BrandDTO(), new ProductDTO()),
            new PriceDTO("2", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "EUR", new BrandDTO(), new ProductDTO())));

    when(priceDomainToDTOMapper.mapRequest(Mockito.any()))
        .thenReturn(new Price("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "EUR", new Brand(), new Product()));

    List<Price> response = priceUseCase.findAll();

    verify(priceDAOOutPort).findAll();
    Assertions.assertNotNull(response);
  }

  @Test
  void findByProductIdAndPriceListAndUpdate() {

    when(priceDAOOutPort.findByProductIdAndPricelist(Mockito.any(), Mockito.any()))
        .thenReturn(new PriceDTO("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "EUR", new BrandDTO(), new ProductDTO()));

    when(priceDAOOutPort.update(Mockito.any()))
        .thenReturn(new PriceDTO("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "EUR", new BrandDTO(), new ProductDTO()));

    when(priceDomainToDTOMapper.mapRequest(Mockito.any()))
        .thenReturn(new Price("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "EUR", new Brand(), new Product()));

    Price response = priceUseCase.findByProductIdAndPriceListAndUpdate("1", 1, 100D);

    verify(priceDAOOutPort).update(Mockito.any());
    verify(priceDAOOutPort).findByProductIdAndPricelist(Mockito.any(), Mockito.any());
    Assertions.assertNotNull(response);
  }

  @Test
  void findByProductIdAndPriceListAndUpdateNotFound() {

    when(priceDAOOutPort.findByProductIdAndPricelist(Mockito.any(), Mockito.any())).thenReturn(null);

    Assertions.assertThrows(EntityNotFoundException.class, () -> priceUseCase.findByProductIdAndPriceListAndUpdate("1", 1, 100D));

  }

  @Test
  void findAllByProductIdAndBrandIdAndDateAplication() {
    when(priceDAOOutPort.findAllByProductIdAndBrandIdAndDateAplication(Mockito.any(), Mockito.any(), Mockito.any()))
        .thenReturn(List.of(new PriceDTO("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "EUR", new BrandDTO(), new ProductDTO()),
            new PriceDTO("2", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "EUR", new BrandDTO(), new ProductDTO())));

    when(priceDomainToDTOMapper.mapRequest(Mockito.any()))
        .thenReturn(new Price("1", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 20D, "EUR", new Brand(), new Product()));

    List<Price> response = priceUseCase.findAllByProductIdAndBrandIdAndDateAplication("1", "1", LocalDateTime.now());

    verify(priceDAOOutPort).findAllByProductIdAndBrandIdAndDateAplication(Mockito.any(), Mockito.any(), Mockito.any());
    Assertions.assertNotNull(response);
  }
}