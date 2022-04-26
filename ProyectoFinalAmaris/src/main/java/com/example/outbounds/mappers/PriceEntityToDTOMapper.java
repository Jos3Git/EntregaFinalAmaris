package com.example.outbounds.mappers;

import com.example.commons.dtos.PriceDTO;
import com.example.outbounds.model.entities.PriceEntity;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceEntityToDTOMapper extends DtoMapper<PriceDTO, PriceEntity, PriceDTO> {

}
