package moneytransfer.models.exceptions;

public class InvalidPaymentException extends RuntimeException {
    public InvalidPaymentException(String msg) {
        super(msg);
    }
}
