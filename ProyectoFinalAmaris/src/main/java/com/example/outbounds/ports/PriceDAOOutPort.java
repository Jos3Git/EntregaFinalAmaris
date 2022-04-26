package com.example.outbounds.ports;

import com.example.commons.dtos.PriceDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceDAOOutPort {

  List<PriceDTO> findAll();

  List<PriceDTO> findAllByProductIdAndBrandIdAndDateAplication(String idProduct, String idBrand, LocalDateTime dateAplication);

  PriceDTO findByProductIdAndPricelist(String productId, Integer pricelist);

  PriceDTO update(PriceDTO priceDTO);
}
