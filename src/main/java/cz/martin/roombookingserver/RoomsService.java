package cz.martin.roombookingserver;

import cz.martin.roombookingserver.models.Room;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Optional;

@ApplicationScoped
public class RoomsService {

    private ArrayList<Room> rooms;

    public RoomsService() {
        this.rooms = new ArrayList<>();
    }

    public void createRoom(Room room) {
        this.rooms.add(room);
    }

    public void deleteRoom(String id) {
        this.rooms.removeIf(i -> i.getId().toString().equals(id));
    }

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

    public Optional<Room> getRoom(String id) {
        return this.rooms.stream().filter(i -> i.getId().toString().equals(id)).findFirst();
    }

    public ArrayList<Room> getRooms() {
        return new ArrayList<>(this.rooms);
    }
}
