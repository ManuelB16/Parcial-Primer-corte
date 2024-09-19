package edu.cvds.primercorte.stock.controller;

import edu.cvds.primercorte.stock.model.Product;
import edu.cvds.primercorte.stock.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService = new ProductService();

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PatchMapping("/{name}")
    public void updateStock(@PathVariable String name, @RequestParam int stock) {
        productService.updateStock(name, stock);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }
}

