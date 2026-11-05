// Demo 2: Search for a key value using linear search.
import java.util.Scanner;

public class LinearSearchTest {
	public static void main(String[] args) {
		int searchKey;
		int foundIndex;
		Scanner input = new Scanner(System.in);

		// Create a 10-element random array and display it.
		LinearSearch searchArray = new LinearSearch(10);
		System.out.println(searchArray);

		// Get the search key from the user.
		System.out.print("Please enter an integer search key (-1 to quit): ");
		searchKey = input.nextInt();

		// Repeatedly input a search key; -1 terminates the program.
		while (searchKey != -1) {
			foundIndex = searchArray.iterativeLinearSearch(searchKey);

			if (foundIndex != -1) {
				System.out.println("Integer " + searchKey + " was found at index " + foundIndex + ".\n");
			} else {
				System.out.println("Integer " + searchKey + " was not found.\n");
			}

			System.out.print("Please enter an integer value (-1 to quit): ");
			searchKey = input.nextInt();
		}
	}
}
