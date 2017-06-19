import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*;

public class CustomerTest {
	
	// Asserts that creating a new customer instance
	// does not return null
	@Test
	public void testCustomerExists() {

		Customer customer = new Customer();
		assertNotNull(customer);

	}


	// Assert that creating a new Customer instance
	// using the full constructor
	// does not return null	
	@Test
	public void testCustomerExistsFullConstructor() {

		Customer customer = new Customer("John", "Smith", 1);
		assertNotNull(customer);

	}

	// Asserts that changing the Customer name
	// works as compared to an expected value
	@Test
	public void testCustomerNameChange() {

		Customer customer = new Customer("John", "Smith", 1);
		String newFirst = "Joe";
		String newLast = "Buck";
		customer.setName(newFirst, newLast);
		assertEquals(customer.getName(), newFirst + " " + newLast);

	}


	// Asserts that changing the Customer ID
	// works as compared to an expected value
	@Test
	public void testCustomerIdChange() {

		Customer customer = new Customer("John", "Smith", 1);
		int newId = 2;
		customer.setId(newId);
		assertEquals(newId, customer.getId());

	}

	// Assert that printing the Customer
	// returns an expected value.
	@Test
	public void testCustomerIsPrintable() {

		Customer customer = new Customer("John", "Smith", 1);
		String expectedToString = "Customer Id 1. John Smith";
		assertEquals(expectedToString, customer.toString());

	}


} // End of Customer test class