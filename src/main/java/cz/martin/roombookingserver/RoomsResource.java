package cz.martin.roombookingserver;

import cz.martin.roombookingserver.interfaces.IRoomsService;
import cz.martin.roombookingserver.models.Room;
import jakarta.validation.constraints.NotNull;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/Rooms")
public class RoomsResource {

    @Inject
    private IRoomsService roomsService;

    @GET
    @Produces("application/json")
    public Response getRooms() {
        return Response.ok().entity(roomsService.getRooms()).build();
    }

    @POST
    @Consumes("application/json")
    public Response createRoom(Room room) {
        roomsService.createRoom(room);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getRoom(@PathParam("id") @NotNull String id) {
        Optional<Room> op = roomsService.getRoom(id);
        if(!op.isPresent()) return Response.status(Response.Status.NOT_FOUND).entity("invalid id").build();
        return Response.ok().entity(op.get()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public Response updateRoom(@PathParam("id") @NotNull String id, Room room) {
        if(roomsService.updateRoom(id, room)) return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).entity("invalid id").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRoom(@PathParam("id") @NotNull String id) {
        roomsService.deleteRoom(id);
        return Response.noContent().build();
    }
}