package dykim.Store.order.repository;

import org.springframework.data.repository.CrudRepository;

import dykim.Store.order.vo.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
