package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.controller.dto.CreateProductRequestDto;
import org.example.controller.dto.ProductDto;
import org.example.facade.ProductFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("api/products")
public class ProductController {

    private final ProductFacade productFacade;

    @PostMapping
    ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductRequestDto dto) {
        ProductDto productDto = productFacade.createProduct(dto);
        if (productDto.getError() != null)
            return new ResponseEntity<>(productDto, HttpStatus.valueOf(productDto.getError().getStatus()));
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("{productId}")
    ResponseEntity<ProductDto> getProductById(@PathVariable("productId") Long productId) {
        ProductDto productDto = productFacade.getProductById(productId);
        if (productDto.getError() != null)
            return new ResponseEntity<>(productDto, HttpStatus.valueOf(productDto.getError().getStatus()));
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @DeleteMapping("{productId}")
    ResponseEntity<ProductDto> deleteProductById(@PathVariable("productId") Long productId) {
        ProductDto productDto = productFacade.deleteProductById(productId);
        if (productDto.getError() != null)
            return new ResponseEntity<>(productDto, HttpStatus.valueOf(productDto.getError().getStatus()));
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
}
