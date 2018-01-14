package hotelapp.repository;

import java.util.List;

import hotelapp.domain.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomerList();
	
	public void addCustomer(Customer customer);

}
