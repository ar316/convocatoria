package tienda.tienda.infrastructure.dao.product;

import org.springframework.data.jpa.repository.JpaRepository;
import tienda.tienda.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}
