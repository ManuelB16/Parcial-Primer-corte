package main.java.edu.cvds.primercorte.stock.agent;

import main.java.edu.cvds.primercorte.stock.model.Product;

public class AgentWarning {
    public static void checkStock(Product product) {
        if (product.getStock() < 5) {
            System.out.println("ALERTA!!! El stock del Producto: " + product.getName() + " es muy bajo, solo quedan " + product.getStock() + " unidades.");
        }
    }
}
