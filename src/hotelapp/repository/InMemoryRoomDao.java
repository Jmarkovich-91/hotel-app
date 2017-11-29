package hotelapp.repository;

import java.util.List;

import hotelapp.domain.Room;

public class InMemoryRoomDao implements RoomDao {

	private List<Room> roomList;
	
	public InMemoryRoomDao (List<Room> roomList) {
		this.roomList = roomList;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void saveRoom(Room room) {

	}

}
