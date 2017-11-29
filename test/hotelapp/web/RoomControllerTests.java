package hotelapp.web;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import hotelapp.web.RoomController;
import hotelapp.service.SimpleRoomManager;
import hotelapp.domain.Room;
import hotelapp.repository.InMemoryRoomDao;

import junit.framework.TestCase;

public class RoomControllerTests extends TestCase {

    public void testHandleRequestView() throws Exception{		
        RoomController controller = new RoomController();
        SimpleRoomManager srm = new SimpleRoomManager();
        srm.setRoomDao(new InMemoryRoomDao(new ArrayList<Room>()));
        controller.setRoomManager(srm);
        //controller.setRoomManager(new SimpleRoomManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        Map modelMap = (Map) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }
}