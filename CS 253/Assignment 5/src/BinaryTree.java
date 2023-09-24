import java.util.Scanner;

public class BinaryTree {
  public Node root;
  private Scanner input;

  // constructor
  public BinaryTree() {
    this.root = null;
    input = new Scanner(System.in);
  }


  public Node getRoot() {
    return root;
  }

  // checks if root !null and calls method prePrint
  public void prePrint() {
    if (root != null) {
      prePrint(root);
    }
  }

  // prints the the tree in pre order
  public void prePrint(Node node) {
    if (node != null) {
      System.out.print(node.data + " ");
      prePrint(node.left);
      prePrint(node.right);
    }
  }

  // checks if root !null and calls method postPrint
  public void postPrint() {
    if (root != null) {
      postPrint(root);
    }
  }

  // prints the the tree in post order
  public void postPrint(Node root) {
    if (root != null) {
      postPrint(root.left);
      postPrint(root.right);
      System.out.print(root.data + " ");
    }
  }

  // checks if root !null and calls inorderPrint method
  public void inorderPrint() {
    if (root != null) {
      inorderPrint(root);
    }
  }

  // print tree in order
  public void inorderPrint(Node root) {
    if (root.left == null && root.right == null)
      System.out.print(root.data);
    else {
      inorderPrint(root.left);
      System.out.print(" " + root.data + " ");
      inorderPrint(root.right);
    }
  }


  public void build() {
    // call in buildTree() method
    root = buildTree();

  }

  public Node buildTree() {
    Node node = new Node('0');

    // find first character
    char ch = input.findInLine("(\\S)").charAt(0);
    if ((ch >= '0') && (ch <= 'z')) {
      // if its a number or a charater add to leaf node
      node.data = ch;
      node.right = null;
      node.left = null;
    } else if (ch == '(') {
      // call the tree recursively to the left and right of the node
      node.left = buildTree();
      node.data = input.findInLine("(\\S)").charAt(0);
      node.right = buildTree();
      ch = input.findInLine("(\\S)").charAt(0);
    } else {
    }
    return node;
  }

}


class Node {
  public char data;
  public Node left;
  public Node right;

  // constructor
  public Node(char data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public char getData() {
    return data;
  }

}


