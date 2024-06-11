package tienda.tienda.aplication.service.product.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tienda.tienda.aplication.service.product.ProductService;
import tienda.tienda.domain.model.Product;
import tienda.tienda.infrastructure.dao.product.ProductDao;
import tienda.tienda.infrastructure.dto.product.ProductDTO;
import tienda.tienda.config.ex.handler.NotFoundException;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductDao productDao;
  private final Function<Product, ProductDTO> entityToProductDto;
  private final Function<ProductDTO, Product> dtoToProduct;

  @Override
  @Transactional
  public ProductDTO createProduct(ProductDTO product) {
    Product prod = dtoToProduct.apply(product);
    return entityToProductDto.apply(productDao.save(prod));
  }

  @Override
  @Transactional
  public ProductDTO updateProduct(ProductDTO product) {
    Product productoToUpdate = productDao.findById(product.getId());
    productoToUpdate.setName(product.getName());
    productoToUpdate.setPrice(product.getPrice());
    productoToUpdate.setStock(product.getStock());
    return entityToProductDto.apply(productDao.update(productoToUpdate));
  }

  @Override
  @Transactional
  public ProductDTO deleteProduct(Long id) {
    return entityToProductDto.apply(productDao.delete(id));
  }

  @Override
  public ProductDTO getProduct(Long id) {
    return entityToProductDto.apply(productDao.findById(id));
  }

  @Override
  public List<ProductDTO> getProducts() {
    return productDao.findAll().stream().map(entityToProductDto).toList();
  }
}
