package coop8200_a1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Coop8200_a1 {

	static void parity() {
		Scanner keyboard = new Scanner(System.in);

		int x = 0;
		int r = 0;

		System.out.print("Enter a positive interger, (0 to quit): ");
		x = keyboard.nextInt();

		while (x != 0) {

			if (x < 0)
				System.out.println("Invalid Output!");

			else {
				r = x % 2;
				if (r == 0)
					System.out.println(x + " is even.");
				else
					System.out.println(x + " is odd.");
			}

			System.out.print("Enter a positive interger, (0 to quit): ");
			x = keyboard.nextInt();

		}

		System.out.println("Congratulations, you passed the first test");

	}

	static void findPair() {

		Scanner keyboard = new Scanner(System.in);

		int y = 0;
		int a = 0;
		int b = 0;

		try {
			Scanner infile = new Scanner(new File("myIntegers.txt"));
			System.out.println("file opened successfully");

			System.out.print("Enter a positive interger: ");
			y = keyboard.nextInt();

			if (y < 0)
				System.out.println("Invalid Output!");

			else {

				a = infile.nextInt();

				while (infile.hasNext() == true) {
					b = infile.nextInt();

					if (y == a + b) {
						System.out.println("a pair is found: " + a + " and "
								+ b + " add to " + y);
						break;
					}
				}
				if (infile.hasNext() == false)
					System.out.println("no pair in the file adds to " + y);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
	}

	private static String string(int b) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		parity();
		findPair();
	}
}
