package hotelapp.web;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hotelapp.domain.Customer;
import hotelapp.service.AddCustomer;
import hotelapp.service.CustomerInfoValidator;
import hotelapp.service.CustomerManager;

@Controller
@RequestMapping("/customerinfo.htm")
public class CustomerInfoFormController {

	private CustomerManager customerManager;
	
	@Autowired
	private CustomerInfoValidator customerInfoValidator;
	
	@RequestMapping(method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute("addCustomer")AddCustomer addCustomer,
			BindingResult result) throws ServletException {
		
		Customer customer = new Customer ();
		customer.setFirstName(addCustomer.getFirstName());
		customer.setLastName(addCustomer.getLastName());
		customer.setEmail(addCustomer.getEmail());
		customer.setPhoneNumber(addCustomer.getPhoneNumber());
		customerInfoValidator.validate(addCustomer, result);
		
		if (result.hasErrors()) return "customerinfo";
		
		customerManager.addCustomer(customer);
		return "redirect:hello.htm";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView initializeForm(ModelMap model) {
		model.addAttribute("addCustomer", new AddCustomer());
		return new ModelAndView ("customerinfo", "model", model);
	}
	
	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}
	
	public CustomerManager getCustomerManager() {
		return customerManager;
	}
}
