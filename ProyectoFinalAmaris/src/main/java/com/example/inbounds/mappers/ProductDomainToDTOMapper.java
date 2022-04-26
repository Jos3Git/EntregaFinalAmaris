package com.example.inbounds.mappers;

import com.example.commons.dtos.ProductDTO;
import com.example.domain.vos.Product;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductDomainToDTOMapper extends DtoMapper<ProductDTO, Product, ProductDTO> {
  @Override
  @Mapping(target = "prices", ignore = true)
  ProductDTO mapResponse(Product vo);
}
