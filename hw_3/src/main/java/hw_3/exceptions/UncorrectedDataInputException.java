package hw_3.exceptions;

public class UncorrectedDataInputException extends RuntimeException {
    public UncorrectedDataInputException() {
    }

    public UncorrectedDataInputException(String message) {
        super(message);
    }

    public String getMessage() {
        return "Uncorrected Data Input.";
    }

}
