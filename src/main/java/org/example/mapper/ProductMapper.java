package org.example.mapper;

import org.example.entity.Product;
import org.example.service.core.CreateProductParams;

public interface ProductMapper {

    Product map(CreateProductParams params);
}
