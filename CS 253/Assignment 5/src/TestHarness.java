public class TestHarness {
  public static void main(String[] args) {

    BinaryTree tree = new BinaryTree();

    System.out.println("Input a fully parenthesized arithmetic expression: ");

    tree.build();

    System.out.println("Print tree in inorder traversal: ");
    tree.inorderPrint();

    System.out.println("\nPrint tree in postorder traversal:");
    tree.postPrint();

    System.out.println("\nPrint tree in preorder traversal:");
    tree.prePrint();

    System.out.println("\nThe root of the tree is: " + tree.getRoot().getData());
  }
}

