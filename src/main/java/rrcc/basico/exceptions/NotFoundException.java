package rrcc.basico.exceptions;

import java.io.Serializable;

public abstract class NotFoundException extends RuntimeException  implements Serializable {
    public NotFoundException(String message) {
        super(message);
    }
}
