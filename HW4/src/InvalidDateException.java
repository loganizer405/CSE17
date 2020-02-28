public class InvalidDateException extends Exception {
    InvalidDateException() {
        super("Invalid date");
    }

    InvalidDateException(String message) {
        super(message);
    }
}
