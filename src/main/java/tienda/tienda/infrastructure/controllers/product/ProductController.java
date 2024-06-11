package tienda.tienda.infrastructure.controllers.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tienda.tienda.aplication.service.product.ProductService;
import tienda.tienda.config.BodyResponseConfig;
import tienda.tienda.config.ex.handler.NotFoundException;
import tienda.tienda.infrastructure.dto.product.ProductDTO;

import java.util.List;

@RequestMapping("/product")
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@Tag(name = "Controlador de Productos", description = "Operaciones relacionadas con productos")
public class ProductController {

  private final String ProductCreatedSucces = "Producto creado";
  private final String ProductListSuccess = "Lista de productos";
  private final String PRODUCT_NOT_FOUND = "producto no encontrado";
  private final ProductService productService;

  @GetMapping("/getAllProducts")
  @Operation(
      summary = "Obtener lista de productos",
      description = "Retorna una lista de todos los productos")
  public ResponseEntity<BodyResponseConfig<List<ProductDTO>>> getAllProducts() {
    List<ProductDTO> ProductList = productService.getProducts();
    if (!ProductList.isEmpty()) {
      return ResponseEntity.ok(new BodyResponseConfig<>(ProductList, ProductListSuccess));
    }
    return ResponseEntity.ok(
        new BodyResponseConfig<>(ProductList, "No hay productos en la base de datos"));
  }

  @PostMapping("/CreateProduct")
  @Operation(summary = "Crear un nuevo Producto", description = "Crear un nuevo Producto")
  public ResponseEntity<BodyResponseConfig<ProductDTO>> createProduct(
      @RequestBody ProductDTO product) {

    return ResponseEntity.ok(
        new BodyResponseConfig<>(productService.createProduct(product), ProductCreatedSucces));
  }

  @PutMapping("/UpdateProduct")
  @Operation(
      summary = "Actualizar un Producto existente",
      description = "Actualizar un Producto existente")
  public ResponseEntity<BodyResponseConfig<ProductDTO>> updateProduct(
      @RequestBody ProductDTO product) {

    return ResponseEntity.ok(
        new BodyResponseConfig<>(
            productService.updateProduct(product), "Producto actualizado exitosamente"));
  }

  @GetMapping("/GetProduct/{id}")
  @Operation(
      summary = "Obtener un Producto específico",
      description = "Obtener un Producto específico por su ID")
  public ResponseEntity<BodyResponseConfig<ProductDTO>> getProduct(@PathVariable Long id) {
    try{
      return ResponseEntity.ok(
              new BodyResponseConfig<>(productService.getProduct(id), "Producto obtenido exitosamente"));
    }catch (NotFoundException e){

      return ResponseEntity.ok(
              new BodyResponseConfig<>(null, PRODUCT_NOT_FOUND));
    }

  }

  @DeleteMapping("/DeleteProduct/{id}")
  @Operation(summary = "Eliminar un Producto", description = "Eliminar un Producto por su ID")
  public ResponseEntity<BodyResponseConfig<ProductDTO>> deleteProduct(@PathVariable Long id) {
    try {
      return ResponseEntity.ok(
              new BodyResponseConfig<>(
                      productService.deleteProduct(id), "Producto eliminado exitosamente"));
    } catch (NotFoundException e) {
      return ResponseEntity.ok(
              new BodyResponseConfig<>(null, PRODUCT_NOT_FOUND));
    }
  }
}
