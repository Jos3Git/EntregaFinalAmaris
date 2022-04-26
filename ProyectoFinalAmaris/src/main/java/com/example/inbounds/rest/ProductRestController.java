package com.example.inbounds.rest;

import com.example.inbounds.mappers.ProductDomainToDTOMapper;
import com.example.commons.constans.Constants;
import com.example.commons.dtos.ProductDTO;
import com.example.inbounds.ports.ProductInPort;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(Constants.URIPRODUCTS)
public class ProductRestController {

  private ProductInPort productInPort;

  private ProductDomainToDTOMapper productDomainToDTOMapper;

  @GetMapping
  public List<ProductDTO> findAll() {
    return productInPort.findAll().stream().map(p -> productDomainToDTOMapper.mapResponse(p)).collect(Collectors.toList());
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<ProductDTO> findById(final @PathVariable String id) {
    if (id == null || id.length() == 0) {
      return ResponseEntity.badRequest().build();
    }
    ProductDTO productRespDTO = productDomainToDTOMapper.mapResponse(productInPort.findById(id));

    return ResponseEntity.ok(productRespDTO);
  }

  @PostMapping
  public ResponseEntity<ProductDTO> create(final @RequestBody ProductDTO product) {
    if (product == null || product.getId() != null) {
      return ResponseEntity.badRequest().build();
    }

    ProductDTO productRespDTO = productDomainToDTOMapper.mapResponse(productInPort.create(product));

    return ResponseEntity.ok(productRespDTO);
  }

  @PutMapping
  public ResponseEntity<ProductDTO> update(final @RequestBody ProductDTO product) {
    if (product == null || product.getId() == null) {
      return ResponseEntity.badRequest().build();
    }
    ProductDTO productRespDTO = productDomainToDTOMapper.mapResponse(productInPort.update(product));

    return ResponseEntity.ok(productRespDTO);
  }

  @DeleteMapping("/id/{id}")
  public void delete(final @PathVariable String id) {
    productInPort.delete(id);
  }

}
