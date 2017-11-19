package hotelapp.service;

import java.util.List;
import java.util.ArrayList;

import hotelapp.domain.Room;

public class SimpleRoomManager implements RoomManager{
	
	private List<Room> rooms;

	public void increasePrice (int percentage) {
        if (rooms != null) {
            for (Room room : rooms) {
                double newPrice = room.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                room.setPrice(newPrice);
            }
        }
	}
	
	public List<Room> getRooms() {
		return rooms;
	}
	
	public void setRooms (List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void bookRoom (Room room) {
		throw new UnsupportedOperationException();
	}
	
	public List<Room> getAvailableRooms() {
		throw new UnsupportedOperationException();
	}
}
