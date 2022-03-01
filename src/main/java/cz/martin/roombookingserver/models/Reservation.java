package cz.martin.roombookingserver.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {

    private UUID id;

    @Email(message = "Email should be valid")
    @NotNull
    private String email;

    @Length(min = 3, max = 50, message = "About Me must be between 3 and 50 characters")
    @NotNull
    private String firstName;

    @Length(min = 3, max=50 , message = "About Me must be between 3 and 50 characters")
    @NotNull
    private String lastName;

    @NotNull
    private LocalDateTime from;

    @NotNull
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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
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
