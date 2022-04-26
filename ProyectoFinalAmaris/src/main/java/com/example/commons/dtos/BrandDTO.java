package com.example.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BrandDTO {

  private String id;

  private String name;

  private List<PriceDTO> prices;
}
