package com.example.commons.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

  private String id;

  private LocalDateTime createAt;

  private LocalDateTime updateAt;

  private String name;

  private Long category;

  private LocalDateTime endOfSalesDate;

  private List<PriceDTO> prices;

}
