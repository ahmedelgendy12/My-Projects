/*
 * Ahmed Elgendy
 * CS-253
 * Assignment 1
 */
public class Node {
	
	protected Node next;
	private String name;
	private int score;
	//Constructor
	public Node() {
		this.name = "";
		this.score = 0;
		this.next = null;
	}
	public String getName() {
		return name;
	}
	

	public int getScore() {
		return score;
	}


	

	 // prints the data in each node, one line, comma separated
	  public void print(Node this) {
	    Node temp = this;
	    while (temp.hasNext()) {
	      temp = temp.next;
	      System.out.print(temp.name + " " + temp.score);
	      if (temp.hasNext()) {
	        System.out.print(", ");
	      }
	    }
	    System.out.println();
	  }
	  
	// true if there is a next node, or false if not
	public boolean hasNext() {
		Node temp = this.next;
		if (temp == null) {
			return false;
		}
		return true;
	}

	// newNode is inserted at position paramenter,
	public void add(Node tempNode, int position) {
		if (position < 0) {
			position = 0;
		}
		Node newNode = new Node();
		newNode.score = tempNode.score;
		newNode.name = tempNode.name;

		Node temp = this;
		int index = 0;
		while (temp.next != null && index < position) {
			temp = temp.next;
			index++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}

	// delete the node at position, and return the removed node

	public Node remove(int position) {
		if (this.next == null) {
			return null;
		}
		Node temp = this;
		int index = 0;
		while (index < position && temp.next.next != null) {
			temp = temp.next;
			index++;
		}
		Node removedNode = temp.next;
		temp.next = temp.next.next;
		return removedNode;
   
	}
	// Adds the Node at position
	public void add(String name, int score, int position) {
		Node newNode = new Node();
		newNode.name = name;
		newNode.score = score;
		if (position < 0) {
			position = 0;
		}

		Node temp = this;
		int index = 0;
		while (temp.next != null && index < position) {
			temp = temp.next;
			index++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}
	// Adds Node sorted at position
	public void addSorted(String name, int score) {
		Node newNode = new Node();
		newNode.name = name;
		newNode.score = score;
		
		Node temp = this;
		int index = 0;
		while (temp.next != null && newNode.score <= temp.next.score) {
			temp = temp.next;
			index++;
			
		}
		newNode.next = temp.next;
		temp.next = newNode;
		if (this.length() > 10) {
		remove(this.length());
		}
	}
	  
	// Gets length of list
	  public int length() {
		    int count = 0;
		    Node temp = this.next;
		    while (this.hasNext()) {
		      if (temp == null) {
		        return count;
		      }
		      count++;
		      temp = temp.next;
		    }
		    return count;
		  }
}

