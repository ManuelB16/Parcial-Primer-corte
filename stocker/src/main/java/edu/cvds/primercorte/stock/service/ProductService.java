
package edu.cvds.primercorte.stock.service;

import java.util.List;

import edu.cvds.primercorte.stock.model.Product;
import edu.cvds.primercorte.stock.repository.ProductRepository;

public class ProductService {
    private ProductRepository repository = new ProductRepository();

    public void addProduct(Product product) {
        repository.save(product);
        notifyAgents(product);
    }

    public void updateStock(String name, int stock) {
        repository.updateStock(name, stock);
        Product product = repository.findByName(name);
        if (product != null) {
            notifyAgents(product);
        }
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    private void notifyAgents(Product product) {
        System.out.println("Producto: " + product.getName() + " -> " + product.getStock() + " unidades disponibles");
        if (product.getStock() < 5) {
            System.out.println("ALERTA!!! El stock del Producto: " + product.getName() + " es muy bajo, solo quedan " + product.getStock() + " unidades.");
        }
    }
}

