package hotelapp.service;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import hotelapp.domain.Customer;
import hotelapp.repository.CustomerDao;
import hotelapp.repository.InMemoryCustomerDao;

public class SimpleCustomerManagerTests extends TestCase {
	
	private SimpleCustomerManager customerManager;
	private List<Customer> customers;
	
	private static int CUSTOMER_COUNT = 2;
	
	private static String FIRST_CUSTOMER_ID = "1";
	private static String FIRST_LAST_NAME = "Jones";
	private static String FIRST_FIRST_NAME = "Mike";
	private static String FIRST_EMAIL = "mikejones@gmail.com";
	private static String FIRST_PHONE_NUMBER = "4109339632";
	
	private static String SECOND_CUSTOMER_ID = "2";
	private static String SECOND_LAST_NAME = "Smith";
	private static String SECOND_FIRST_NAME = "John";
	private static String SECOND_EMAIL = "johnsmith@gmail.com";
	private static String SECOND_PHONE_NUMBER = "4103691007";
	
	private static String ADD_CUSTOMER_ID = "3";
	private static String ADD_LAST_NAME = "White";
	private static String ADD_FIRST_NAME = "Walter";
	private static String ADD_EMAIL = "walterwhite@gmail.com";
	private static String ADD_PHONE_NUMBER = "4105403112";
	
	protected void setUp() throws Exception {
		customerManager = new SimpleCustomerManager();
		customers = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		customer.setId(FIRST_CUSTOMER_ID);
		customer.setLastName(FIRST_LAST_NAME);
		customer.setFirstName(FIRST_FIRST_NAME);
		customer.setEmail(FIRST_EMAIL);
		customer.setPhoneNumber(FIRST_PHONE_NUMBER);
		customers.add(customer);
		
		customer = new Customer();
		customer.setId(SECOND_CUSTOMER_ID);
		customer.setLastName(SECOND_LAST_NAME);
		customer.setFirstName(SECOND_FIRST_NAME);
		customer.setEmail(SECOND_EMAIL);
		customer.setPhoneNumber(SECOND_PHONE_NUMBER);
		customers.add(customer);
		
		CustomerDao customerDao = new InMemoryCustomerDao(customers);
		customerManager.setCustomerDao(customerDao);
	}
	
	public void testGetCustomersWithNoCustomers() {
		customerManager = new SimpleCustomerManager();
		customerManager.setCustomerDao(new InMemoryCustomerDao(null));
		assertNull(customerManager.getCustomers());
	}
	
	public void testGetCustomers() {
		List<Customer> customers = customerManager.getCustomers();
		assertNotNull(customers);
		assertEquals(CUSTOMER_COUNT, customerManager.getCustomers().size());
		
		Customer customer = customers.get(0);
		assertEquals(FIRST_CUSTOMER_ID, customer.getId());
		assertEquals(FIRST_LAST_NAME, customer.getLastName());
		assertEquals(FIRST_FIRST_NAME, customer.getFirstName());
		assertEquals(FIRST_EMAIL, customer.getEmail());
		assertEquals(FIRST_PHONE_NUMBER, customer.getPhoneNumber());
		
		customer = customers.get(1);
		assertEquals(SECOND_CUSTOMER_ID, customer.getId());
		assertEquals(SECOND_LAST_NAME, customer.getLastName());
		assertEquals(SECOND_FIRST_NAME, customer.getFirstName());
		assertEquals(SECOND_EMAIL, customer.getEmail());
		assertEquals(SECOND_PHONE_NUMBER, customer.getPhoneNumber());
	}
	
	public void testSaveCustomer() {
		Customer customer = new Customer();
		customer.setId(ADD_CUSTOMER_ID);
		customer.setLastName(ADD_LAST_NAME);
		customer.setFirstName(ADD_FIRST_NAME);
		customer.setEmail(ADD_EMAIL);
		customer.setPhoneNumber(ADD_PHONE_NUMBER);
		
		customerManager.addCustomer(customer);
		assertNotSame(CUSTOMER_COUNT, customerManager.getCustomers().size());
	}
}
