package hotelapp.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hotelapp.domain.Customer;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerInfoValidator implements Validator{
	
	private CustomerManager customerManager;
	private List<Customer> customerList;
	
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	public boolean supports (Class clazz) {
		return AddCustomer.class.equals(clazz);
	}
	
	public void validate(Object obj, Errors err) {
		AddCustomer addCustomer = (AddCustomer) obj;
		customerList = customerManager.getCustomers();
		if (addCustomer == null) {
			err.rejectValue("email", "error.not-specified3", null, "Value required");
		} else {
			logger.info("Validating with: " + addCustomer + ": " + addCustomer.getEmail());
			if (customerList.stream().anyMatch(Customer -> Customer.getEmail().equals(addCustomer.getEmail()))) {
				err.rejectValue("email", "error.exists", null, "Customer already added");
			}
		}
	}
	
	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}

}
