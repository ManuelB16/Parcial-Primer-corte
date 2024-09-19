package main.java.edu.cvds.primercorte.stock.repository;

import main.java.edu.cvds.primercorte.stock.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public List<Product> findAll() {
        return products;
    }

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
}
