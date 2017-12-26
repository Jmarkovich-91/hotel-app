package hotelapp.service;

import org.springframework.validation.Validator;

import hotelapp.domain.Room;
import hotelapp.repository.RoomDao;

import org.springframework.validation.Errors;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BookRoomValidator implements Validator {
	
	private RoomManager roomManager;
	private List<Room> availableRoomList;
	
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	public boolean supports (Class clazz) {
		return BookRoom.class.equals(clazz);
	}
	
	public void validate (Object obj, Errors err) {
		BookRoom br = (BookRoom) obj;
		availableRoomList = roomManager.getAvailableRooms();
		if (br == null) {
			err.rejectValue("roomNumber", "error.not-specified2", null, "Value required.");
		} else {
			logger.info("Validating with " + br + ": " + br.getRoomNumber());
			if (!availableRoomList.stream().anyMatch(Room -> Room.getRoomNumber().equals(br.getRoomNumber()))){
				err.rejectValue("roomNumber", "error.booked", null, "Room already booked");
			}
		}
	}
	
	public void setRoomManager (RoomManager roomManager) {
		this.roomManager = roomManager;
	}

}
