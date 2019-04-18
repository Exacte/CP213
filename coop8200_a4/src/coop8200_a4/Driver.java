package coop8200_a4;

public class Driver {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JumpIt game4 = new JumpIt("file4.txt");
		game4.printGame();
		System.out.println("play game");
		try {
			System.out.println("the cost is " + game4.play());
			System.out.println("");
		} catch (BadInputException e) {
			System.out.println("bad input: the first int must be 0");
		}
		JumpIt game3 = new JumpIt("file3.txt");
		game3.printGame();
		System.out.println("play game");
		try {
			System.out.println("the cost is " + game3.play());
			System.out.println("");
		} catch (BadInputException e) {
			System.out.println("bad input: the first int must be 0");
		}
		JumpIt game1 = new JumpIt("myIntegers.txt");
		game1.printGame();
		System.out.println("play game");
		try {
			System.out.println("the cost is " + game1.play());
			System.out.println("");
		} catch (BadInputException e) {
			System.out.println("bad input: the first int must be 0");
		}
	}
}
