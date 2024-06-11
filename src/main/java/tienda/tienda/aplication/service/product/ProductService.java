package tienda.tienda.aplication.service.product;

import java.util.List;
import tienda.tienda.infrastructure.dto.product.ProductDTO;

public interface ProductService {

  ProductDTO createProduct(ProductDTO product);

  ProductDTO updateProduct(ProductDTO product);

  ProductDTO deleteProduct(Long id);

  ProductDTO getProduct(Long id);

  List<ProductDTO> getProducts();
}
