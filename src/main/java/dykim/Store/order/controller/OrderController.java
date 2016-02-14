package dykim.Store.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dykim.Store.order.repository.OrderRepository;
import dykim.Store.order.vo.Order;

@RestController
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public List<Order> getOrders(){
		System.out.println("S :");
		List<Order> list = (List<Order>) orderRepository.findAll();
		System.out.println("E :"+list.size());
		List<Order> list2 = new ArrayList<Order>();
		return list ;
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public Order getList(Order order){
		//TODO getProduts( 구현
		//System.out.println(order.getProducts());

		return order;
	}
	
}
