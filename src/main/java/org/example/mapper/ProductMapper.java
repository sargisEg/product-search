package org.example.mapper;

import org.example.controller.dto.CreateProductRequestDto;
import org.example.controller.dto.ProductDto;
import org.example.entity.Product;
import org.example.service.core.CreateProductParams;

public interface ProductMapper {

    Product map(CreateProductParams params);

    CreateProductParams map(CreateProductRequestDto dto);

    ProductDto map(Product product);
}
