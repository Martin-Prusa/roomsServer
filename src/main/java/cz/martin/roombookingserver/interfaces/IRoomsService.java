package cz.martin.roombookingserver.interfaces;

import cz.martin.roombookingserver.models.Room;

import java.util.ArrayList;
import java.util.Optional;

public interface IRoomsService {

    void createRoom(Room room);
    void deleteRoom(String id);
    boolean updateRoom(String id, Room updated);
    Optional<Room> getRoom(String id);
    ArrayList<Room> getRooms();

}
