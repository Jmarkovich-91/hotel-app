package hotelapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;

import hotelapp.service.PriceIncrease;
import hotelapp.service.PriceIncreaseValidator;
import hotelapp.service.RoomManager;

@Controller
@RequestMapping("/priceincrease.htm")
public class PriceIncreaseFormController {
	
	@Autowired
    private PriceIncreaseValidator priceIncreaseValidator;

    private RoomManager roomManager;
    
    @RequestMapping(method=RequestMethod.POST) 
    public String onSubmit(@ModelAttribute("priceIncrease")PriceIncrease priceIncrease, 
            BindingResult result)
            throws ServletException {

        //int increase = priceIncrease.getPercentage(); 
        priceIncreaseValidator.validate(priceIncrease, result); 
        if (result.hasErrors()) 
            return "priceIncrease"; 
           
        // Validator has succeeded. 
        // Perform necessary actions and return to success page. 
        return "redirect:hello.htm"; 
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String initializeForm(ModelMap model) { 
        // Perform and Model / Form initialization
        Map<Integer, String> priority = new LinkedHashMap<Integer, String>();
        priority.put(1, "Low");
        priority.put(2, "Normal");
        priority.put(3, "High");
  
        model.addAttribute("priorityList", priority);
        model.addAttribute("priceIncrease", new PriceIncrease());
   
        return "priceincrease"; 
    } 

    public void setRoomManager(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    public RoomManager getRoomManager() {
        return roomManager;
    }

}
