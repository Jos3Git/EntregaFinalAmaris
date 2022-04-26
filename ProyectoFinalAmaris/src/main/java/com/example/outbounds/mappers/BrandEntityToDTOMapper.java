package com.example.outbounds.mappers;

import com.example.commons.dtos.BrandDTO;
import com.example.outbounds.model.entities.BrandEntity;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BrandEntityToDTOMapper extends DtoMapper<BrandDTO, BrandEntity, BrandDTO> {

  @Override
  @Mapping(target = "prices", ignore = true)
  BrandDTO mapResponse(BrandEntity vo);

}
