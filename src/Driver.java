/**
 * Project Title: Factorials Lab
 * Project Description: This program allows the user to input an integer value whose factorial will be produced by implementing
 * 						double linked lists. The program will output the number, the amount of microseconds it took to calculate
 * 						the factorial, the number of digits in the factorial, and the factorial solution. 
 *   Version or Date: April 27, 2018.
 *   How to Start the Project: Press the run tab in the command window.
 *   User Instructions: Press the run button and input the relevant information via the keyboard.
 */

import java.util.*;
import java.io.*;

/**

 * The Driver class stores the main method. Its purpose is to call upon the Factorials object's methods in order to 
 * calculate and print the factorial of the number provided by the user.
 */

public class Driver 
{
	/**
	 * The main method contains a File object which contains the csis_factorials.txt file, a PrintWriter object
	 * which is to output information to the csis_factorials.txt file, a Scanner object which will allow the user to type information 
	 * for the program, and a Factorials object which will allow the main method to call methods to calculate the factorial of the
	 * integer value provided by the user. The user can input information until he/she inputs 0 via the main menu.
	 */
	
	public static void main(String[] args) throws IOException
	{
		File file = new File("csis_factorials.txt");
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(file);
		Factorials factorial = new Factorials(pw);
		int choice;
		do {
			System.out.println("Enter the value of the factorial: ");
			pw.println("Enter the value of the factorial: ");
			choice = s.nextInt();
			System.out.print(choice + "! ");
			pw.print(choice + "! ");
			DLL factList = factorial.getList(choice);
			factorial.printDigits(factList);
			factorial.printFactorial(factList);
			System.out.println("Enter another value? 0 = No, 0 < Yes");
			pw.println("Enter another value? 0 = No, 0 < Yes");
			choice = s.nextInt();
		} while(choice != 0);
		System.out.println("Goodbye.");
		pw.println("Goodbye");
		pw.close();
	}
}
