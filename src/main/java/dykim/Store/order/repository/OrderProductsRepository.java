package dykim.Store.order.repository;

import org.springframework.data.repository.CrudRepository;
import dykim.Store.order.vo.OrderProducts;

public interface OrderProductsRepository extends CrudRepository<OrderProducts, Long> {

}
