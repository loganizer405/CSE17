public class InvalidSeatException extends Exception {
    InvalidSeatException() {
        super("Incorrect seat entered! Format:[1-9][A-H]");
    }

    InvalidSeatException(String e) {
        super(e);
    }
}
