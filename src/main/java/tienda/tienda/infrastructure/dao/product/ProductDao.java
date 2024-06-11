package tienda.tienda.infrastructure.dao.product;

import tienda.tienda.domain.model.Product;
import tienda.tienda.infrastructure.dto.product.ProductDTO;

import java.util.List;

public interface ProductDao {

  Product save(Product product);

  Product findById(Long id);

  Product delete(Long id);

  Product update(Product product);

  List<Product> findAll();
}
