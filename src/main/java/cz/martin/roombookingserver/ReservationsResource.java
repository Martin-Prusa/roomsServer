package cz.martin.roombookingserver;

import cz.martin.roombookingserver.interfaces.IRoomsService;
import cz.martin.roombookingserver.models.MyError;
import cz.martin.roombookingserver.models.Reservation;
import cz.martin.roombookingserver.models.Room;
import cz.martin.roombookingserver.models.ValidationError;
import jakarta.validation.constraints.NotNull;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/Rooms/{id}/Reservations")
public class ReservationsResource {

    @Inject
    private IRoomsService roomsService;

    @PathParam("id")
    @NotNull
    private String id;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response createReservation( @NotNull Reservation reservation) {
        Optional<Room> op = roomsService.getRoom(id);
        if(!op.isPresent()) return Response.status(Response.Status.NOT_FOUND).build();
        ValidationError status = op.get().createReservation(reservation);
        if(status == ValidationError.OK) return Response.ok().entity(reservation).build();
        if(status == ValidationError.FROM_IS_AFTER_TO) return Response.status(Response.Status.BAD_REQUEST).entity(new MyError("Invalid dates")).build();
        return Response.status(Response.Status.BAD_REQUEST).entity(new MyError("Time is already reserved")).build();
    }
    
    @PUT
    @Consumes("application/json")
    @Path("/{reservationId}")
    public Response updateReservation(@PathParam("reservationId") @NotNull String reservationId, @NotNull Reservation reservation) {
        Optional<Room> op = roomsService.getRoom(id);
        if(!op.isPresent()) return Response.status(Response.Status.NOT_FOUND).build();
        if(op.get().updateReservation(reservationId, reservation)) return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).entity("Datum je již zarezervované").build();
    }
    
    @DELETE
    @Path("/{reservationId}")
    public Response deleteReservation(@PathParam("reservationId") @NotNull String reservationId) {
        Optional<Room> op = roomsService.getRoom(id);
        if(!op.isPresent()) return Response.status(Response.Status.NOT_FOUND).build();
        op.get().removeReservation(reservationId);
        return Response.noContent().build();
    }
}
