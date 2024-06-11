package tienda.tienda.config.mapper;

import java.util.function.Function;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tienda.tienda.domain.model.Product;
import tienda.tienda.infrastructure.dto.product.ProductDTO;

@Configuration
public class ConverterProductFactory {

  @Bean
  public Function<Product, ProductDTO> entityToProductDto(ModelMapper mapper) {
    return Product -> mapper.map(Product, ProductDTO.class);
  }

  @Bean
  public Function<ProductDTO, Product> dtoToProduct(ModelMapper mapper) {
    return ProductDTO -> mapper.map(ProductDTO, Product.class);
  }
}
