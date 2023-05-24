package rrcc.basico.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {
    private final LocalDateTime localDateTime;
    private final String message;
    private final String details;


    public ExceptionResponse(LocalDateTime localDateTime, String message, String details) {
        this.localDateTime = localDateTime;
        this.message = message;
        this.details = details;
    }
}
