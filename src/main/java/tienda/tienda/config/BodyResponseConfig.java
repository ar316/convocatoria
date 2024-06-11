package tienda.tienda.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BodyResponseConfig<T> {
  @JsonProperty("data")
  private T data;

  @JsonProperty("message")
  private String message;

  public BodyResponseConfig() {}

  public BodyResponseConfig(String message) {
    this.message = message;
  }

  public BodyResponseConfig(T data, String message) {
    this.data = data;
    this.message = message;
  }
}
