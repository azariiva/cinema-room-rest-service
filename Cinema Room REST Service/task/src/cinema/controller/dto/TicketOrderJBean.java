package cinema.controller.dto;

import cinema.model.domain.TicketOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.UUID;

public class TicketOrderJBean implements Serializable {
    private UUID token;
    private TicketJBean ticket;

    public TicketOrderJBean() {
    }

    private TicketOrderJBean(UUID token, TicketJBean ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public static TicketOrderJBean fromTicketOrder(TicketOrder order) {
        return new TicketOrderJBean(order.getToken(), TicketJBean.fromTicket(order.getTicket()));
    }

    @JsonProperty
    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    @JsonProperty
    public TicketJBean getTicket() {
        return ticket;
    }

    public void setTicket(TicketJBean ticket) {
        this.ticket = ticket;
    }


    @Override
    public String toString() {
        return "TicketOrderJBean{" +
                "token=" + token +
                ", ticket=" + ticket +
                '}';
    }
}
