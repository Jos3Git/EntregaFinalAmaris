package com.example.domain.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product implements Serializable {

  private String id;

  private LocalDateTime createAt;

  private LocalDateTime updateAt;

  private String name;

  private Long category;

  private LocalDateTime endOfSalesDate;

  private List<Price> prices;

}
