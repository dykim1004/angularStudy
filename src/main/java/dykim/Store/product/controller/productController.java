package dykim.Store.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dykim.Store.product.repository.ProductRepository;
import dykim.Store.product.vo.Product;

@RestController
public class productController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getList(){
		List<Product> products = new ArrayList<Product>();
		/*Product product = new Product();
		product.setName("Product #1");
		product.setDescription("A product");
		product.setCategory("Category #1");
		product.setPrice(new BigDecimal("100"));
		products.add(product);*/
		return products;
	}
}
