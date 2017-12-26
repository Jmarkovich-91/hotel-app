package hotelapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import hotelapp.domain.Room;

public class JdbcRoomDao implements RoomDao {
	
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    
    public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
    	return namedJdbcTemplate;
    }
    
    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
    	this.namedJdbcTemplate = namedJdbcTemplate;
    }


    public List<Room> getRoomList() {
        logger.info("Getting rooms!");
        List<Room> rooms = namedJdbcTemplate.query(
                "select room_number, type, price, booked from rooms", 
                new RoomMapper());
        return rooms;
    }
    
    public List<Room> getAvailableRoomList() {
    	logger.info("Getting available rooms!");
        List<Room> rooms = namedJdbcTemplate.query(
                "select room_number, type, price, booked from rooms where booked='false'", 
                new RoomMapper());
        return rooms;
    }

    public void saveRoom(Room room) {
        logger.info("Saving room: " + room.getRoomNumber());
        int count = namedJdbcTemplate.update(
            "update rooms set type=:type, price=:price, booked=:booked where room_number=:room_number",
            new MapSqlParameterSource().addValue("type", room.getType())
            	.addValue("price", room.getPrice())
                .addValue("booked", room.getBooked())
                .addValue("room_number", room.getRoomNumber()));
        logger.info("Rows affected: " + count);
    }
    
    public void bookRoom(String roomNumber) {
    	logger.info("Booking room: " + roomNumber);
    	int count = namedJdbcTemplate.update(
    			"update rooms set booked='true' where room_number=:roomNumber",
    			new MapSqlParameterSource().addValue("roomNumber", roomNumber));
    	logger.info("Rows affected: " + count);
    }
    
    private static class RoomMapper implements RowMapper<Room> {

        public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
            Room room = new Room();
            room.setRoomNumber(rs.getString("room_number"));
            room.setType(rs.getString("type"));
            room.setPrice(new Double(rs.getDouble("price")));
            room.setBooked(rs.getBoolean("booked"));
            return room;
        }

    }


}
