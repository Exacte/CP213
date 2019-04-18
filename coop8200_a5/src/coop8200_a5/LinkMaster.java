package coop8200_a5;

/**
 * 
 * @author mason
 *
 * A Linked list class
 *
 * @param <T>- A suitor object.
 */
public class LinkMaster<T> {
	/**
	 * 
	 * @author mason
	 *
	 * @param <T>- A suitor object.
	 */
	private class Node<T> {
		private T data;
		private Node<T> link;
		
		/**
		 * Constructor for a node.
		 */
		public Node() {
			data = null;
			link = null;
		}
		/**
		 * Constructor for a node
		 * @param newData- Data to be put into the node.
		 * @param linkValue- The position link for the node.
		 */
		public Node(T newData, Node<T> linkValue){
			data = newData;
			link = linkValue;
		}
	} // end class Node

	private Node<T> head;
	
	/**
	 * initializes the head of the linked list.
	 */
	public LinkMaster() {
		head = null;
	}

	/**
	 * Adds a node to the begining of the list
	 * 
	 * @param itemData- The Suitor node to be added to the list
	 */
	public void addToStart(T itemData){
		head = new Node<T>(itemData, head);
	}
	
	/**
	 * A simulation that deletes every third suitor from the list.
	 * Also prints which suitor is to be deleted and
	 * prints the list after each suitor is deleted.
	 */
	public void suitorSimulation(){
		LinkMasterIterator i = new LinkMasterIterator();
		int counter = 1;
		while(size() != 1){
			if (!i.hasNext()){
				i.restart();
			}
			else {
				if (counter == 3){
					counter = 1;
					System.out.println("Eliminate Suitor # " + i.peek());
					
					i.delete();
					outputList();
					
					if (!i.hasNext()){
						i.restart();
					}
					else{
						counter++;
						i.next();
					}	
				}
				else {
					counter++;
					i.next();
				}
			}
		}
	}
	
	/**
	 * Prints the winning suitor to the console.
	 */
	public void printWinningPosition() {
		suitorSimulation();
		System.out.println("The winning position is: " + head.data);
	}
	
	/**
	 * Prints the current state of the linked list.
	 */
	public void outputList() {
		Node<T> position = head;
		while(position != null){
			System.out.print(position.data + " ");
			position = position.link;
		}
		System.out.println("");
	}
	
	/**
	 * This method determines the size of the list
	 * @return count- The size of the list
	 */
	public int size(){
		int count = 0;
		Node<T> position = head;
		while (position != null){
			count++;
			position = position.link;
		}
		return count;
	}
	
	/**
	 * 
	 * @author mason
	 *
	 * An Iterator.
	 */
 	public class LinkMasterIterator{
		private Node<T> position;
		private Node<T> previous;
		
		/**
		 * Constructor for the Iterator.
		 */
		public LinkMasterIterator(){
			position = head;
			previous = null;
		}
		
		/**
		 * This method restarts the Iterator from
		 * the begining of the the list.
		 */
		public void restart(){
			position = head;
			previous = null;
		}
		
		/**
		 * This method moves the interator through the Linked list
		 * one object at a time.
		 * 
		 * @return toReturn- The next position in the Liked list.
		 */
		public Object next(){
			Object toReturn = position.data;
			previous = position;
			position = position.link;
			return toReturn;
		}
		
		/**
		 * @return A boolen on weither the Linked list has a next object.
		 */
		public boolean hasNext(){

			return(position != null);
		}
		
		/**
		 * Looks at the current position of the interator.
		 * @return The current position of the Iterator
		 */
		public Object peek(){
			return position.data;
		}
		
		/**
		 * Deletes node in the Linked list at the current
		 * position the iterator is at.
		 */
		public void delete(){
			if (previous != null){
				previous.link = position.link;
				position = position.link;
			}
			else{
				head = head.link;
			}
		}
	}
}// end LinkedList3