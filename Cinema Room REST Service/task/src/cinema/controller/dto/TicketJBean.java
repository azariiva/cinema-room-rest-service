package cinema.controller.dto;

import cinema.model.domain.Ticket;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TicketJBean implements Serializable {
    private int row;
    private int column;
    private int price;

    public TicketJBean() {
    }

    private TicketJBean(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    public static TicketJBean fromTicket(Ticket ticket) {
        return new TicketJBean(ticket.getSeat().getRow(), ticket.getSeat().getColumn(), ticket.getPrice());
    }

    @JsonProperty
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @JsonProperty
    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @JsonProperty
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TicketJBean{" +
                "row=" + row +
                ", column=" + column +
                ", price=" + price +
                '}';
    }
}
