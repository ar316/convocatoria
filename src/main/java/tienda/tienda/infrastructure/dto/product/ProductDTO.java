package tienda.tienda.infrastructure.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
  private Long id;
  private String name;
  private Double price;
  private Integer stock;
}
