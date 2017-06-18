import java.util.*;
import java.io.*;

public class RentACat {
	
	/**
	* Globals
	*/

	private static Scanner keyboard;
	private static ArrayList<Cat> cats;
	private static ArrayList<Customer> customers;
	
	/**
	* Simulate the Rent-A-Cat rental system
	*/

	public static void main(String[] args) {
	
		if(!initialize()) { // error dynamically generating cats and customers
			System.out.println("Program will now exit. ");
			return;
		}


		while(mainMenu()) {
			// keep looping
		}
		
		// Program exit
		keyboard.close();
		System.out.println("Closing up shop for the day! ");
	
	} // End of main
	
	
	/**
	* Load the main menu and take user input
	*/

	public static boolean mainMenu() {
		
		try {
		
			System.out.print("Option [1,2,3,4] > ");
			keyboard = new Scanner(System.in);
			String input = keyboard.nextLine();
			
			if(input.equals("1")) {
				System.out.println(listCats());
			}
			else if(input.equals("2")) {
				
				while(tryCatRental()) {
					// keep looping
				}

			}
			else if(input.equals("3")) {
				
			}
			else if(input.equals("4")) { // quit program
				return false;
			}
			else { // bad input
				System.out.println("Please enter a valid option! ");
				mainMenu();
			}

			return true;

		} 
		catch(Exception ex) { // generic error handling
			
			ex.printStackTrace();
			return false;
			
		}
		
	} // End of main menu display
	
	/**
	* Show the list of cats available for rent
	*/

	public static String listCats() {

		String list = "";

		for(Cat cat: cats) {

			if(cat.isAvailable()) {
				list += cat.toString() + "\n";
			}

		}
		return list.substring(0, list.lastIndexOf("\n")); // remove the trailing newline

	} // End of printing rentable cats

	/**
	* Try and rent a cat
	* First enter a customer id
	* Then enter the desired cat id (to rent it)
	*/

	public static boolean tryCatRental() {

		try {

			// find the user inputted customer id
			int id = getCustomerId();
			if(id == -1) { // escape phrase entered -- return to main menu
				return false;
			}

			// find the user inputted cat to rent(if available)
			int catId = getCatRental(customers.get(id).getName());
			if(id == -1) { // escape phrase entered -- return to main menu
				return false;
			}

			return false; // cat rental is succesful, so return to break input loop

		}
		catch(Exception ex) { // general exception handling -- break input loop

			return false;

		}

	}

	/**
	* Helper method for -- option #2 tryCatRental()
	*
	* Validates user input if it is an existing customer id
	*/

	public static int getCustomerId() {

		try {

			System.out.print("Customer ID > ");
			String input = keyboard.nextLine();

			if(input.equalsIgnoreCase("quit")) { // escape phrase -- returns to main menu
				return -1;
			}

			int id = Integer.parseInt(input);
			
			for(Customer customer: customers) {

					if(customer.getId() == id) { // id was found
						return id;
					}

			}
			// Bad input so try again
			System.out.println("That customer doesn't exist! ");
			getCustomerId();

		}
		catch(NumberFormatException nfe) { // input was not an integer

			System.out.println("That customer doesn't exist! ");
			getCustomerId();

		}

		return -1; // fall through error

	} // End of customer id validation


	/**
	* Helper method for -- option #2 tryCatRental()
	*
	* Validates user input if it is an existing cat id
	* and if cat is available to be rented
	*/

	public static int getCatRental(String rentorName) {

		try {

			System.out.print("Rent which cat? > ");
			String input = keyboard.nextLine();

			if(input.equalsIgnoreCase("quit")) { // escape phrase -- returns to main menu
				return -1;
			}

			int id = Integer.parseInt(input);

			for(Cat cat: cats) {

				if(cat.getId() == id) {
					if(cat.isAvailable()) { // successful rent
						cat.rentCat(rentorName);
						System.out.println(cat.getName() + " has been rented to Customer " + rentorName);
						return 0;
					}
					else { // cat is already rented out
						System.out.println(cat.getName() + " is not here! ");
						getCatRental(rentorName);
					}
				}

			}
			// Bad input so try again
			System.out.println("Invalid cat ID. ");
			getCatRental(rentorName);

		}
		catch(NumberFormatException nfe) { // input was not an integer

			System.out.println("Invalid cat ID. ");
			getCatRental(rentorName);

		}

		return -1; // fall through error

	} // End of cat id validation


	/**
	* Dynamically generate Cats and Customers
	*/

	public static boolean initialize() {

		try {

			cats = new ArrayList<Cat>();
			customers = new ArrayList<Customer>();

			// top 10 most common cat names in the US
			String[] possibleCatNames = 
			{
				"Bella", "Max", "Chloe", "Oliver", "Lucy",
				"Charlie", "Lily", "Sophie", "Tiger", "Shadow"
			};

			// top 10 most common first names in the US
			String[] possibleFirstNames = 
			{
				"James", "John", "Robert", "Michael", "William",
				"Mary", "Patricia", "Linda", "Barbara", "Elizabeth"
			};

			// top 10 most common last names in the US
			String[] possibleLastNames = 
			{
				"Smith", "Johnson", "Williams", "Brown", "Jones",
				"Miller", "Davis", "Garcia", "Rodriguez", "Wilson"
			};

			Random random = new Random();

			// max and min number of cats and customers allowed to be in the system
			int low = 2, 
				high = 6;

			// dynamically generate how many cats and customers will be in the system
			int numOfCats = random.nextInt(high - low) + low,
				numOfCustomers = random.nextInt(high - low) + low;

			// dynamically generate indices to help pick cat and customer names
			int[] catNames = random.ints(1, 11).distinct().limit(numOfCats).toArray(),
				firstNames = random.ints(1, 11).distinct().limit(numOfCustomers).toArray(),
				lastNames = random.ints(1, 11).distinct().limit(numOfCustomers).toArray();	

			// load cats
			for(int i = 0; i < numOfCats; i++) {

				/* 
				* dynamically generate the current cat's rental rate
				* the min is $100.00 and the max is $500.00
				*
				* the innermost calculation finds the rate
				*
				* the wrapping Math.round() call and operations 
				* will round the rate to the nearest 10's value
				*
				* ex. original rate = 369.51 will become 370.00
				*/
				double rate = Math.round( (100.00 + Math.random() * (500.00 - 100.00) ) /10) * 10;

				cats.add(new Cat(possibleCatNames[catNames[i]-1], i+1, rate));

			}

			// load customers
			for(int i = 0; i < numOfCustomers; i++) {

				customers.add(new Customer(possibleFirstNames[firstNames[i]-1], possibleLastNames[lastNames[i]-1], i+1));

			}

			return true;

		}
		catch(Exception ex) { // generic error handling

			ex.printStackTrace();
			return false;

		}

	} // End of initialize Cats and Customers

	
} // End of class