package com.example.outbounds.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

//@Table(name = "PRODUCTS")

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Document("PRODUCTS")
public class ProductEntity implements Serializable {

  @Id
  private String id;

  private LocalDateTime createAt;

  private LocalDateTime updateAt;

  private String name;

  private Long category;

  private LocalDateTime endOfSalesDate;

  @OneToMany(mappedBy = "product")
  private List<PriceEntity> prices;

}
