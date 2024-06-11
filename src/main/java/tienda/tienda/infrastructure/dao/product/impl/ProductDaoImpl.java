package tienda.tienda.infrastructure.dao.product.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Repository;
import tienda.tienda.config.ex.handler.NotFoundException;
import tienda.tienda.domain.model.Product;
import tienda.tienda.infrastructure.dao.product.ProductDao;
import tienda.tienda.infrastructure.dao.product.ProductRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {

  private final ProductRepository productRepository;

  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product findById(Long id) {
    return productRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("User with Id " + id + " does not exist"));
  }

  @Override
  public Product delete(Long id) {
    Product toDelete = findById(id);
    productRepository.delete(toDelete);
    return toDelete;
  }

  @Override
  public Product update(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> findAll() {
    return productRepository.findAll();
  }
}
