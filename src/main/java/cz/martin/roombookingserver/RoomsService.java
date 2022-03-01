package cz.martin.roombookingserver;

import cz.martin.roombookingserver.interfaces.IRoomsService;
import cz.martin.roombookingserver.models.Room;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Optional;

@ApplicationScoped
public class RoomsService implements IRoomsService {

    private ArrayList<Room> rooms;

    public RoomsService() {
        this.rooms = new ArrayList<>();
    }

    @Override
    public void createRoom(Room room) {
        this.rooms.add(room);
    }

    @Override
    public void deleteRoom(String id) {
        this.rooms.removeIf(i -> i.getId().toString().equals(id));
    }

    @Override
    public boolean updateRoom(String id, Room updated) {
        Optional<Room> optionalRoom = this.rooms.stream().filter(i -> i.getId().toString().equals(id)).findFirst();
        if(!optionalRoom.isPresent()) return false;
        Room r = optionalRoom.get();
        r.setDescription(updated.getDescription());
        r.setTitle(updated.getTitle());
        r.setPrice(updated.getPrice());
        r.setSeats(updated.getSeats());
        return true;
    }

    @Override
    public Optional<Room> getRoom(String id) {
        return this.rooms.stream().filter(i -> i.getId().toString().equals(id)).findFirst();
    }

    @Override
    public ArrayList<Room> getRooms() {
        return new ArrayList<>(this.rooms);
    }
}
