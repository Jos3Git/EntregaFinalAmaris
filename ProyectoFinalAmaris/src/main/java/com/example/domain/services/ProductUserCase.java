package com.example.domain.services;

import com.example.inbounds.mappers.ProductDomainToDTOMapper;
import com.example.commons.constans.Constants;
import com.example.commons.dtos.ProductDTO;
import com.example.domain.vos.Product;
import com.example.inbounds.ports.ProductInPort;
import com.example.outbounds.ports.ProductCrudProducerOutPort;
import com.example.outbounds.ports.ProductDAOOutPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductUserCase implements ProductInPort {

  private ProductDAOOutPort productDAOOutPort;

  private ProductCrudProducerOutPort productCrudProducerOutPort;

  private ProductDomainToDTOMapper productDomainToDTOMapper;

  @Override
  public List<Product> findAll() {
    List<Product> response = productDAOOutPort.findAll().stream().map(p -> productDomainToDTOMapper.mapRequest(p))
        .collect(Collectors.toList());
    String productLog = getTile(Constants.PRODUCT_FINDALL, null);
    if (productLog != null) {
      productCrudProducerOutPort.generateTiles(productLog);
    }
    return response;
  }

  @Override
  public Product findById(final String id) {
    Product response = productDomainToDTOMapper.mapRequest(productDAOOutPort.findById(id));
    String productLog = getTile(Constants.PRODUCT_FINDBYID, new ProductDTO(id, null, null, null, null, null, null));
    if (productLog != null) {
      productCrudProducerOutPort.generateTiles(productLog);
    }
    return response;
  }

  @Override
  public Product create(final ProductDTO product) {
    if (product != null && product.getId() == null) {
      Product response = productDomainToDTOMapper.mapRequest(productDAOOutPort.save(product));
      String productLog = getTile(Constants.PRODUCT_CREATE, productDomainToDTOMapper.mapResponse(response));
      if (productLog != null) {
        productCrudProducerOutPort.generateTiles(productLog);
      }
      return response;
    } else {
      return null;
    }
  }

  @Override
  public Product update(final ProductDTO product) {
    if (product != null && product.getId() != null) {
      Product response = productDomainToDTOMapper.mapRequest(productDAOOutPort.update(product));
      String productLog = getTile(Constants.PRODUCT_UPDATE, productDomainToDTOMapper.mapResponse(response));
      if (productLog != null) {
        productCrudProducerOutPort.generateTiles(productLog);
      }
      return response;
    } else {
      return null;
    }
  }

  @Override
  public void delete(final String id) {
    productDAOOutPort.deleteById(id);
    ProductDTO productDTO = new ProductDTO(id, null, null, null, null, null, null);
    String productLog = getTile(Constants.PRODUCT_DELETE, productDTO);
    if (productLog != null) {
      productCrudProducerOutPort.generateTiles(productLog);
    }
  }

  private String getTile(final String operationType, final ProductDTO dto) {
    String data = (dto != null) ? dto.toString() : "";
    return "OPERATIONTYPE: " + operationType + " " + data;
  }

}
