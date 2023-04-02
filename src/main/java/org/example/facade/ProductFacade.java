package org.example.facade;

import org.example.controller.dto.CreateProductRequestDto;
import org.example.controller.dto.ProductDto;

public interface ProductFacade {
    ProductDto createProduct(CreateProductRequestDto dto);

    ProductDto getProductById(Long productId);

    ProductDto deleteProductById(Long productId);
}
