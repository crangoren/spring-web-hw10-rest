package rksuleimanov.springwebhw10rest.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rksuleimanov.springwebhw10rest.entities.Product;
import rksuleimanov.springwebhw10rest.repositories.ProductRepository;
import rksuleimanov.springwebhw10rest.repositories.specifications.ProductSpecification;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {


}