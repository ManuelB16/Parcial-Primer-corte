// src/main/java/com/example/stockmonitor/repository/ProductRepository.java
package edu.cvds.primercorte.stock.repository;

import edu.cvds.primercorte.stock.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public void save(Product product) {
        products.add(product);
    }

    public Product findByName(String name) {
        return products.stream()
                       .filter(product -> product.getName().equals(name))
                       .findFirst()
                       .orElse(null);
    }

    public void updateStock(String name, int stock) {
        Product product = findByName(name);
        if (product != null) {
            product.setStock(stock);
        }
    }

    public List<Product> findAll() {
        return products;
    }
}

