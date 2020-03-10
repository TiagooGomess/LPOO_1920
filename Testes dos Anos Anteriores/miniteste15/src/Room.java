import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room implements Facility {
    private Building building;
    private String number;
    private int floor, capacity;
    private List<User> authorizedUsers;
    Room(Building building, String number, int floor) throws IllegalArgumentException, DuplicateRoomException {
        if (floor > building.getMaxFloor() || floor < building.getMinFloor())
            throw new IllegalArgumentException();
        this.building = building;
        this.number = number;
        this.floor = floor;
        this.capacity = 0;
        this.building.addRoom(this);
        this.authorizedUsers = new ArrayList<>();
    }

    Room(Building building, String number, int floor, int capacity) throws IllegalArgumentException, DuplicateRoomException {
        if (floor > building.getMaxFloor() || floor < building.getMinFloor())
            throw new IllegalArgumentException();
        this.building = building;
        this.number = number;
        this.floor = floor;
        this.capacity = capacity;
        this.building.setCapacity(this.building.getCapacity() + this.capacity);
        this.building.addRoom(this);
    }


    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        return this.building.getName() + this.number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room(" + this.getBuilding().getName() + "," + this.getNumber() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return floor == room.floor &&
                capacity == room.capacity &&
                Objects.equals(building, room.building) &&
                Objects.equals(number, room.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, number, floor, capacity);
    }

    public void authorize(User user) {
        this.authorizedUsers.add(user);
    }

    public boolean canEnter(User user) {
        return this.authorizedUsers.contains(user);
    }

    public List<User> getAuthorizedUsers() {
        return this.authorizedUsers;
    }

}
