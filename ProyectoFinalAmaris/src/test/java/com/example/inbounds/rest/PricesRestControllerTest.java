package com.example.inbounds.rest;

import com.example.commons.dtos.BrandDTO;
import com.example.commons.dtos.PriceDTO;
import com.example.commons.dtos.ProductDTO;
import com.example.domain.vos.Brand;
import com.example.domain.vos.Price;
import com.example.domain.vos.Product;
import com.example.inbounds.mappers.PriceDomainToDTOMapperImpl;
import com.example.inbounds.ports.PriceInPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesRestControllerTest {


  @Mock
  private PriceInPort priceInPort;

  @Mock
  private PriceDomainToDTOMapperImpl priceDomainToDTOMapper;

  @InjectMocks
  private PricesRestController pricesRestController;


  @Test
  void findAll() {
    String currency = "EUR";
    LocalDateTime productDatedate = LocalDateTime.of(2020, 10, 10, 10, 10, 10);
    LocalDateTime date1 = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
    LocalDateTime date2 = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
    LocalDateTime date3 = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
    LocalDateTime date4 = LocalDateTime.of(2020, 6, 14, 18, 30, 0);
    Brand brand = new Brand("1", "Zara", null);
    Product product = new Product("35455", productDatedate, productDatedate, "itemExample", 1L, productDatedate, null);

    when(priceInPort.findAll()).thenReturn(List.of(new Price("1", date1, date2, 1, 0, 35.50, currency, brand, product),
        new Price("2", date3, date4, 2, 1, 25.45, currency, brand, product)));

    BrandDTO branddto = new BrandDTO("1", "Zara", null);
    ProductDTO productdto = new ProductDTO("35455", productDatedate, productDatedate, "itemExample", 1L, productDatedate, null);

    when(priceDomainToDTOMapper.mapResponse(Mockito.any()))
        .thenReturn(new PriceDTO("1", date1, date2, 1, 0, 35.50, currency, branddto, productdto));

    List<PriceDTO> response = pricesRestController.findAll();

    Assertions.assertNotNull(response);
    Assertions.assertTrue(response.size() > 0);
    Assertions.assertEquals(2, response.size());

  }

  @Test
  void findAllByProductIdAndBrandIdAndDateAplication() {
    String currency = "EUR";
    LocalDateTime productDatedate = LocalDateTime.of(2020, 10, 10, 10, 10, 10);
    LocalDateTime date1 = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
    LocalDateTime date2 = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
    LocalDateTime date3 = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
    LocalDateTime date4 = LocalDateTime.of(2020, 6, 14, 18, 30, 0);
    Brand brand = new Brand("1", "Zara", null);
    Product product = new Product("35455", productDatedate, productDatedate, "itemExample", 1L, productDatedate, null);

    when(priceInPort.findAllByProductIdAndBrandIdAndDateAplication(Mockito.any(), Mockito.any(), Mockito.any()))
        .thenReturn(List.of(new Price("1", date1, date2, 1, 0, 35.50, currency, brand, product),
            new Price("2", date3, date4, 2, 1, 25.45, currency, brand, product)));

    BrandDTO branddto = new BrandDTO("1", "Zara", null);
    ProductDTO productdto = new ProductDTO("35455", productDatedate, productDatedate, "itemExample", 1L, productDatedate, null);

    when(priceDomainToDTOMapper.mapResponse(Mockito.any()))
        .thenReturn(new PriceDTO("1", date1, date2, 1, 0, 35.50, currency, branddto, productdto));

    List<PriceDTO> response = pricesRestController.findAllByProductIdAndBrandIdAndDateAplication("3435", "1", LocalDateTime.now());

    Assertions.assertNotNull(response);
    Assertions.assertTrue(response.size() > 0);
    Assertions.assertEquals(2, response.size());
  }
}