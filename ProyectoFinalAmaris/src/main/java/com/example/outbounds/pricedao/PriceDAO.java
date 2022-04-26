package com.example.outbounds.pricedao;

import com.example.outbounds.mappers.PriceEntityToDTOMapper;
import com.example.outbounds.model.entities.PriceEntity;
import com.example.outbounds.model.repositories.PriceEntityRepository;
import com.example.commons.dtos.PriceDTO;
import com.example.outbounds.ports.PriceDAOOutPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PriceDAO implements PriceDAOOutPort {

  private PriceEntityRepository priceEntityRepository;

  private PriceEntityToDTOMapper priceEntityToDTOMapper;

  @Override
  public List<PriceDTO> findAll() {
    return priceEntityRepository.findAll().stream().map(price -> priceEntityToDTOMapper.mapResponse(price)).collect(Collectors.toList());
  }

  @Override
  public List<PriceDTO> findAllByProductIdAndBrandIdAndDateAplication(final String idProduct, final String idBrand,
      final LocalDateTime dateAplication) {
//    return priceEntityRepository
//        .findAllByProductIdAndBrandIdAndEnddateBeforeAndStartdateAfter(idProduct, idBrand, dateAplication, dateAplication).stream()
//        .map(price -> priceEntityToDTOMapper.mapResponse(price)).collect(Collectors.toList());
    return priceEntityRepository.findAllByProductIdAndBrandId(idProduct, idBrand).stream()
        .filter(price -> price.getStartdate().isBefore(dateAplication)).filter(price -> price.getEnddate().isAfter(dateAplication))
        .map(price -> priceEntityToDTOMapper.mapResponse(price)).collect(Collectors.toList());
  }

  @Override
  public PriceDTO findByProductIdAndPricelist(final String productId, final Integer pricelist) {
    return priceEntityToDTOMapper.mapResponse(priceEntityRepository.findByProductIdAndPricelist(productId, pricelist));

  }

  @Override
  public PriceDTO update(final PriceDTO priceDTO) {
    PriceEntity priceEntity = priceEntityToDTOMapper.mapRequest(priceDTO);
    return priceEntityToDTOMapper.mapResponse(priceEntityRepository.save(priceEntity));
  }

}
