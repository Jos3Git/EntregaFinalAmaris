package com.example.domain.services;

import com.example.inbounds.mappers.PriceDomainToDTOMapper;
import com.example.commons.dtos.PriceDTO;
import com.example.domain.vos.Price;
import com.example.inbounds.ports.PriceInPort;
import com.example.outbounds.ports.PriceDAOOutPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PriceUseCase implements PriceInPort {

  private PriceDAOOutPort priceDAOOutPort;

  private PriceDomainToDTOMapper priceDomainToDTOMapper;

  @Override
  public List<Price> findAll() {
    return priceDAOOutPort.findAll().stream().map(price -> priceDomainToDTOMapper.mapRequest(price)).collect(Collectors.toList());
  }

  @Override
  public Price findByProductIdAndPriceListAndUpdate(final String productId, final Integer pricelist, final Double priceValue) {
    PriceDTO priceDTO = priceDAOOutPort.findByProductIdAndPricelist(productId, pricelist);

    if (priceDTO != null) {
      priceDTO.setPrice(priceValue);
      return priceDomainToDTOMapper.mapRequest(priceDAOOutPort.update(priceDTO));
    } else {
      throw new EntityNotFoundException("No se ha encontrado el dato en la tabla prices");
    }
  }

  @Override
  public List<Price> findAllByProductIdAndBrandIdAndDateAplication(final String idProduct, final String idBrand,
      final LocalDateTime dateAplication) {
    return priceDAOOutPort.findAllByProductIdAndBrandIdAndDateAplication(idProduct, idBrand, dateAplication).stream()
        .map(price -> priceDomainToDTOMapper.mapRequest(price)).collect(Collectors.toList());

  }

}
