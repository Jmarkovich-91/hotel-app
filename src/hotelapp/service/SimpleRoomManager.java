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
		room.setBooked(true);
	}
	
	public List<Room> getAvailableRooms() {
		List<Room> availableRooms = new ArrayList<Room>();
		for (Room room : rooms) {
			if (!room.getBooked()){
				availableRooms.add(room);
			}
		}
		return availableRooms;
	}
}
