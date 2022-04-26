package com.example.outbounds.productdao;

import com.example.outbounds.mappers.ProductEntityToDTOMapper;
import com.example.outbounds.model.entities.ProductEntity;
import com.example.outbounds.model.repositories.ProductEntityRepository;
import com.example.commons.dtos.ProductDTO;
import com.example.outbounds.ports.ProductDAOOutPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductDAO implements ProductDAOOutPort {

  private ProductEntityRepository productEntityRepository;

  private ProductEntityToDTOMapper productEntityToDTOMapper;

  @Override
  public List<ProductDTO> findAll() {

    return productEntityRepository.findAll().stream().map(p -> productEntityToDTOMapper.mapResponse(p)).collect(Collectors.toList());
  }

  @Override
  public ProductDTO findById(final String id) {

    return productEntityToDTOMapper.mapResponse(productEntityRepository.findById(id).get());
  }

  @Override
  public ProductDTO save(final ProductDTO productDTO) {

    ProductEntity entity = productEntityToDTOMapper.mapRequest(productDTO);

    return productEntityToDTOMapper.mapResponse(productEntityRepository.save(entity));
  }

  @Override
  public ProductDTO update(final ProductDTO productDTO) {

    ProductEntity entity = productEntityToDTOMapper.mapRequest(productDTO);

    return productEntityToDTOMapper.mapResponse(productEntityRepository.save(entity));
  }

  @Override
  public void deleteById(final String id) {
    productEntityRepository.deleteById(id);
  }

}
