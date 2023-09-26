/*
 * Ahmed Elgendy
 * CS-152
 * HW 5 part 2
 */
public class testStack extends Node {
  public static void main(String[] args) {
    // create 4 nodes plus the head
    Node stack = new Node();
    Node temp = new Node();
    temp.data = 2;
    Node temp2 = new Node();
    temp2.data = 3;
    Node temp3 = new Node();
    temp3.data = 7;
    Node temp4 = new Node();
    temp4.data = 9;
    // pushing 4 stacks
    stack.push(temp);
    stack.push(temp2);
    stack.push(temp3);
    stack.push(temp4);
    stack.print();
    System.out.println("Peek: " + stack.peek().data);
    System.out.println("Size: " + stack.size());
    System.out.println("isEmpty: " + stack.isEmpty());
    // pop 1 stack
    stack.pop();
    stack.print();
    // pop 2 stack
    stack.pop();
    stack.pop();
    stack.print();
    // pop 3 stack
    stack.pop();
    System.out.println("isEmpty: " + stack.isEmpty());
    stack.pop();
  }
}
