package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Product;
import org.example.mapper.ProductMapper;
import org.example.repository.ProductRepository;
import org.example.service.core.CreateProductParams;
import org.example.service.core.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Product createProduct(CreateProductParams params) {
        Assert.notNull(params, "Params should not be null. Class - ProductServiceImpl");
        log.debug("Creating product with params - {}", params);

        final Product product = productRepository.save(
                productMapper.map(params)
        );

        log.debug("Successfully created product with params - {}, result - {}", params, product);
        return product;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        Assert.notNull(id, "Id should not be null. Class - ProductServiceImpl");
        log.debug("Finding product with id - {}", id);

        final Optional<Product> optionalProduct = productRepository.findById(id);

        log.debug("Successfully found product with id - {}, product - {}", id, optionalProduct);
        return optionalProduct;
    }

    @Override
    public void deleteProductById(Long id) {
        Assert.notNull(id, "Id should not be null. Class - ProductServiceImpl");
        log.debug("Deleting product with id - {}", id);

        productRepository.deleteById(id);

        log.debug("Successfully deleted product with id - {}", id);
    }
}
