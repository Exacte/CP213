package coop8200_a4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author mason
 *
 */
public class JumpIt {
	private String fileName; // name of the file
	private int count = 0; // number of valid integers in the file
	private final int MAX_SIZE = 15; // the size of the array
	private int[] myArray;

	// constructor to set the game by reading integers from file
	// read only MAX_SIZE integers from the file, bad ints are ignored
	// print out a message if file cannot be opened
	/**
	 * 
	 * @param theName
	 */
	public JumpIt(String theName) { // constructor to set the file name
		this.fileName = new String(theName);
		myArray = makeArray(MAX_SIZE);
	}

	// return the lowest total cost of the game
	// throws an exception if the first int is not 0
	/**
	 * 
	 * @return
	 * @throws BadInputException
	 */
	public int play() throws BadInputException {
		if (myArray[0] != 0) {
			throw new BadInputException();
		}
		return play(myArray, 0, count - 1);
	}

	/**
	 * 
	 * @param a
	 * @param first
	 * @param last
	 * @return
	 */
	private int play(int[] a, int first, int last) {
		first++;
		int second = first + 1;
		int third = second + 1;
		int forth = third + 1;
		if (last % 2 == 0) {
			if (first == last - 4 && last > 5) {
				if (a[first] + a[third] < a[second] + a[forth]){
					return a[last] + a[first] + a[third];
				}
				else
					return a[last] + a[second] + a[forth];
			} else if (first == last - 1 || first == last - 2) {
				return a[last];
			} else if (a[second] < a[first] + a[third]) {
				System.out.println(a[second]);
				return play(a, second, last) + a[second];
			} else {
				return play(a, first, last) + a[first];
			}
		} else {
			if (first == last - 1 || first == last - 2) {
				return a[last] + a[first];
			} else if (a[second] < a[first] + a[third]) {
				return play(a, second, last) + a[second];
			} else {
				return play(a, first, last) + a[first];
			}
		}
	}

	// print the all integers in the array in ONE line
	/**
	 * 
	 */
	public void printGame() {
		int counter = 0;
		while (counter < count) {
			System.out.print(myArray[counter] + " ");
			counter++;
			if (counter == 10)
				System.out.println("");
		}
		System.out.println("");
	}

	/**
	 * 
	 * @param size
	 * @return
	 */
	public int[] makeArray(int size) {
		int[] theArray = new int[size];
		boolean incorrectInt = false;

		System.out.println("openning file " + fileName + " ...");

		try {
			Scanner infile = new Scanner(new File(fileName));
			while (infile.hasNext() && count != size) {
				if (infile.hasNextInt()) {
					theArray[count] = infile.nextInt();
					count++;
				} else {
					infile.next();
					incorrectInt = true;
				}
			}

			if (incorrectInt)
				System.out.println("File contains an incorrectly written int");

			if (count == MAX_SIZE)
				System.out
						.println("The file has more than 15 ints. Only the first 15 ints are considered");
		} catch (FileNotFoundException e) {
			System.err.println("File Does Not Exist!");
		}
		return theArray;
	}
} // MyFile

