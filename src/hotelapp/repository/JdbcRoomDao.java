package hotelapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import hotelapp.domain.Room;

public class JdbcRoomDao extends JdbcDaoSupport implements RoomDao {
	
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());


    public List<Room> getRoomList() {
        logger.info("Getting rooms!");
        List<Room> rooms = getJdbcTemplate().query(
                "select room_number, type, price, booked from rooms", 
                new RoomMapper());
        return rooms;
    }

    public void saveRoom(Room room) {
        logger.info("Saving room: " + room.getRoomNumber());
        int count = getJdbcTemplate().update(
            "update rooms set type = :type, price = :price, booked = :booked where room_number = :room_number",
            new MapSqlParameterSource().addValue("type", room.getType())
            	.addValue("price", room.getPrice())
                .addValue("booked", room.getBooked())
                .addValue("room_number", room.getRoomNumber()));
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
