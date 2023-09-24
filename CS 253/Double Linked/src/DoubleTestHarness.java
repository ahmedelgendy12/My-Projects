
public class DoubleTestHarness {			
	
		
	
	public static void main(String[] args) {
		// Doubly Linked List test
	DoublyLinkedList dLink = new DoublyLinkedList();
		for (int count = 0; count <= 13; count++) {
				int score = (int) (Math.random() * 100);
				dLink.add("Team" ,score);
		}
		System.out.println("Game Board: Doubly Linked List");
			dLink.print();
	}

}
