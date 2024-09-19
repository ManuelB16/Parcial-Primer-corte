// service/ProductService.java
package main.java.edu.cvds.primercorte.stock.service;

import main.java.edu.cvds.primercorte.stock.model.Product;
import main.java.edu.cvds.primercorte.stock.repository.ProductRepository;
import main.java.edu.cvds.primercorte.stock.agent.AgentLog;
import main.java.edu.cvds.primercorte.stock.agent.AgentWarning;

public class ProductService {
    private ProductRepository repository;

    public ProductService() {
        this.repository = new ProductRepository();
    }

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

    private void notifyAgents(Product product) {
        AgentWarning.checkStock(product);
    }
}

