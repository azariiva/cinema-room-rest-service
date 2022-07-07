package cinema.controller.dto;

import cinema.model.domain.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SeatJBean implements Serializable {
    private int row;
    private int column;

    public SeatJBean() {
    }

    private SeatJBean(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static SeatJBean fromSeat(Seat seat) {
        return new SeatJBean(seat.getRow(), seat.getColumn());
    }

    public Seat toSeat() {
        return new Seat(row, column);
    }

    @JsonProperty
    public int getRow() {
        return row;
    }

    @JsonProperty
    public void setRow(int row) {
        this.row = row;
    }

    @JsonProperty
    public int getColumn() {
        return column;
    }

    @JsonProperty
    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "SeatJBean{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
