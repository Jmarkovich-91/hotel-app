package hotelapp.service;

import java.util.List;

import hotelapp.domain.Customer;
import hotelapp.repository.CustomerDao;

public class SimpleCustomerManager implements CustomerManager {
	
	private CustomerDao customerDao;

	public List<Customer> getCustomers() {
		return customerDao.getCustomerList();
	}

	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
