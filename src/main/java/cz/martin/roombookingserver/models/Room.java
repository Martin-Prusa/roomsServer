package cz.martin.roombookingserver.models;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class Room {

    private UUID id;
    private String title;
    private String description;
    private int seats;
    private int price;
    private ArrayList<Reservation> reservations;

    public Room(String title, String description, int seats, int price) {
        this.id = UUID.randomUUID();
        this.reservations = new ArrayList<>();
        this.title = title;
        this.description = description;
        this.seats = seats;
        this.price = price;
    }

    public Room() {
        this.id = UUID.randomUUID();
        this.reservations = new ArrayList<>();
    }

    public boolean createReservation(Reservation reservation) {
        this.reservations.add(reservation);
        return true;
    }


    public void removeReservation(String reservationId) {
        this.reservations.removeIf(i -> i.getId().toString().equals(reservationId));
    }

    public boolean updateReservation(String reservationId, Reservation updated) {
        Optional<Reservation> op = this.reservations.stream().filter(i -> i.getId().toString().equals(reservationId)).findFirst();
        if(!op.isPresent()) return false;
        Reservation res = op.get();
        res.setEmail(updated.getEmail());
        res.setFirstName(updated.getFirstName());
        res.setLastName(updated.getLastName());
        res.setFrom(updated.getFrom());
        res.setTo(updated.getTo());
        return true;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getSeats() {
        return seats;
    }

    public int getPrice() {
        return price;
    }

    public UUID getId() {
        return id;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
