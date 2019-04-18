package coop8200_a3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author mason
 */
public class MyFile {
	private String fileName; // name of the file
	private int count = 0; // number of valid integers in the file
	private final int MAX_SIZE = 10; // the size of the array
	private int[] theArray = new int[MAX_SIZE];
	
	/**
	 * constructor to set the file name
	 * 
	 * @param theName- a name of a file
	 */
	public MyFile(String theName) { // constructor to set the file name
		this.fileName = new String(theName);
	}
	
	/**
	 * log a message on whether two ints in the file add to target
	 * 
	 * @param target- a int used to be found a of.
	 */
	public void findPair(int target) {
		try {
			System.out.println("openning file " + fileName + " ...");
			Scanner infile = new Scanner(new File(fileName));
			int add = 0;
			boolean switchState = false;
			
			makeArray();

			System.out.println("Looking for a pair that adds to " + target);

			for (int i = 0; i < count - 1; i++) {
				for (int j = i + 1; j < count; j++) {
					add = theArray[i] + theArray[j];
					if (add == target && switchState == false) {
						System.out.println("a pair is found: " + target + " = "
								+ theArray[i] + " + " + theArray[j]);
						switchState = true;
					}
				}
			}

			if (switchState == false) {
				System.out.println("no pairs add up to " + target);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}
	
	/**
	 * 
	 * print the content of the file
	 */
	public void printFile() {
		try {
			Scanner infile = new Scanner(new File(fileName));
			System.out.println("openning file " + fileName + " ...");

			System.out.println("Printing content of file " + fileName + " ..");

			while (infile.hasNext()) {
				System.out.println(infile.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
	
	/**
	 * 
	 * Makes an array from a file to be used by the program
	 */
	public void makeArray(){
		boolean incorrectInt = false;
		
		try {
			Scanner infile = new Scanner(new File(fileName));
			
			while (infile.hasNext() && count != MAX_SIZE) {
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
						.println("The file has more than 10 ints. Only the first 10 ints are considered");
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
} // MyFile 