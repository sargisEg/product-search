package org.example.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private Integer price;
    private String description;
    private String shortDescription;

    private ErrorDto error;

    public ProductDto(ErrorDto error) {
        this.error = error;
    }
}
