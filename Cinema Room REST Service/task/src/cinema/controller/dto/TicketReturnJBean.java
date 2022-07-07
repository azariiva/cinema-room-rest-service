package cinema.controller.dto;

import cinema.model.domain.Ticket;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TicketReturnJBean implements Serializable {
    private TicketJBean ticket;

    public TicketReturnJBean() {
    }

    private TicketReturnJBean(TicketJBean ticket) {
        this.ticket = ticket;
    }

    public static TicketReturnJBean fromTicket(Ticket ticket) {
        return new TicketReturnJBean(TicketJBean.fromTicket(ticket));
    }

    @JsonProperty("returned_ticket")
    public TicketJBean getTicket() {
        return ticket;
    }

    public void setTicket(TicketJBean ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "TicketReturnJBean{" +
                "ticket=" + ticket +
                '}';
    }
}
