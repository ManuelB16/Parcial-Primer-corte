package main.java.edu.cvds.primercorte.stock.agent;

import main.java.edu.cvds.primercorte.stock.model.Product;

public class AgentLog {
    public static void logStock(Product product) {
        System.out.println("Producto: " + product.getName() + " -> " + product.getStock() + " unidades disponibles");
    }
}
