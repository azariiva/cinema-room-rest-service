package cinema.controller.rest;

import cinema.model.domain.exception.SeatOutOfBoundsException;
import cinema.model.domain.exception.TicketAlreadyPurchasedException;
import cinema.model.domain.exception.WrongPasswordException;
import cinema.model.domain.exception.WrongTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CinemaRoomRestControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            SeatOutOfBoundsException.class,
            TicketAlreadyPurchasedException.class,
            WrongTokenException.class})
    public Map<String, String> handleUserExceptionsAsBadRequest(RuntimeException exception) {
        var response = new HashMap<String, String>();
        response.put("error", exception.getMessage());
        return response;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({WrongPasswordException.class})
    public Map<String,String> handleUserExceptionsAsUnauthorized(RuntimeException exception) {
        var response = new HashMap<String, String>();
        response.put("error", exception.getMessage());
        return response;
    }
}
