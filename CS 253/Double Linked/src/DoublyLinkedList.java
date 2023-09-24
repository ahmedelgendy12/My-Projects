public class DoublyLinkedList{
	
	public static class Node{
		protected Node prev;
		protected Node next;
		private String name;
		private int score;
		public Node() {
			this.prev = null;
			this.next = null;
			this.name = "";
			this.score = 0;
		}
		public String getName() {
			return name;
		}
		public int getScore() {
			return score;
		}

	}
	public Node head;
	public Node tail;
	private int size = 0;
	//Constructor
	public DoublyLinkedList(){
		head = new Node();
		tail = head;
		head.next = null;
		head.prev = null;
		tail.prev = head;
		tail.next = null;
	}
	
	// returns size of list
		public int size () {
			return size;
		}
		
		//add node at beginning of the list
		public void addBegNode(String name, int score) {
			Node newNode = new Node();
			newNode.name = name;
			newNode.score = score;
			addBegNode(newNode);
		}
		public void addBegNode(Node newNode) {
			newNode.next = head.next;
			head.next = newNode;
			newNode.prev = head;
			size++;
		}
		
		//add node at end of the list
		public void addEndNode(String name, int score) {
			Node newNode = new Node();
			newNode.name = name;
			newNode.score = score;
			addEndNode(newNode);
		}
			
		public void addEndNode(Node newNode) {
			tail.next = newNode; 
			 newNode.prev = tail;    
			 tail = newNode;   
			 tail.next = null; 
			size++;
		}
		
		
		//Adds a node in between two specified nodes
		public void addBetween(int score, String name, Node pre, Node post) {
			Node temp = new Node();
			temp.score = score;
			temp.name = name;
			addBetween(temp,pre,post);
			
		}
		public void addBetween(Node newest, Node pre, Node post) {
		newest.prev = pre;
		newest.next = post;
			pre.next = newest;
			post.prev = newest;
			size++;
		}

		
		// removes the last node from the list
		public void removeLastNode() {
			tail = tail.prev;
			size--;
}
	
		
		 // prints the data in each node, one line, comma separated
		  public void print() {
		
			  Node temp = head.next;
			  if (head == null) {
				  System.out.println("Empty!");
			  } else {
				  while (temp.next != null) {
					  
					  System.out.print(temp.name + " " + temp.score);
				      if (temp.next != null) {
				        System.out.print(", ");
				      }
				      temp = temp.next;
				    }
				    System.out.println();
				  }
			}
		  
		  // adds the Game entry in the right sorted position
		  public void add (String name, int score) {
				Node newNode = new Node();
				newNode.name = name;
				newNode.score = score;
				Node temp = head.next;
				if(head.next == null || newNode.score >= temp.score ) {
				addBegNode(newNode);
				} else if (newNode.score <= tail.score || temp.next == null ) {
					addEndNode(newNode);
				} else {
					while (temp.next.next != null && newNode.score < temp.next.score) {
						temp = temp.next;
					}
					addBetween(newNode,temp, temp.next);
				}
					if (size >= 10) {
					removeLastNode();
					}
				}
				
				

		  
		  }
		  
		


