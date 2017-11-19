package hotelapp.domain;

import junit.framework.TestCase;

public class RoomTests extends TestCase {
	
	private Room room;
	
	protected void setUp () throws Exception {
		room = new Room ();
	}
	
	public void testSetAndGetRoomNumber () {
		String testRoomNumber = "aRoomNumber";
		assertNull(room.getRoomNumber());
		room.setRoomNumber(testRoomNumber);
		assertEquals (testRoomNumber, room.getRoomNumber());
	}
	
	public void testSetAndGetType () {
		String testType = "aType";
		assertNull(room.getType());
		room.setType(testType);
		assertEquals (testType, room.getType());
	}
	
	public void testSetAndGetPrice () {
		double testPrice = 100.00;
		assertEquals (0, 0, 0);
		room.setPrice(testPrice);
		assertEquals (testPrice, room.getPrice(), 0);
	}
	
	public void testSetAndGetBooked () {
		boolean testBooked = true;
		assertEquals(false, room.getBooked());
		room.setBooked(testBooked);
		assertEquals(testBooked, room.getBooked());
	}
	
}