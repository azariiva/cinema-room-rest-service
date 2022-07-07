package cinema.model;

import cinema.config.CinemaRoomConfig;
import cinema.model.domain.Seat;
import cinema.model.domain.Ticket;
import cinema.model.domain.TicketOrder;
import cinema.model.domain.exception.SeatOutOfBoundsException;
import cinema.model.domain.exception.TicketAlreadyPurchasedException;
import cinema.model.domain.exception.WrongTokenException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CinemaRoomService {
    private final CinemaRoomConfig config;
    private final Map<Seat, Ticket> availableTickets;
    private final Map<UUID, Ticket> purchasedTickets;

    public CinemaRoomService(CinemaRoomConfig config) {
        this.config = config;
        this.availableTickets = new ConcurrentHashMap<>();
        this.purchasedTickets = new ConcurrentHashMap<>();
        for (int i = 0; i < getTotalRows(); i++) {
            for (int j = 0; j < getTotalColumns(); j++) {
                var seat = new Seat(i + 1, j + 1);
                var ticket = new Ticket(seat, i > 4 ? 8 : 10);
                this.availableTickets.put(seat, ticket);
            }
        }
    }

    public int getTotalRows() {
        return config.getTotalRows();
    }

    public int getTotalColumns() {
        return config.getTotalColumns();
    }

    /**
     * @return cinema room available seats
     * @implNote <a href="https://stackoverflow.com/a/2681913">stackoverflow</a> answer about thread safety
     */
    public List<Ticket> getAvailableTickets() {
        return new ArrayList<>(this.availableTickets.values());
    }

    public TicketOrder purchaseTicket(Seat seat) throws SeatOutOfBoundsException, TicketAlreadyPurchasedException {
        var ticket = availableTickets.get(seat); // find ticket by seat
        if (ticket == null) { // if ticket hasn't been found determine error
            if (seat.getRow() < 1 || seat.getRow() > getTotalRows() || seat.getColumn() < 1
                    || seat.getColumn() > getTotalColumns()) {
                throw new SeatOutOfBoundsException();
            }
            throw new TicketAlreadyPurchasedException();
        }
        availableTickets.remove(seat); // make ticket unavailable
        var token = UUID.randomUUID(); // generate token
        purchasedTickets.put(token, ticket); // add ticket to reserved
        return new TicketOrder(token, ticket); // return order
    }

    public Ticket returnTicket(UUID token) {
        var ticket = purchasedTickets.get(token);
        if (ticket == null) {
            throw new WrongTokenException();
        }
        purchasedTickets.remove(token);
        availableTickets.put(ticket.getSeat(), ticket);
        return ticket;
    }

    public int getCurrentIncome() {
        return purchasedTickets.values()
                .stream()
                .mapToInt(Ticket::getPrice)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public int getNumberOfAvailableSeats() {
        return availableTickets.size();
    }

    public int getNumberOfPurchasedTickets() {
        return purchasedTickets.size();
    }
}
