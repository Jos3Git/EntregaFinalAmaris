package com.example.outbounds.mappers;

import com.example.commons.dtos.ProductDTO;
import com.example.outbounds.model.entities.ProductEntity;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductEntityToDTOMapper extends DtoMapper<ProductDTO, ProductEntity, ProductDTO> {
  @Override
  @Mapping(target = "prices", ignore = true)
  ProductDTO mapResponse(ProductEntity vo);
}
