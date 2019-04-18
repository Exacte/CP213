package coop8200_a3;

public class Driver {
	public static void main(String[] args) {
		MyFile file = new MyFile("myIntergers.txt");
		file.printFile();
		System.out.println("");
		
		file.findPair(589);
		System.out.println("");
		
		file.findPair(23);
		System.out.println("");
		
		MyFile file2 = new MyFile("file2.txt");
		file2.findPair(22);
		System.out.println("");
		
		file2.printFile();
	}
}
