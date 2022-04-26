package com.example.inbounds.ports;

import com.example.commons.dtos.ProductDTO;
import com.example.domain.vos.Product;

import java.util.List;

public interface ProductInPort {
  List<Product> findAll();

  Product findById(String id);

  Product create(ProductDTO product);

  Product update(ProductDTO product);

  void delete(String id);
}
