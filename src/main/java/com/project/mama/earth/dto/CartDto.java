package com.project.mama.earth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {
    private String username;
    private String productName;
    private Integer quantity;
    private Long price;
}
