package cinema.model.domain;

public class Ticket {
    private final Seat seat;
    private final int price;

    public Ticket(Seat seat, int price) {
        this.seat = seat;
        this.price = price;
    }

    public Seat getSeat() {
        return seat;
    }

    public int getPrice() {
        return price;
    }
}
