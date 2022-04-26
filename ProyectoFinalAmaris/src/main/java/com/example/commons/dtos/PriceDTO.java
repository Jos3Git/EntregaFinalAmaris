package com.example.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceDTO {

  private String id;

  private LocalDateTime startdate;

  private LocalDateTime enddate;

  private Integer pricelist;

  private Integer priority;

  private Double price;

  private String curr;

  private BrandDTO brand;

  private ProductDTO product;

}
