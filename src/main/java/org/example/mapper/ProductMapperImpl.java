package org.example.mapper;

import lombok.extern.slf4j.Slf4j;
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
}
