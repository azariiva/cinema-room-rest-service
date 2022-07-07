package cinema.model.domain.exception;

public class SeatOutOfBoundsException extends RuntimeException {
    private static final String reason = "The number of a row or a column is out of bounds!";

    public SeatOutOfBoundsException() {
        super(reason);
    }
}
