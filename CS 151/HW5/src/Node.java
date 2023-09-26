/*
 * Ahmed Elgendy
 * CS-152
 * HW 5 part 1
 */
public class Node implements NodeInterface {

  protected int data;
  protected Node next;

  public Node() {
    this.data = 0;
    this.next = null;
  }

  // getter and setter for the data variable
  public int getData() {
    return data;
  }


  public void setData(int data) {
    this.data = data;
  }

  // true if there is a next node, or false if not
  public boolean hasNext() {
    Node temp = this.next;
    if (temp == null) {
      return false;
    }
    return true;
  }

  // returns the number of nodes in the list. The head
  // node is an access point and is NOT the first node
  // in the list.
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


  // newNode is inserted at position paramenter,
  // or at position 0 if a negative position is given,
  // or at the end of the list if position is more than length.
  public void insert(Node tempNode, int position) {
    if (position < 0) {
      position = 0;
    }
    Node newNode = new Node();
    newNode.data = tempNode.data;
    Node temp = this;
    int index = 0;
    while (temp.next != null && index < position) {
      temp = temp.next;
      index++;
    }
    newNode.next = temp.next;
    temp.next = newNode;
  }

  // same, but creates a new node from the data parameter
  public void insert(int data, int position) {
    Node newNode = new Node();
    newNode.data = data;
    insert(newNode, position);
  }

  // delete the node at position, and return the deleted node
  // ...position negative or beyond length returns null
  // without creating an exception
  public Node delete(int position) {
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

  // prints the data in each node, one line, comma separated
  public void print() {
    Node temp = this;
    while (temp.hasNext()) {
      temp = temp.next;
      System.out.print(temp.data);
      if (temp.hasNext()) {
        System.out.print(", ");
      }
    }
    System.out.println();
  }

  // prints the list with a new line character after
  public void println() {
    print();
    System.out.println();

  }

  // Push adds node to the top of the stack.
  public void push(Node tempNode) {
    Node newNode = new Node();
    newNode.data = tempNode.data;
    Node temp = this;
    newNode.next = temp.next;
    temp.next = newNode;
  }

  // Pop removes and returns node from the top of the stack
  public Node pop() {
    if (this.next == null) {
      return null;
    }
    Node temp = this;
    Node removedNode = temp.next;
    temp.next = temp.next.next;
    return removedNode;
  }

  // Peek returns but does not remove node from the top of the stack
  public Node peek() {
    Node temp = this.next;
    if (temp == null) {
      return null;
    }
    return temp;
  }

  // Size returns number of nodes in the stack
  public int size() {
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

  // isEmpty True if stack size==0, False if stack size>0
  public boolean isEmpty() {
    if (this.size() == 0) {
      return true;
    } else {
      return false;
    }
  }
}


