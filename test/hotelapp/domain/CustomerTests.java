package hotelapp.domain;

import junit.framework.TestCase;

public class CustomerTests extends TestCase {
	
	private Customer customer;
	
	protected void setUp() throws Exception {
		customer = new Customer ();
	}
	
	public void testSetAndGetId () {
		String testId = "aId";
		assertNull(customer.getId());
		customer.setId(testId);
		assertEquals(testId, customer.getId());
	}
	
	public void testSetAndGetFirstName () {
		String testFirstName = "aFirstName";
		assertNull(customer.getFirstName());
		customer.setFirstName(testFirstName);
		assertEquals(testFirstName, customer.getFirstName());
	}
	
	public void testSetAndGetLastName () {
		String testLastName = "aLastName";
		assertNull(customer.getLastName());
		customer.setLastName(testLastName);
		assertEquals(testLastName, customer.getLastName());
	}
	
	public void testSetAndGetEmail () {
		String testEmail = "aEmail";
		assertNull(customer.getEmail());
		customer.setEmail(testEmail);
		assertEquals(testEmail, customer.getEmail());
	}
	
	public void testSetAndGetPhoneNumber () {
		String testPhoneNumber = "aPhoneNumber";
		assertNull(customer.getPhoneNumber());
		customer.setPhoneNumber(testPhoneNumber);
		assertEquals(testPhoneNumber, customer.getPhoneNumber());
	}
}