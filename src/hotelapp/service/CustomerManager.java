package hotelapp.service;

import java.io.Serializable;

import java.util.List;

import hotelapp.domain.Customer;

public interface CustomerManager extends Serializable {
	
	public List<Customer> getCustomers();
	
	public void addCustomer(Customer customer);

}
