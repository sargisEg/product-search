package org.example.mapper;

import lombok.extern.slf4j.Slf4j;
import org.example.controller.dto.CreateProductRequestDto;
import org.example.controller.dto.ProductDto;
import org.example.entity.Product;
import org.example.service.core.CreateProductParams;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product map(CreateProductParams params) {
        log.trace("Creating Product object from CreateProductParams - {}", params);

        final Product product = new Product();
        product.setName(params.getName());
        product.setPrice(params.getPrice());
        product.setDescription(params.getDescription());
        product.setShortDescription(params.getShortDescription());

        log.trace("Successfully created Product object from CreateProductParams - {}, product - {}", params, product);
        return product;
    }

    @Override
    public CreateProductParams map(CreateProductRequestDto dto) {
        log.trace("Creating CreateProductParams object from CreateProductRequestDto - {}", dto);

        final CreateProductParams params = new CreateProductParams(
                dto.getName(),
                dto.getPrice(),
                dto.getDescription(),
                dto.getShortDescription()
        );

        log.trace("Successfully created CreateProductParams object from CreateProductRequestDto - {}, params - {}", dto, params);
        return params;
    }

    @Override
    public ProductDto map(Product product) {
        log.trace("Creating ProductDto object from Product - {}", product);

        final ProductDto productDto = new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getShortDescription(),
                null
        );

        log.trace("Successfully created ProductDto object from Product - {}, params - {}", product, productDto);
        return productDto;
    }
}
