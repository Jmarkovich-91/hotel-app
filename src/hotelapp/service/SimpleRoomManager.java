package hotelapp.service;

import java.util.List;
import java.util.ArrayList;

import hotelapp.domain.Room;
import hotelapp.repository.RoomDao;

public class SimpleRoomManager implements RoomManager{
	
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
		return roomDao.getRoomList();
	}
	
	public void setRoomDao (RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	
	public void bookRoom (String roomNumber) {
		roomDao.bookRoom(roomNumber);
	}
	
	public List<Room> getAvailableRooms() {
		return roomDao.getAvailableRoomList();
	}
}
