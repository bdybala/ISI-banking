package isi.project.banking.exceptions;

public class InvalidPinException extends Exception {

    public InvalidPinException() {
    }
    public InvalidPinException(String message) {
        super(message);
    }
    public InvalidPinException(Throwable cause) {
        super(cause);
    }
}
