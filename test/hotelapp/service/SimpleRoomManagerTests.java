package hotelapp.service;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import hotelapp.domain.Room;

public class SimpleRoomManagerTests extends TestCase{
	
	private SimpleRoomManager roomManager;
	private List<Room> rooms;
	
	private static int ROOM_COUNT = 2;
	private static int AVAILABLE_ROOM_COUNT = 1;
	
	private static String SUITE_ROOM_NUMBER = "1";
	private static String SUITE_TYPE = "Suite";
	private static Double SUITE_PRICE = 150.00;
	private static boolean SUITE_BOOKED = true;
	
	private static String ACCESSIBLE_ROOM_NUMBER = "2";
	private static String ACCESSIBLE_TYPE = "Accessible";
	private static Double ACCESSIBLE_PRICE = 100.00;
	private static boolean ACCESSIBLE_BOOKED = false;
	
	private static int POSITIVE_PRICE_INCREASE = 10;
	
	protected void setUp() throws Exception {
		roomManager = new SimpleRoomManager();
		rooms = new ArrayList<Room>();
		
		Room room = new Room();
		room.setRoomNumber(SUITE_ROOM_NUMBER);
		room.setType(SUITE_TYPE);
		room.setPrice(SUITE_PRICE);
		room.setBooked(SUITE_BOOKED);
		rooms.add(room);
		
		room = new Room();
		room.setRoomNumber(ACCESSIBLE_ROOM_NUMBER);
		room.setType(ACCESSIBLE_TYPE);
		room.setPrice(ACCESSIBLE_PRICE);
		room.setBooked(ACCESSIBLE_BOOKED);
		rooms.add(room);
		
		roomManager.setRooms(rooms);
	}
	
	public void testGetRoomsWithNoRooms () {
		roomManager = new SimpleRoomManager();
		assertNull (roomManager.getRooms());
	}
	
	public void testGetRooms() {
		List<Room> rooms = roomManager.getRooms();
		assertNotNull(rooms);
		assertEquals(ROOM_COUNT, roomManager.getRooms().size());
		
		Room room = rooms.get(0);
		assertEquals(SUITE_ROOM_NUMBER, room.getRoomNumber());
		assertEquals(SUITE_TYPE, room.getType());
		assertEquals(SUITE_PRICE, room.getPrice());
		assertEquals(SUITE_BOOKED, room.getBooked());
		
		room = rooms.get(1);
		assertEquals(ACCESSIBLE_ROOM_NUMBER, room.getRoomNumber());
		assertEquals(ACCESSIBLE_TYPE, room.getType());
		assertEquals(ACCESSIBLE_PRICE, room.getPrice());
		assertEquals(ACCESSIBLE_BOOKED, room.getBooked());
	}
	
    public void testIncreasePriceWithNullListOfRooms() {
        try {
            roomManager = new SimpleRoomManager();
            roomManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch(NullPointerException ex) {
            fail("Rooms list is null.");
        }
    }
    
    public void testIncreasePriceWithEmptyListOfRooms() {
        try {
        	roomManager = new SimpleRoomManager();
        	roomManager.setRooms(new ArrayList<Room>());
        	roomManager.increasePrice(POSITIVE_PRICE_INCREASE);
        }
        catch(Exception ex) {
            fail("Rooms list is empty.");
        }           
    }
    
    public void testIncreasePriceWithPositivePercentage() {
    	roomManager.increasePrice(POSITIVE_PRICE_INCREASE);
        double expectedSuitePriceWithIncrease = 165.00;
        double expectedAccessiblePriceWithIncrease = 110.00;
        
        List<Room> rooms = roomManager.getRooms();      
        Room room = rooms.get(0);
        assertEquals(expectedSuitePriceWithIncrease, room.getPrice());
        
        room = rooms.get(1);      
        assertEquals(expectedAccessiblePriceWithIncrease, room.getPrice());       
    }
    
    public void testGetAvailableRooms() {
    	List<Room> rooms = roomManager.getAvailableRooms();
		assertNotNull(rooms);
		assertEquals(AVAILABLE_ROOM_COUNT, roomManager.getAvailableRooms().size());
		
		Room room = rooms.get(0);
		assertEquals(ACCESSIBLE_ROOM_NUMBER, room.getRoomNumber());
    }
    
    public void testBookRoom() {
    	List<Room> rooms = roomManager.getRooms();
    	roomManager.bookRoom(rooms.get(1));
    	assertEquals(true, rooms.get(1).getBooked());
    }

}