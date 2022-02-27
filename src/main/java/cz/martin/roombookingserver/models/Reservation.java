package cz.martin.roombookingserver.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {

    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDateTime from;
    private LocalDateTime to;

    public Reservation(String email, String firstName, String lastName, LocalDateTime from, LocalDateTime to) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.from = from;
        this.to = to;
    }

    public Reservation() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
