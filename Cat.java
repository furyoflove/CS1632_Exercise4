public class Cat {
	
	/** 
	* Globals
	*/
	
	private String name, isRentedTo;
	private int id;
	private double rentalRate;
	private boolean isRented;
	
	/** 
	* empty constructor.	Simple instantiation of a Cat instance
	* default values set
	*/

	public Cat() {
	
		name = "";
		id = 0;
		rentalRate = 0.0;
		isRented = false;
		isRentedTo = "";
	
	}
	
	/** 
	* full constructor.		Instantiates a Cat instance
	* @param nName - Cat's name
	* @param nId - Cat's ID
	* @param nRentalRate - Cat's starting rental rate
	*/
	
	public Cat(String nName, int nId, double nRentalRate) {
		
		name = nName;
		id = nId;
		rentalRate = nRentalRate;
		isRented = false;
		isRentedTo = "";
		
	}
	
	/**
	* Try and rent a cat
	* returns true on success, false if cat is already rented
	*/
	
	public boolean rentCat(String rentor) {
		
		if(!isRented) { // the cat is available
			isRented = true;
			isRentedTo = rentor;
			return true;
		}
		return false;
		
	}
	
	/**
	* Try and return a cat
	* returns true on success, false if the cat is not rented out
	*/
	
	public boolean returnCat() {
		
		if(isRented) { // successfully return the cat
			isRented = false;
			isRentedTo = "";
			return true;
		}
		else { // the cat was never rented out to begin with so return an error
			return false;
		}
		
	}
	
	/**
	* Name accessor
	*/
	
	public String getName() {
		
		return name;
		
	}
	
	/**
	* ID accessor
	*/
	
	public int getId() {
		
		return id;
		
	}
	
	/**
	* Rental rate accessor
	*/
	
	public String getRate() {
		
		return "$" + String.format( "%.2f", rentalRate ) + " / day ";
		
	}
	
	/**
	* return true if the cat is not available
	*/

	public boolean isAvailable() {

		return !isRented;

	}
	
	/**
	* return name of the rentor
	*/

	public String isRentedBy() {

		return isRentedTo;

	}

	/**
	* Name mutator
	*/

	public void setName(String nName) {

		name = nName;

	}

	/**
	* Id mutator
	*/

	public void setId(int nId) {

		id = nId;

	}

	/**
	* Rental rate mutator
	*/

	public void setRate(double nRentalRate) {

		rentalRate = nRentalRate;

	}

	/**
	* Cat print method (as String)
	*/

	public String toString() {
		
		return "ID " + getId() + ". " + getName() + ": " + getRate();
		
	}
	

	public static void main(String[] args) { // tests Cat class

		Cat cat = new Cat("kitty", 1, 200.00);
		System.out.println(cat.toString() + "available for rent: " + cat.isAvailable());

		cat.rentCat("You");
		System.out.println("Cat is rented to: " + cat.isRentedBy() + ".\navailable for rent: " + cat.isAvailable());

		cat.returnCat();
		System.out.println("Cat is returned.\navailable for rent: " + cat.isAvailable());

		cat.setName("kitty-cat");
		cat.setId(2);
		cat.setRate(250.00);

		System.out.println(cat.toString());
	}


} // End of Cat class