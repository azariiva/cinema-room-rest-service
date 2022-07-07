package cinema.model.domain.exception;

public class WrongTokenException extends RuntimeException {
    private static final String reason = "Wrong token!";

    public WrongTokenException() {
        super(reason);
    }
}
