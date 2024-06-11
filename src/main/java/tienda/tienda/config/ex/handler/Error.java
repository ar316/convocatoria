package tienda.tienda.config.ex.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error implements Serializable {

  private Type type;
  private String message;
  private List<String> detail;

  public enum Type {
    // 400
    INVALID_ARGUMENT,
    INVALID_BODY,
    INVALID_HEADER,
    INVALID_PARAMETER,
    METHOD_NOT_ALLOWED,
    UNSUPPORTED_MEDIA_TYPE,
    INVALID_AUTHORIZER,
    CLIENT_ERROR,
    FILE_PROCESSING_ERROR,

    // 404
    USER_NOT_FOUND,
    RESOURCE_NOT_FOUND,
    // 409
    INVALID_STATUS,
    INVALID_EMAIL,

    // 422
    MAX_ATTEMPTS,
    INVALID_CODE,
    IDENTIFICATION_TYPE_ERROR,

    // 500
    UNKNOWN_ERROR,
    BUS_ERROR,
    COUNTRY_NOT_FOUND_ERROR,
    DEPARTMENT_NOT_FOUND_ERROR,
    INVALID_IMAGE_FILE_ERROR,
    FILE_STORAGE_ERROR
  }
}
