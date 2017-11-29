/*package hotelapp.repository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import hotelapp.domain.Room;

import java.util.List;

@ContextConfiguration
@Transactional
public class JdbcRoomDaoTests extends AbstractTransactionalJUnit4SpringContextTests {

	protected final Log logger = LogFactory.getLog(getClass());

	private RoomDao roomDao;

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	protected String[] getConfigLocations() {
		return new String[] { "classpath:test-context.xml" };
	}

	protected void onSetUpInTransaction() throws Exception {
		super.deleteFromTables(new String[] { "rooms" });
		super.executeSqlScript("file:db/load_data.sql", true);
	}
	
	@Test
	public void testGetRoomList() {

		List<Room> rooms = roomDao.getRoomList();

		assertEquals("wrong number of rooms?", 3, rooms.size());

	}

	@Test
	public void testSaveRoom() {

		List<Room> rooms = roomDao.getRoomList();

		for (Room r : rooms) {
			r.setPrice(200.12);
			roomDao.saveRoom(r);
		}

		List<Room> updatedRooms = roomDao.getRoomList();
		for (Room r : updatedRooms) {
			assertEquals("wrong price of room?", 200.12, r.getPrice());
		}

	}

}*/
