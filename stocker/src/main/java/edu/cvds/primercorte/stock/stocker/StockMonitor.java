
package edu.cvds.primercorte.stock.stocker;

import main.java.edu.cvds.primercorte.stock.model.Product;
import main.java.edu.cvds.primercorte.stock.service.ProductService;

public class StockMonitor {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

     
        Product xbox = new Product("xbox one s", 299.99, 10, "gaming");
        productService.addProduct(xbox);

       
        productService.updateStock("xbox one s", 4);  
    }
}
