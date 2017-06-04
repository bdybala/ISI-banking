package isi.project.banking.rest.exception;

public class InvalidPinException extends Throwable {

    public InvalidPinException() {
    }
    public InvalidPinException(String s) {
        super(s);
    }

    public InvalidPinException(Throwable cause) {
        super(cause);
    }
}
