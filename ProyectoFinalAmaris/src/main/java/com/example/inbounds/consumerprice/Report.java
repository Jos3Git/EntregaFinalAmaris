package com.example.inbounds.consumerprice;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Report {
  private Long productid;

  private Integer pricelistid;

  private Double price;

}
