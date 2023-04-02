package org.example.service.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductParams {

    private String name;
    private Integer price;
    private String description;
    private String shortDescription;
}
