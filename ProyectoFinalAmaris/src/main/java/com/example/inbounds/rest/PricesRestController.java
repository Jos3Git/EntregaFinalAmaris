package com.example.inbounds.rest;

import com.example.inbounds.mappers.PriceDomainToDTOMapper;
import com.example.commons.constans.Constants;
import com.example.commons.dtos.PriceDTO;
import com.example.inbounds.ports.PriceInPort;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(Constants.URIPRICES)
public class PricesRestController {

  private PriceInPort priceInPort;

  private PriceDomainToDTOMapper priceDomainToDTOMapper;

  @GetMapping
  public List<PriceDTO> findAll() {
    return priceInPort.findAll().stream().map(price -> priceDomainToDTOMapper.mapResponse(price)).collect(Collectors.toList());
  }

  @GetMapping(Constants.URIFINDBYFILTER1)
  public List<PriceDTO> findAllByProductIdAndBrandIdAndDateAplication(final @PathVariable String idProduct,
      final @PathVariable String idBrand,
      final @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @PathVariable LocalDateTime dateAplication) {
    return priceInPort.findAllByProductIdAndBrandIdAndDateAplication(idProduct, idBrand, dateAplication).stream()
        .map(price -> priceDomainToDTOMapper.mapResponse(price)).collect(Collectors.toList());
  }

}
