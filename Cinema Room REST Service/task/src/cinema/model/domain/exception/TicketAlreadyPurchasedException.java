package cinema.model.domain.exception;

public class TicketAlreadyPurchasedException extends RuntimeException {
    private static final String reason = "The ticket has been already purchased!";

    public TicketAlreadyPurchasedException() {
        super(reason);
    }
}
