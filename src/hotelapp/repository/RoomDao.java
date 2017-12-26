package hotelapp.repository;

import java.util.List;

import hotelapp.domain.Room;

public interface RoomDao {
	
	public List<Room> getRoomList();
	
	public List<Room> getAvailableRoomList();
	
	public void saveRoom (Room room);
	
	public void bookRoom (String roomNumber);

}
