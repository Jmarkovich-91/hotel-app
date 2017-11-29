package hotelapp.service;

import java.util.List;
import java.util.ArrayList;

import hotelapp.domain.Room;
import hotelapp.repository.RoomDao;

public class SimpleRoomManager implements RoomManager{
	
	//private List<Room> rooms;
	private RoomDao roomDao;

	public void increasePrice (int percentage) {
		List<Room> rooms = roomDao.getRoomList();
        if (rooms != null) {
            for (Room room : rooms) {
                double newPrice = room.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                room.setPrice(newPrice);
                roomDao.saveRoom(room);
            }
        }
	}
	
	public List<Room> getRooms() {
		//return rooms;
		return roomDao.getRoomList();
	}
	
//	public void setRooms (List<Room> rooms) {
//		this.rooms = rooms;
//	}
	
	public void setRoomDao (RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	
	public void bookRoom (Room room) {
		room.setBooked(true);
	}
	
	public List<Room> getAvailableRooms() {
		List<Room> availableRooms = new ArrayList<Room>();
		List<Room> rooms = roomDao.getRoomList();
		for (Room room : rooms) {
			if (!room.getBooked()){
				availableRooms.add(room);
			}
		}
		return availableRooms;
	}
}
