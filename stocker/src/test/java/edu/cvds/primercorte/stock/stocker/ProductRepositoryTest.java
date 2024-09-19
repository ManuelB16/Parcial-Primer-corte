package edu.cvds.primercorte.stock.stocker;

import edu.cvds.primercorte.stock.model.Product;
import edu.cvds.primercorte.stock.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ProductRepositoryTest {

	private ProductRepository productRepository;

	@BeforeEach
	void setUp() {
		productRepository = new ProductRepository();
	}

	@Test
	void testSaveAndFindByName() {
		Product product = new Product("Laptop", 10, 10);
		productRepository.save(product);

		Product foundProduct = productRepository.findByName("Laptop");

		assertNotNull(foundProduct);
		assertEquals("Laptop", foundProduct.getName());
		assertEquals(10, foundProduct.getStock());
	}

	@Test
	void testFindByNameNotFound() {
		Product foundProduct = productRepository.findByName("NonExistentProduct");
		assertNull(foundProduct);
	}

	@Test
	void testUpdateStock() {
		Product product = new Product("Phone", 5, 0);
		productRepository.save(product);

		productRepository.updateStock("Phone", 15);
		Product updatedProduct = productRepository.findByName("Phone");

		assertNotNull(updatedProduct);
		assertEquals(15, updatedProduct.getStock());
	}

	@Test
	void testUpdateStockNonExistentProduct() {
		productRepository.updateStock("NonExistentProduct", 20);

	}

	@Test
	void testFindAll() {
		Product product1 = new Product("Tablet", 8, 0);
		Product product2 = new Product("Monitor", 12, 0);

		productRepository.save(product1);
		productRepository.save(product2);

		List<Product> allProducts = productRepository.findAll();

		assertEquals(2, allProducts.size());
		assertTrue(allProducts.contains(product1));
		assertTrue(allProducts.contains(product2));
	}
}
