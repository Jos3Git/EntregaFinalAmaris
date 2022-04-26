package com.example.outbounds.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Document("PRICES")
public class PriceEntity implements Serializable {

  @Id
  private String id;

  private LocalDateTime startdate;

  private LocalDateTime enddate;

  private Integer pricelist;

  private Integer priority;

  private Double price;

  private String curr;

  @ManyToOne
  @JoinColumn(name = "brandid")
  private BrandEntity brand;

  @ManyToOne
  @JoinColumn(name = "productid")
  private ProductEntity product;

}
