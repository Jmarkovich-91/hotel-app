package hotelapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import hotelapp.service.BookRoom;
import hotelapp.service.BookRoomValidator;
import hotelapp.service.RoomManager;

@Controller
@RequestMapping("/bookroom.htm")
public class BookRoomFormController {
	
	private RoomManager roomManager;
	
	@Autowired
	private BookRoomValidator bookRoomValidator;
	
	@RequestMapping(method=RequestMethod.POST) 
	public String onSubmit(@ModelAttribute("bookRoom")BookRoom bookRoom,
			BindingResult result) throws ServletException {
		
		String roomNumber = bookRoom.getRoomNumber();
		bookRoomValidator.validate(bookRoom, result);
		if (result.hasErrors())
			return "bookroom";
		
		roomManager.bookRoom(roomNumber);
		return "redirect:hello.htm"; 
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView initializeForm(ModelMap model) {
		
		Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("availableRooms", this.roomManager.getAvailableRooms());
        
        model.addAttribute("bookRoom", new BookRoom());
		
		return new ModelAndView("bookroom", "model", myModel);
	}

	
    public void setRoomManager(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    public RoomManager getRoomManager() {
        return roomManager;
    }

}
