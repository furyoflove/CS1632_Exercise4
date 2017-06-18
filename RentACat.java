import java.util.*;
import java.io.*;

public class RentACat {
	
	// Globals
	private static Scanner keyboard;
	
	public static void main(String[] args) {
	
		while(mainMenu()) {
			// keep looping
		}
		
		// Program exit
		keyboard.close();
		System.out.println("Closing up shop for the day! ");
	
	} // End of main
	
	
	// Load the main menu and take user input
	public static boolean mainMenu() {
		
		try {
		
			System.out.print("Option [1,2,3,4] > ");
			keyboard = new Scanner(System.in);
			String input = keyboard.nextLine();
			
			if(input.equals("1")) {
	
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
			return true; // fall through
		} 
		catch(Exception ex) { // generic error handling
			
			System.out.println(ex.toString());
			return false;
			
		}
		
	} // End of main menu display
	
	
} // End of class