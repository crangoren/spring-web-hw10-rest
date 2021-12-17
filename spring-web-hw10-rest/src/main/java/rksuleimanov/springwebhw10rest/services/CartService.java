package rksuleimanov.springwebhw10rest.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rksuleimanov.springwebhw10rest.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CartService {

    List<Product> cart = new ArrayList<Product>();

    public void addToCart(Product product) {
        cart.add(product);
    }


    public List<Product> getCart() {
        return cart;
    }
}
