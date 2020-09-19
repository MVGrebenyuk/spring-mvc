package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "White", 25));
        products.add(new Product(2L, "Red", 15));
        products.add(new Product(3L, "Yellow", 25));
        products.add(new Product(4L, "Yellow", 22));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void save(Product product) {
        products.add(product);
    }

    public void deleteById(Long id) {
        products.removeIf(b -> b.getId() == (id));
    }
}
