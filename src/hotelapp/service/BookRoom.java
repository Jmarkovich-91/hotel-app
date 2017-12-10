package hotelapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BookRoom {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    private String roomNumber;
    
    public void setRoomNumber (String roomNumber) {
    	this.roomNumber = roomNumber;
    	logger.info("Room number set to: " + roomNumber);
    }
    
    public String getRoomNumber () {
    	return roomNumber;
    }

}
