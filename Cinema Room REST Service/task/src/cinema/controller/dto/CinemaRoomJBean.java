package cinema.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class CinemaRoomJBean implements Serializable {
    private int totalRows;
    private int totalColumns;
    private List<TicketJBean> availableTickets;

    public CinemaRoomJBean() {
    }

    public CinemaRoomJBean(int totalRows, int totalColumns, List<TicketJBean> availableTickets) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableTickets = availableTickets;
    }

    @JsonProperty
    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    @JsonProperty
    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    @JsonProperty("available_seats")
    public List<TicketJBean> getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(List<TicketJBean> availableTickets) {
        this.availableTickets = availableTickets;
    }

    @Override
    public String toString() {
        return "CinemaRoomJBean{" +
                "totalRows=" + totalRows +
                ", totalColumns=" + totalColumns +
                ", availableTickets=" + availableTickets +
                '}';
    }
}
