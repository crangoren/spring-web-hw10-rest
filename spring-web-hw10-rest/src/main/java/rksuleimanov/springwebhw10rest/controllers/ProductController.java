package rksuleimanov.springwebhw10rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import rksuleimanov.springwebhw10rest.converters.ProductConverter;
import rksuleimanov.springwebhw10rest.dto.ProductDto;
import rksuleimanov.springwebhw10rest.entities.Product;
import rksuleimanov.springwebhw10rest.exceptions.ResourceNotFoundException;
import rksuleimanov.springwebhw10rest.services.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;


    @GetMapping
    public Page<ProductDto> findAllProds(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "name_part", required = false) String titlePart

    ){
        if (page < 1) {
            page = 1;
        }
        return productService.findAll(page, minPrice, maxPrice, titlePart).map(
                productConverter::entityToDto);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id){
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found " + id));
        return productConverter.entityToDto(product);
    }

//    @PutMapping("/{id}")
//    public void changePrice(@RequestParam Long productId, @RequestParam Integer delta){
//        productService.changePrice(productId, delta);
//    }


    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto){
        Product product = productConverter.dtoToEntity(productDto);
        productService.saveNewProduct(product);
        return productConverter.entityToDto(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = productService.updateProduct(productDto);
        return productConverter.entityToDto(product);
    }


}
