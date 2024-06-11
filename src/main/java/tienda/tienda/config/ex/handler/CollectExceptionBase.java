package tienda.tienda.config.ex.handler;

import tienda.tienda.config.ex.handler.Error;
import org.springframework.http.HttpStatus;

public class CollectExceptionBase extends RuntimeException {

    private final Error error;
    private final HttpStatus httpStatus;
    private final Error.Type type;

    protected CollectExceptionBase(Error error, HttpStatus httpStatus) {
        this.error = error;
        this.type = error.getType();
        this.httpStatus = httpStatus;
    }
}
