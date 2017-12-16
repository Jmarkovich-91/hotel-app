package hotelapp.service;

import java.io.Serializable;
import java.util.List;

import hotelapp.domain.Room;

public interface RoomManager extends Serializable{

	public void increasePrice (int percentage);
	
	public List<Room> getRooms();
	
	public void bookRoom (String roomNumber);
	
	public List<Room> getAvailableRooms();
}
