/*
 * @author Jeff Blankenship
 * 
 * This class provides Linked List nodes for use in various applications
 * 
 * The head node is an access point only and does NOT contain data. Head.next is
 * the first node of the list. Each node holds an int data.
 * 
 */
public interface NodeInterface {

  // private int data;
  // private Node next;

  // getter and setter for the data variable
  public int getData();

  public void setData(int data);

  // true if there is a next node, or false if not
  public boolean hasNext();

  // returns the number of nodes in the list. The head
  // node is an access point and is NOT the first node
  // in the list.
  public int length();

  // newNode is inserted at position paramenter,
  // or at position 0 if a negative position is given,
  // or at the end of the list if position is more than length.
  public void insert(Node newNode, int position);

  // same, but creates a new node from the data parameter
  public void insert(int data, int position);

  // delete the node at position, and return the deleted node
  // ...position negative or beyond length returns null
  // without creating an exception
  public Node delete(int position);

  // prints the data in each node, one line, comma separated
  public void print();

  // prints the list with a new line character after
  public void println();

}
