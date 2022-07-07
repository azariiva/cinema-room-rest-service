package cinema.controller.rest;

import cinema.controller.dto.*;
import cinema.model.CinemaRoomService;
import cinema.model.domain.exception.SeatOutOfBoundsException;
import cinema.model.domain.exception.TicketAlreadyPurchasedException;
import cinema.model.domain.exception.WrongPasswordException;
import cinema.model.domain.exception.WrongTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class CinemaRoomRestController {
    private final CinemaRoomService service;

    public CinemaRoomRestController(CinemaRoomService service) {
        this.service = service;
    }

    @GetMapping("/seats")
    CinemaRoomJBean getAvailableSeats() {
        var availableTickets = service.getAvailableTickets()
                .stream()
                .map(TicketJBean::fromTicket)
                .collect(Collectors.toUnmodifiableList());
        return new CinemaRoomJBean(service.getTotalRows(), service.getTotalColumns(), availableTickets);
    }

    @PostMapping("/purchase")
    TicketOrderJBean purchaseTicket(
            @RequestBody SeatJBean seat
    ) {
        var ticket = service.purchaseTicket(seat.toSeat());
        return TicketOrderJBean.fromTicketOrder(ticket);
    }

    @PostMapping("/return")
    TicketReturnJBean returnTicket(
            @RequestBody TokenJBean token
    ) {
        var ticket = service.returnTicket(token.getToken());
        return TicketReturnJBean.fromTicket(ticket);
    }

    @PostMapping("/stats")
    CinemaStatsJBean getStats(
            @RequestParam(value = "password", required = false) String password
    ) {
        if (!Objects.equals(password, "super_secret")) {
            throw new WrongPasswordException();
        }
        return new CinemaStatsJBean(
                service.getCurrentIncome(),
                service.getNumberOfAvailableSeats(),
                service.getNumberOfPurchasedTickets()
        );
    }
}
