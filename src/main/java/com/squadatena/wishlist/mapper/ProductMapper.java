package com.squadatena.wishlist.mapper;

import com.squadatena.wishlist.dto.ProductDTO;
import com.squadatena.wishlist.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper extends GenericMapper<Product, ProductDTO> {
    @Override
    @Mapping(target = "id")
    Product asEntity(ProductDTO dto);
}