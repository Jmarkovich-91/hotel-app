package hotelapp.repository;

import java.util.ArrayList;
import java.util.List;

import hotelapp.domain.Customer;

public class InMemoryCustomerDao implements CustomerDao{
	
	public List<Customer> customers;
	
	public InMemoryCustomerDao (List<Customer> customers) {
		this.customers = customers;
	}
	
	public List<Customer> getCustomerList() {
		return customers;
	}
	
	public void addCustomer (Customer customer) {
		customers.add(customer);
	}

}
