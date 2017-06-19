import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.*;

public class CatTest {
	

	// Assert that creating a new Cat instance
	// does not return null	
	@Test
	public void testCatExists() {

		Cat cat = new Cat();
		assertNotNull(cat);

	}


	// Assert that creating a new Cat instance
	// using the full constructor
	// does not return null	
	@Test
	public void testCatExistsFullConstructor() {

		Cat cat = new Cat("Cat", 1, 200.00);
		assertNotNull(cat);

	}	

	// Asserts that chaning the Cat name
	// works as compared to an expected value
	@Test
	public void testCatNameChange() {

		Cat cat = new Cat("Cat", 1, 200.00);
		String newName = "Kitty";
		cat.setName(newName);
		assertEquals(newName, cat.getName());

	}	

	// Asserts that chaning the Cat ID
	// works as compared to an expected value
	@Test
	public void testCatIdChange() {

		Cat cat = new Cat("Cat", 1, 200.00);
		int newId = 2;
		cat.setId(newId);
		assertEquals(newId, cat.getId());

	}

	// Asserts that chaning the Cat rental rate
	// works as compared to an expected value
	@Test
	public void testCatRateChange() {

		Cat cat = new Cat("Cat", 1, 200.00);
		double newRate = 250.00;
		cat.setRate(newRate);
		assertEquals(newRate, 
			Double.parseDouble(cat.getRate().substring(1,cat.getRate().lastIndexOf(" / day "))),
			1.00);

	}

	// Asserts that renting a Cat
	// works and returns true
	@Test
	public void testCatIsRentable() {

		Cat cat = new Cat("Cat", 1, 200.00);
		String rentor = "You";
		boolean isRented = cat.rentCat(rentor);
		assertEquals(isRented, true);

	}

	// Asserts that returning a Cat
	// works and returns true
	@Test
	public void testCatIsReturnable() {

		Cat cat = new Cat("Cat", 1, 200.00);
		String rentor = "You";
		boolean isRented = cat.rentCat(rentor);
		boolean isReturned = cat.returnCat();
		assertEquals(isReturned, true);

	}	

	// Assert that printing the Cat
	// returns an expected value.
	@Test
	public void testCatIsPrintable() {

		Cat cat = new Cat("Cat", 1, 200.00);
		String expectedToString = "ID " + 1 + ". Cat: $" + String.format("%.2f", 200.00) + " / day ";
		assertEquals(expectedToString, cat.toString());

	}

	// Asserts that attempting to rent an already rented out Cat
	// does not work and returns false
	@Test
	public void testCatNoMultipleRents() {

		Cat cat = new Cat("Cat", 1, 200.00);
		String rentor = "You";
		boolean isRented = cat.rentCat(rentor);
		boolean tryAgain = cat.rentCat(rentor);
		assertEquals(tryAgain, false);

	}

	// Asserts that attempting to return a Cat that is not rented out
	// does not work and returns false
	@Test
	public void testCatNoMultipleReturns() {

		Cat cat = new Cat("Cat", 1, 200.00);
		String rentor = "You";
		boolean isRented = cat.rentCat(rentor);
		boolean isReturned = cat.returnCat();
		boolean returnAgain = cat.returnCat();
		assertEquals(returnAgain, false);

	}


} // End of Cat test class