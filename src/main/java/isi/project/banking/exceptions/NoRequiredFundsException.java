package isi.project.banking.exceptions;

public class NoRequiredFundsException extends Exception {

    public NoRequiredFundsException() {
    }
    public NoRequiredFundsException(String message) {
        super(message);
    }
}
