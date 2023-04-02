package org.example.service.core;

import org.example.entity.Product;

import java.util.Optional;

public interface ProductService {

    Product createProduct(CreateProductParams params);

    Optional<Product> findProductById(Long id);

    void deleteProductById(Long id);
}
