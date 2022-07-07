package cinema.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CinemaStatsJBean implements Serializable {
    private int currentIncome;
    private int numberOfAvailableSeats;
    private int numberOfPurchasedTickets;

    public CinemaStatsJBean() {
    }

    public CinemaStatsJBean(int currentIncome, int numberOfAvailableSeats, int numberOfPurchasedTickets) {
        this.currentIncome = currentIncome;
        this.numberOfAvailableSeats = numberOfAvailableSeats;
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

    @JsonProperty
    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    @JsonProperty
    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    @JsonProperty
    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

    @Override
    public String toString() {
        return "CinemaStatsJBean{" +
                "currentIncome=" + currentIncome +
                ", numberOfAvailableSeats=" + numberOfAvailableSeats +
                ", numberOfPurchasedTickets=" + numberOfPurchasedTickets +
                '}';
    }
}
