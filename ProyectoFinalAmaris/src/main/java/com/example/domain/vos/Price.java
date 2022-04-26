package com.example.domain.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Price implements Serializable {

  private String id;

  private LocalDateTime startdate;

  private LocalDateTime enddate;

  private Integer pricelist;

  private Integer priority;

  private Double price;

  private String curr;

  private Brand brand;

  private Product product;

}
