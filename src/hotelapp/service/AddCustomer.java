package hotelapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AddCustomer {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		logger.info("First name set to : " + firstName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		logger.info("Last name set to: " + lastName);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		logger.info("Email set to: " + email);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		logger.info("Phone number set to: " + phoneNumber);
	}

}
