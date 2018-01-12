package hotelapp.repository;

import java.util.ArrayList;
import java.util.List;

import hotelapp.domain.Room;

public class InMemoryRoomDao implements RoomDao {

	private List<Room> roomList;
	private List<Room> availableRooms;
	
	public InMemoryRoomDao (List<Room> roomList) {
		this.roomList = roomList;
	}

	public List<Room> getRoomList() {
		return roomList;
	}
	
	public List<Room> getAvailableRoomList() {
		availableRooms = new ArrayList<Room>();
		for (Room room:roomList) {
			if (room.getBooked() == false) {
				availableRooms.add(room);
			}
		}
		return availableRooms;
	}

	public void saveRoom(Room room) {
		for (Room rooms : roomList) {
			if (rooms.equals(room)) {
				rooms.setBooked(room.getBooked());
				rooms.setPrice(room.getPrice());
				rooms.setType(room.getType());
			}
		}
	}
	
	public void bookRoom(String roomNumber) {
		for (Room room : roomList) {
			if (room.getRoomNumber().equals(roomNumber)) {
				room.setBooked(true);
			}
		}
	}

}
