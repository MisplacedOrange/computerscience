// Demo 1: Class that contains an array of random integers and linear search methods.
import java.util.Arrays;
import java.util.Random;

public class LinearSearch {
	private int[] data;

	// Create an array of a given size and fill it with random integers.
	public LinearSearch(int size) {
		data = new int[size];
		Random generator = new Random();

		// Fill the array with random two-digit integers in the range 10-99.
		for (int i = 0; i < size; i++) {
			data[i] = 10 + generator.nextInt(90);
		}
	}

	// Performs an iterative linear search for searchKey in the array.
	// Returns the index where searchKey is found, or -1 otherwise.
	public int iterativeLinearSearch(int searchKey) {
		// Loop through the array sequentially.
		for (int index = 0; index < data.length; index++) {
			if (data[index] == searchKey) {
				return index; // Return the index of the integer.
			}
		}
		return -1; // The integer was not found.
	}

	// This is not actually a recursive method. It is a public method that
	// calls the private recursiveLinearSearch() method, passing in the index
	// of the first element of the data array to search. This way, the user does
	// not need to worry about internal details like indices.
	public int recursiveLinearSearch(int searchKey) {
		return recursiveLinearSearch(searchKey, 0);
	}

	// This private recursive method performs a linear search for searchKey at the
	// given index. It returns the index where searchKey is found, or -1 otherwise.
	private int recursiveLinearSearch(int searchKey, int index) {
		if (index >= data.length) {
			return -1;
		}
		if (data[index] == searchKey) {
			return index;
		}
		return recursiveLinearSearch(searchKey, index+1);
	}

	// Returns a string of all elements in the array.
	@Override
	public String toString() {
		return Arrays.toString(data);
	}
}
