package com.squadatena.wishlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTO {
    private Integer id;
    private Integer sku;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String photo;

}