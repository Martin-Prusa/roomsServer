package cz.martin.roombookingserver;

import cz.martin.roombookingserver.models.Reservation;
import cz.martin.roombookingserver.models.Room;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/Rooms/{id}/Reservations")
public class ReservationsResource {

    @Inject
    private RoomsService roomsService;

    @PathParam("id")
    private String id;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response createReservation(Reservation reservation) {
        System.out.println(reservation.toString());
        Optional<Room> op = roomsService.getRoom(id);
        if(!op.isPresent()) return Response.status(Response.Status.NOT_FOUND).build();
        if(op.get().createReservation(reservation)) return Response.ok().entity(reservation).build();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @PUT
    @Consumes("application/json")
    @Path("/{reservationId}")
    public Response updateReservation(@PathParam("reservationId") String reservationId) {
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/{reservationId}")
    public Response deleteReservation(@PathParam("reservationId") String reservationId) {
        return Response.noContent().build();
    }
}
