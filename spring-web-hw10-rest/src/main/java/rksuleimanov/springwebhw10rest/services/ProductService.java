package rksuleimanov.springwebhw10rest.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rksuleimanov.springwebhw10rest.dto.ProductDto;
import rksuleimanov.springwebhw10rest.entities.Product;
import rksuleimanov.springwebhw10rest.exceptions.ResourceNotFoundException;
import rksuleimanov.springwebhw10rest.repositories.ProductRepository;
import rksuleimanov.springwebhw10rest.repositories.specifications.ProductSpecification;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<Product> findAll(Integer page, Integer minPrice, Integer maxPrice, String titlePart) {
        Specification<Product> spec = Specification.where(null);
        if (minPrice != null) {
            spec = spec.and(ProductSpecification.priceGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecification.priceLessOrEqualsThan(maxPrice));
        }
        if (titlePart != null) {
            spec = spec.and(ProductSpecification.titleLike(titlePart));
        }
        return productRepository.findAll(spec, PageRequest.of(page - 1, 10));
    }

//    @Transactional
//    public void changePrice(Long productId, Integer delta) {
//        Product product = productRepository.findById(productId).orElseThrow(() -> new rksuleimanov.springwebhw9rest.
//        exceptions.ResourceNotFoundException("Unable to change product's price, product not found " + productId));
//        product.setPrice(product.getPrice() + delta);
//        productRepository.save(product);
//    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product saveNewProduct(Product product) {
       return productRepository.save(product);
    }

    @Transactional
    public Product updateProduct(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Unable to update product. Not found in base id: " + productDto.getId()));
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        return product;
    }

}