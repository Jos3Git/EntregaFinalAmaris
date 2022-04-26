package com.example.outbounds.ports;

import com.example.commons.dtos.ProductDTO;

import java.util.List;

public interface ProductDAOOutPort {
  List<ProductDTO> findAll();

  ProductDTO findById(String id);

  ProductDTO save(ProductDTO productDTO);

  ProductDTO update(ProductDTO productDTO);

  void deleteById(String id);
}
