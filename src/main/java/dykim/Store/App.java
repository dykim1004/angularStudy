package dykim.Store;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

import dykim.Store.order.repository.OrderProductsRepository;
import dykim.Store.order.repository.OrderRepository;
import dykim.Store.order.vo.Order;
import dykim.Store.order.vo.OrderProducts;
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
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderProductsRepository orderProductsRepository;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		initData();
	}
	
	// 초기 데이터 등 
	private void initData(){
		//제품 등록
		Product product1 = new Product("1","Product #1", "A product", "Category #1", new BigDecimal("100"));
		Product product2 = new Product("2","Product #2", "A product", "Category #1", new BigDecimal("110"));
		Product product3 = new Product("3","Product #3", "A product", "Category #2", new BigDecimal("210"));
		Product product4 = new Product("4","Product #4", "A product", "Category #3", new BigDecimal("202"));
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		productRepository.save(product4);
		
		System.out.println("제품등록!");
		
		//주문 등록
		
		List<Product> prdLst = new ArrayList<Product>();
		prdLst.add(product1);
		prdLst.add(product2);
		prdLst.add(product3);
		
		Order order1 = new Order("1", "Adam Freeman", "street", "London","state", "000-000", "country", false);
		Order order2 = new Order("2", "Joe Smith", "street", "New York","state", "000-000", "country", false);
		Order order3 = new Order("3", "Jane Doe", "street", "Paris","state", "000-000", "country", false);
		
		List<OrderProducts> orderProductList = new ArrayList<OrderProducts>();
		
		OrderProducts orderProduct1 = new OrderProducts(1,"1","Product #1", "A product", "Category #1", new BigDecimal("100"), 1);
		OrderProducts orderProduct2 = new OrderProducts(2,"2","Product #2", "A product", "Category #1", new BigDecimal("110"), 2);
		OrderProducts orderProduct3 = new OrderProducts(3,"3","Product #3", "A product", "Category #2", new BigDecimal("210"), 1);
		orderProductList.add(orderProduct1);
		orderProductList.add(orderProduct2);
		orderProductList.add(orderProduct3);
		
		order1.setProducts(orderProductList);
		
		orderRepository.save(order1);
		orderRepository.save(order2);
		orderRepository.save(order3);
		
		
		orderProduct1.setOrder(order1);
		orderProduct2.setOrder(order1);
		orderProduct3.setOrder(order1);
		
		orderProductsRepository.save(orderProduct1);
		//orderProductsRepository.save(orderProduct2);
		//orderProductsRepository.save(orderProduct3);
		
		
	}
	
	
}
