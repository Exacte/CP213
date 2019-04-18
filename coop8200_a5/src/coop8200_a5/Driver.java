package coop8200_a5;

public class Driver {
	public static void addToList(LinkMaster<Suitor> L, int n) {
		for(int i=0; i<n; i++){
			Suitor s = new Suitor(n-i);
			L.addToStart(s);
		}
	}

	public static void main(String[] args) {
		LinkMaster<Suitor> list = new LinkMaster<Suitor>();
		addToList(list, 7);
		System.out.println("The list of suitors");
		list.outputList();
		System.out.println("O LinkMaster, please tell me the winning position");
		list.printWinningPosition();
	}
}