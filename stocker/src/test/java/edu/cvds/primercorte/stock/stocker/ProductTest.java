package edu.cvds.primercorte.stock.stocker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.cvds.primercorte.stock.model.Product;

public class ProductTest {

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product("Xbox One S", 299.99, 10);
    }

    @Test
    public void testGetName() {
        assertEquals("Xbox One S", product.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(299.99, product.getPrice());
    }

    @Test
    public void testGetStock() {
        assertEquals(10, product.getStock());
    }

    @Test
    public void testSetStock() {
        product.setStock(5);
        assertEquals(5, product.getStock());
    }
}
