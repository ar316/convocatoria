package tienda.tienda.config.ex.handler;

import org.springframework.http.HttpStatus;

public class NotFoundException extends CollectExceptionBase {

    public NotFoundException(String message) {
        super(Error.builder().type(Error.Type.RESOURCE_NOT_FOUND).message(message).build(), HttpStatus.NOT_FOUND);
    }

}
