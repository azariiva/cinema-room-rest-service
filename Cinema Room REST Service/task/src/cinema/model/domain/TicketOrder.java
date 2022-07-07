package cinema.model.domain;

import java.util.UUID;

public class TicketOrder {
    private final UUID token;
    private final Ticket ticket;

    public TicketOrder(UUID token, Ticket ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
