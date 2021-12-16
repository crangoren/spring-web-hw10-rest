package rksuleimanov.springwebhw10rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import rksuleimanov.springwebhw10rest.dto.ProductDto;
import rksuleimanov.springwebhw10rest.entities.Product;
import rksuleimanov.springwebhw10rest.services.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

}
