public class Customer {
	
	/**
	* Globals
	*/

	private String first, last;
	private int id;

	/**
	* empty constructor
	* sets default values
	*/
	public Customer() {

		first = "";
		last = "";
		id = 0;

	}

	/**
	* full constructor.		Instantiate Customer instance
	* sets default values
	*/
	public Customer(String nFirst, String nLast, int nId) {

		first = nFirst;
		last = nLast;
		id = nId;

	}

	/**
	* Name accessor
	*/

	public String getName() {

		return first + " " + last;

	}

	/**
	* id accessor
	*/

	public int getId() {

		return id;

	}

	/**
	* Name mutator
	*/
	public void setName(String nFirst, String nLast) {

		first = nFirst;
		last = nLast;

	}


	/**
	* id mutator
	*/
	public void setId(int nId) {

		id = nId;

	}


	/**
	* Customer print method
	*/
	public String toString() {

		return "Customer Id " + getId() + ". " + getName();

	}

	public static void main(String[] args) { // simple test for Customer class

		Customer customer = new Customer("John", "Smith", 1);
		System.out.println(customer.toString());

		customer.setName("Joe", "Buck");
		customer.setId(2);

		System.out.println("New name and Id: " + customer.toString());

	}


} // End of Customer last