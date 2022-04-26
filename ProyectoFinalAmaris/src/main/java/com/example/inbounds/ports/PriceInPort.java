package com.example.inbounds.ports;

import com.example.domain.vos.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceInPort {
  List<Price> findAll();

  Price findByProductIdAndPriceListAndUpdate(String productId, Integer pricelist, Double priceValue);

  List<Price> findAllByProductIdAndBrandIdAndDateAplication(String idProduct, String idBrand, LocalDateTime dateAplication);
}
