package com.jtsp.adminclient.mapper;

import com.jtsp.adminclient.model.dto.ProductDTO;
import com.jtsp.adminclient.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface ProductMapper {

    Product toProduct(ProductDTO productDTO);

    ProductDTO toProductDTO(Product product);
}
