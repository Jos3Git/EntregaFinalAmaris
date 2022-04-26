package com.example.commons.configuration;

import com.example.outbounds.model.entities.BrandEntity;
import com.example.outbounds.model.entities.PriceEntity;
import com.example.outbounds.model.entities.ProductEntity;
import com.example.outbounds.model.repositories.BrandEntityRepository;
import com.example.outbounds.model.repositories.PriceEntityRepository;
import com.example.outbounds.model.repositories.ProductEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@AllArgsConstructor
public class AppConfiguration {

  private final PriceEntityRepository priceEntityRepository;

  private final ProductEntityRepository productEntityRepository;

  private final BrandEntityRepository brandEntityRepository;

  @Bean
  public void inicializarBBDD() {
    final int year = 2020;
    final int zero = 0;
    final int one = 1;
    final int two = 2;
    final int three = 3;
    final int four = 4;
    final int six = 6;
    final int ten = 10;
    final int eleven = 11;
    final int twelve = 12;
    final int fourteen = 14;
    final int fifteen = 15;
    final int sixteen = 16;
    final int eightteen = 18;
    final int twentythree = 23;
    final int thirty = 30;
    final int thirtyone = 31;
    final int fiftynine = 59;

    final Double value1 = 35.50;
    final Double value2 = 25.45;
    final Double value3 = 30.50;
    final Double value4 = 38.95;

    String currency = "EUR";
    LocalDateTime productDatedate = LocalDateTime.of(year, ten, ten, ten, ten, ten);
    LocalDateTime date1 = LocalDateTime.of(year, six, fourteen, zero, zero, zero);
    LocalDateTime date2 = LocalDateTime.of(year, twelve, thirtyone, twentythree, fiftynine, fiftynine);
    LocalDateTime date3 = LocalDateTime.of(year, six, fourteen, fifteen, zero, zero);
    LocalDateTime date4 = LocalDateTime.of(year, six, fourteen, eightteen, thirty, zero);
    LocalDateTime date5 = LocalDateTime.of(year, six, fifteen, zero, zero, zero);
    LocalDateTime date6 = LocalDateTime.of(year, six, fifteen, eleven, zero, zero);
    LocalDateTime date7 = LocalDateTime.of(year, six, fifteen, sixteen, zero, zero);
    LocalDateTime date8 = LocalDateTime.of(year, twelve, thirtyone, twentythree, fiftynine, fiftynine);
    ProductEntity product = new ProductEntity("35455", productDatedate, productDatedate, "itemExample", 1L, productDatedate, null);
    productEntityRepository.save(product);
    BrandEntity brandEntity = new BrandEntity("1", "Zara", null);
    brandEntityRepository.save(brandEntity);

    PriceEntity price1 = new PriceEntity("1", date1, date2, one, zero, value1, currency, brandEntity, product);
    PriceEntity price2 = new PriceEntity("2", date3, date4, two, one, value2, currency, brandEntity, product);
    PriceEntity price3 = new PriceEntity("3", date5, date6, three, one, value3, currency, brandEntity, product);
    PriceEntity price4 = new PriceEntity("4", date7, date8, four, one, value4, currency, brandEntity, product);
    priceEntityRepository.save(price1);
    priceEntityRepository.save(price2);
    priceEntityRepository.save(price3);
    priceEntityRepository.save(price4);
  }
}
