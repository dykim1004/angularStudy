package dykim.Store;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

import dykim.Store.product.repository.ProductRepository;
import dykim.Store.product.vo.Product;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EntityScan
public class App implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		productRepository.save(new Product("Product #1", "A product", "Category #1", new BigDecimal("100")));
		productRepository.save(new Product("Product #1", "A product", "Category #1", new BigDecimal("110")));
		productRepository.save(new Product("Product #1", "A product", "Category #2", new BigDecimal("210")));
		productRepository.save(new Product("Product #1", "A product", "Category #3", new BigDecimal("202")));
		
	}
}
