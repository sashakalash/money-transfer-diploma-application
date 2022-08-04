package moneytransfer.advice;

import moneytransfer.models.exceptions.InvalidPaymentException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("authorization")
public class Advice {
    @ExceptionHandler(InvalidPaymentException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    String resolveException(InvalidPaymentException ex) {
        return ex.getMessage();
    }
}
