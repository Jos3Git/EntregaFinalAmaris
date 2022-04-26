package com.example.inbounds.mappers;

import com.example.commons.dtos.BrandDTO;
import com.example.domain.vos.Brand;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BrandDomainToDTOMapper extends DtoMapper<BrandDTO, Brand, BrandDTO> {

  @Override
  @Mapping(target = "prices", ignore = true)
  BrandDTO mapResponse(Brand vo);

}
