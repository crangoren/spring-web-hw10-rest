package rksuleimanov.springwebhw10rest.converters;

import org.springframework.stereotype.Component;
import rksuleimanov.springwebhw10rest.dto.ProductDto;
import rksuleimanov.springwebhw10rest.entities.Product;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }
}
