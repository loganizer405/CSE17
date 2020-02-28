public class InvalidTimeException extends Exception {
    InvalidTimeException() {
        super("Invalid time");
    }

    InvalidTimeException(String message) {
        super(message);
    }
}
