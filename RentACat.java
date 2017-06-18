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
				listCats();
			}
			else if(input.equals("2")) {
				
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
			return false; // fall through error -- so break out

		} 
		catch(Exception ex) { // generic error handling
			
			ex.printStackTrace();
			return false;
			
		}
		
	} // End of main menu display
	

	public static void listCats() {

		for(Cat cat: cats) {

			if(cat.isAvailable()) {
				System.out.println(cat.toString());
			}

		}

	}

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