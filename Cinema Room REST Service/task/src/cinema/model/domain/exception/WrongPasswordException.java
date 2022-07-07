package cinema.model.domain.exception;

public class WrongPasswordException extends RuntimeException {
    private static final String reason = "The password is wrong!";

    public WrongPasswordException() {
        super(reason);
    }
}
