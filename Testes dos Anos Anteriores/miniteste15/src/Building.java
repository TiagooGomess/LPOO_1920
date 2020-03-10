import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Building implements Facility {
    private String name;
    private int minFloor, maxFloor, capacity;
    private List<Room> rooms;
    Building(String name, int minFloor, int maxFloor) throws IllegalArgumentException {
        if (minFloor > maxFloor)
            throw new IllegalArgumentException();
        this.name = name;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.capacity = 0;
        this.rooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public void setMinFloor(int minFloor) {
        this.minFloor = minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public String toString() {
        return "Building(" + this.getName() + ")";
    }

    public void addRoom(Room room) throws DuplicateRoomException {
        if (!rooms.contains(room))
            this.rooms.add(room);
        else
            throw new DuplicateRoomException();
    }


    public boolean canEnter(User user) {
        for (Room room: rooms) {
            List<User> authorizedUsers = room.getAuthorizedUsers();
            if (authorizedUsers.contains(user))
                return true;
        }
        return false;
    }
}
