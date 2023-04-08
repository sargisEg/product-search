package org.example.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.CreateProductRequestDto;
import org.example.controller.dto.ErrorDto;
import org.example.controller.dto.ProductDto;
import org.example.entity.Product;
import org.example.mapper.ProductMapper;
import org.example.service.core.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Slf4j
@Component
@RequiredArgsConstructor
class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @Override
    public ProductDto createProduct(CreateProductRequestDto dto) {
        Assert.notNull(dto, "Dto should not be null. Class - ProductFacadeImpl");
        log.debug("Creating product for provided request - {}", dto);

        final Product product = productService.createProduct(productMapper.map(dto));

        final ProductDto productDto = productMapper.map(product);

        log.debug("Successfully created product for provided request - {}, response - {}", dto, productDto);
        return productDto;
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Assert.notNull(productId, "Product id should not be null. Class - ProductFacadeImpl");
        log.debug("Getting product with id - {} for provided request", productId);

        final var optionalProduct = productService.findProductById(productId);
        if (optionalProduct.isEmpty())
            return new ProductDto(new ErrorDto("Cannot find product with id - " + productId, 404));
        final var product = optionalProduct.get();

        final var productDto = productMapper.map(product);

        log.debug("Successfully got product with id - {} for provided request, response - {}", productId, productDto);
        return productDto;
    }

    @Override
    public ProductDto deleteProductById(Long productId) {
        Assert.notNull(productId, "Product id should not be null. Class - ProductFacadeImpl");
        log.debug("Deleting product with id - {} for provided request", productId);

        final var optionalProduct = productService.findProductById(productId);
        if (optionalProduct.isEmpty())
            return new ProductDto(new ErrorDto("Cannot find product with id - " + productId, 404));
        final var productDto = productMapper.map(optionalProduct.get());

        deleteProductById(productId);

        log.debug("Successfully got product with id - {} for provided request, response - {}", productId, productDto);
        return productDto;
    }
}
