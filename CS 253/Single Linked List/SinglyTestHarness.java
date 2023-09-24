
public class SinglyTestHarness {

	// create the Node with the length
		public static Node board(int length) {
		    Node board = new Node();
		    for (int count = 0; count < length; count++) {
		      int score = 0;
		      board.add("a",score, 0);
		  }
			return board;
		}
		

	
	public static void main(String[] args) {
		//Single Linked List test
		Node sLink = board(10);
		System.out.println("Game Board: Singly Linked List");

		for (int count = 0; count <= 12; count++) {
				int score = (int) (Math.random() * 100);
				sLink.addSorted("Team" ,score);
		}
			sLink.print();
			
	}

}
	