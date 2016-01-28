package dykim.Store.product.repository;

import org.springframework.data.repository.CrudRepository;

import dykim.Store.product.vo.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
